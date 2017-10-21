package com.csf.datamonitor.common;

import java.io.InputStream;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.google.common.collect.Lists;

@SuppressWarnings("deprecation")
public class AmazonS3Helper {

	public static final String AWSACCESSKEYID = "AKIAORA2I6VPIEUGKHDA";

	public static final String AWSSECRETACCESSKEY = "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";

	public static final String FTPBUCKET = "cn.com.chinascope.ftp";

	public static final String SERVICEURL = "http://s3.cn-north-1.amazonaws.com.cn";

	public static final String CONTENTTYPE = "application/zip";

	private static AmazonS3Client s3 = null;

	static {
		AWSCredentials credentials = new BasicAWSCredentials(AWSACCESSKEYID, AWSSECRETACCESSKEY);
		s3 = new AmazonS3Client(credentials);
		Region region = Region.getRegion(Regions.CN_NORTH_1);
		s3.setRegion(region);
	}

	/**
	 * 获取指定key下面的所以对象
	 * 
	 * @param key
	 * @return
	 */
	public static List<String> listObjects(String key) {
		List<String> result = Lists.newArrayList();
		if (!key.endsWith("/")) {
			key = key + "/";
		}
		ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
		listObjectsRequest.setBucketName(FTPBUCKET);
		listObjectsRequest.setPrefix(key);
		//listObjectsRequest.setDelimiter("/");
		ObjectListing objectListing = s3.listObjects(listObjectsRequest);
		List<S3ObjectSummary> objects = objectListing.getObjectSummaries();
		for (S3ObjectSummary sumary : objects) {
			if (!StringUtils.isBlank(sumary.getKey().replace(key, ""))) {
				result.add(sumary.getKey().replace(key, ""));
			}
		}

		return result;
	}

	/**
	 * 获取指定的对象流
	 * @param key
	 * @param objectName
	 * @return
	 */
	public static InputStream getObjects(String key, String objectName) {

		if (!key.endsWith("/")) {
			key = key + "/";
		}
		
		return getObjects(key + objectName);
	}
	
	public static InputStream getObjects(String key){

		GetObjectRequest getObjectRequest = new GetObjectRequest(FTPBUCKET, key);
		S3Object s3Object = s3.getObject(getObjectRequest);
		S3ObjectInputStream s3ObjectInputStream = s3Object.getObjectContent();
		return s3ObjectInputStream;
	}
}
