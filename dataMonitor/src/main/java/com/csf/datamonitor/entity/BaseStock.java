package com.csf.datamonitor.entity;

import java.util.Date;

public class BaseStock {
	private String id;
	private String code;
	private String tick;
	private String orgid;
	private String adr;
	private String rat;
	private String abbr_en;
	private String abbr_szh;
	private String abbr_py;
	private String mkt_code;
	private String mkt_en;
	private String mkt_szh;
	private String ls_code;
	private Date ls_dt;
	private Date ls_edt;
	private Date create_time;
	private Date update_time;
	private Date insert_time;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTick() {
		return tick;
	}
	public void setTick(String tick) {
		this.tick = tick;
	}
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public String getAdr() {
		return adr;
	}
	public void setAdr(String adr) {
		this.adr = adr;
	}
	public String getRat() {
		return rat;
	}
	public void setRat(String rat) {
		this.rat = rat;
	}
	public String getAbbr_en() {
		return abbr_en;
	}
	public void setAbbr_en(String abbr_en) {
		this.abbr_en = abbr_en;
	}
	public String getAbbr_szh() {
		return abbr_szh;
	}
	public void setAbbr_szh(String abbr_szh) {
		this.abbr_szh = abbr_szh;
	}
	public String getAbbr_py() {
		return abbr_py;
	}
	public void setAbbr_py(String abbr_py) {
		this.abbr_py = abbr_py;
	}
	public String getMkt_code() {
		return mkt_code;
	}
	public void setMkt_code(String mkt_code) {
		this.mkt_code = mkt_code;
	}
	public String getMkt_en() {
		return mkt_en;
	}
	public void setMkt_en(String mkt_en) {
		this.mkt_en = mkt_en;
	}
	public String getMkt_szh() {
		return mkt_szh;
	}
	public void setMkt_szh(String mkt_szh) {
		this.mkt_szh = mkt_szh;
	}
	public String getLs_code() {
		return ls_code;
	}
	public void setLs_code(String ls_code) {
		this.ls_code = ls_code;
	}
	public Date getLs_dt() {
		return ls_dt;
	}
	public void setLs_dt(Date ls_dt) {
		this.ls_dt = ls_dt;
	}
	public Date getLs_edt() {
		return ls_edt;
	}
	public void setLs_edt(Date ls_edt) {
		this.ls_edt = ls_edt;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public Date getInsert_time() {
		return insert_time;
	}
	public void setInsert_time(Date insert_time) {
		this.insert_time = insert_time;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abbr_en == null) ? 0 : abbr_en.hashCode());
		result = prime * result + ((abbr_py == null) ? 0 : abbr_py.hashCode());
		result = prime * result + ((abbr_szh == null) ? 0 : abbr_szh.hashCode());
		result = prime * result + ((adr == null) ? 0 : adr.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((create_time == null) ? 0 : create_time.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((insert_time == null) ? 0 : insert_time.hashCode());
		result = prime * result + ((ls_code == null) ? 0 : ls_code.hashCode());
		result = prime * result + ((ls_dt == null) ? 0 : ls_dt.hashCode());
		result = prime * result + ((ls_edt == null) ? 0 : ls_edt.hashCode());
		result = prime * result + ((mkt_code == null) ? 0 : mkt_code.hashCode());
		result = prime * result + ((mkt_en == null) ? 0 : mkt_en.hashCode());
		result = prime * result + ((mkt_szh == null) ? 0 : mkt_szh.hashCode());
		result = prime * result + ((orgid == null) ? 0 : orgid.hashCode());
		result = prime * result + ((rat == null) ? 0 : rat.hashCode());
		result = prime * result + ((tick == null) ? 0 : tick.hashCode());
		result = prime * result + ((update_time == null) ? 0 : update_time.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseStock other = (BaseStock) obj;
		if (abbr_en == null) {
			if (other.abbr_en != null)
				return false;
		} else if (!abbr_en.equals(other.abbr_en))
			return false;
		if (abbr_py == null) {
			if (other.abbr_py != null)
				return false;
		} else if (!abbr_py.equals(other.abbr_py))
			return false;
		if (abbr_szh == null) {
			if (other.abbr_szh != null)
				return false;
		} else if (!abbr_szh.equals(other.abbr_szh))
			return false;
		if (adr == null) {
			if (other.adr != null)
				return false;
		} else if (!adr.equals(other.adr))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (create_time == null) {
			if (other.create_time != null)
				return false;
		} else if (!create_time.equals(other.create_time))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (insert_time == null) {
			if (other.insert_time != null)
				return false;
		} else if (!insert_time.equals(other.insert_time))
			return false;
		if (ls_code == null) {
			if (other.ls_code != null)
				return false;
		} else if (!ls_code.equals(other.ls_code))
			return false;
		if (ls_dt == null) {
			if (other.ls_dt != null)
				return false;
		} else if (!ls_dt.equals(other.ls_dt))
			return false;
		if (ls_edt == null) {
			if (other.ls_edt != null)
				return false;
		} else if (!ls_edt.equals(other.ls_edt))
			return false;
		if (mkt_code == null) {
			if (other.mkt_code != null)
				return false;
		} else if (!mkt_code.equals(other.mkt_code))
			return false;
		if (mkt_en == null) {
			if (other.mkt_en != null)
				return false;
		} else if (!mkt_en.equals(other.mkt_en))
			return false;
		if (mkt_szh == null) {
			if (other.mkt_szh != null)
				return false;
		} else if (!mkt_szh.equals(other.mkt_szh))
			return false;
		if (orgid == null) {
			if (other.orgid != null)
				return false;
		} else if (!orgid.equals(other.orgid))
			return false;
		if (rat == null) {
			if (other.rat != null)
				return false;
		} else if (!rat.equals(other.rat))
			return false;
		if (tick == null) {
			if (other.tick != null)
				return false;
		} else if (!tick.equals(other.tick))
			return false;
		if (update_time == null) {
			if (other.update_time != null)
				return false;
		} else if (!update_time.equals(other.update_time))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BaseStock [id=" + id + ", code=" + code + ", tick=" + tick + ", orgid=" + orgid + ", adr=" + adr
				+ ", rat=" + rat + ", abbr_en=" + abbr_en + ", abbr_szh=" + abbr_szh + ", abbr_py=" + abbr_py
				+ ", mkt_code=" + mkt_code + ", mkt_en=" + mkt_en + ", mkt_szh=" + mkt_szh + ", ls_code=" + ls_code
				+ ", ls_dt=" + ls_dt + ", ls_edt=" + ls_edt + ", create_time=" + create_time + ", update_time="
				+ update_time + ", insert_time=" + insert_time + "]";
	}
	
}
