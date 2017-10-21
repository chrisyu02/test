package com.csf.datamonitor.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;

import com.csf.datamonitor.common.BaseServiceImpl;
import com.csf.datamonitor.dao.S3FileDownloadDao;

@Path("/s3file")
@Produces("application/json")
public class S3FileDownloadService extends BaseServiceImpl {
	private S3FileDownloadDao s3Dao;

	public S3FileDownloadDao getS3Dao() {
		return s3Dao;
	}

	public void setS3Dao(S3FileDownloadDao s3Dao) {
		this.s3Dao = s3Dao;
	}

	@GET
	@Path("/download")
	public Response downloadFile(@Context HttpServletRequest request, @QueryParam("fileName") String fileName,
			@QueryParam("prefix") @DefaultValue("") String prefix) {

		ByteArrayOutputStream bos = null;
		InputStream is = null;
		try {
			if (StringUtils.isBlank(prefix)) {
				is = s3Dao.downloadFile(fileName);
			} else {
				is = s3Dao.downloadFile(fileName, prefix);
			}

			if (is == null)
				return Response.serverError().build();
			bos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len;
			while ((len = is.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}

			return Response.ok(bos.toByteArray(), "application/*")
					.header("Content-Disposition", String.format("attachment; filename=%s.zip", fileName)).build();
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (bos != null) {
				try {
					bos.close();
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
		return Response.serverError().build();
	}

	@GET
	@Path("/download/full/all")
	public String downloadFile(@Context HttpServletRequest request) {
		try {
			s3Dao.downloadFile();
			return this.returnSuccAsJson("");
		} catch (Exception e) {
			log.error(e);
			return this.returnExceptionAsJson(e);
		}
	}
}
