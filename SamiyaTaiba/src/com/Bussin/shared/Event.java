package com.Bussin.shared;

import java.io.Serializable;

public class Event implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String msd;
	public String getMsd() {
		return msd;
	}
	public void setMsd(String msd) {
		this.msd = msd;
	}
	public String Pname;
	
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public String getCost() {
		return Cost;
	}
	public void setCost(String cost) {
		Cost = cost;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getDetail() {
		return Detail;
	}
	public void setDetail(String detail) {
		Detail = detail;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String Cost;
	public String Image;
	public String Detail;

}
