package com.csf.datamonitor.dao;

import java.util.List;

import javax.ws.rs.DefaultValue;

import org.apache.ibatis.annotations.Param;

import com.csf.datamonitor.entity.BaseStock;

public interface BaseStockDao {

	public List<BaseStock> getBaseStocks(@Param(value = "id") String id, @Param(value = "offset") Integer offset,
			@Param(value = "limit") Integer limit);

	public void addBaseStock(BaseStock t);

	public void updateBaseStock(BaseStock t);

	public void deleteBaseStock(String id);
}
