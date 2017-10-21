package com.csf.datamonitor.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.apache.ibatis.annotations.Param;

import com.csf.datamonitor.common.BaseServiceImpl;
import com.csf.datamonitor.dao.BaseStockDao;
import com.csf.datamonitor.entity.BaseStock;

@Path("/baseStock")
@Produces("application/json")
public class BaseStockService extends BaseServiceImpl{
	private BaseStockDao baseStockDao;
	public BaseStockDao getBaseStockDao() {
		return baseStockDao;
	}
	public void setBaseStockDao(BaseStockDao baseStockDao) {
		this.baseStockDao = baseStockDao;
	}
	@GET
	@Path("/test")
	public String test(@Context HttpServletRequest request, @QueryParam("id") String id, @QueryParam("offset") @DefaultValue("0") Integer offset, @QueryParam("limit") @DefaultValue("10") Integer limit){
		List<BaseStock> stock = baseStockDao.getBaseStocks(null, offset, limit);
		return returnSuccAsJson(stock);
	}

}
