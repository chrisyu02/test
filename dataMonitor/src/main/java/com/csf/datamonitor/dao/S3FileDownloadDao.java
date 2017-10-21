package com.csf.datamonitor.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.csf.datamonitor.common.AmazonS3Helper;
import com.google.common.collect.Lists;

public class S3FileDownloadDao {
	Logger log = Logger.getLogger(getClass());
	
	private final static String FULL_PATH = "f:\\s3file\\dange";
	private Stack<String> getTables() {
		Stack<String> tables = new Stack<String>();
		InputStream is = S3FileDownloadDao.class.getResourceAsStream("/table.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		try {
			while ((line = br.readLine()) != null) {
				if (!StringUtils.isBlank(line)) {
					tables.add(line.trim());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.info("读取table.txt文件出错了" + e);
		}
		return tables;
	}

	public InputStream downloadFile(String tableName) {
		String key = tableName + "/" + "full";
		List<String> listObjects = AmazonS3Helper.listObjects(key);
		List<String> endWithZip = Lists.newArrayList();
		for (String s : listObjects) {
			if (!StringUtils.isBlank(s) && s.toLowerCase().endsWith("zip"))
				endWithZip.add(s);
		}

		if (endWithZip == null || endWithZip.size() == 0)
			return null;
		endWithZip.sort(new Comparator<String>() {

			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}

		});

		String lastZipFile = null;
		if (endWithZip != null && endWithZip.size() > 0) {
			lastZipFile = endWithZip.get(endWithZip.size() - 1);
		}

		key = key + "/" + lastZipFile.substring(0, lastZipFile.length() - tableName.length() - 4);
		return downloadFile(tableName, key);
	}

	public InputStream downloadFile(String tableName, String prefix) {

		if (!prefix.endsWith("/")) {
			prefix = prefix + "/";
		}
		String key = prefix + tableName + ".zip";

		InputStream is = null;
		
		is = AmazonS3Helper.getObjects(key);

		return is;
	}

	public void downloadFile() {
		final Stack<String> tables = getTables();
		if (tables == null || tables.size() == 0)
			return;
		new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				while (tables.size() > 0) {
					String tableName = tables.pop();
					InputStream is = downloadFile(tableName);
					writeToFile(is, tableName);
				}
			}

		}).start();
	}

	private void writeToFile(InputStream is, String tableName) {
		String path = FULL_PATH;
		File filePath = new File(path);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}

		File file = new File(path + File.separator + tableName + ".zip");
		byte[] buffer = new byte[1024];
		int len = 0;
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
		} catch (Exception e) {
			log.error("下載文件然后写文件出问题");
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
