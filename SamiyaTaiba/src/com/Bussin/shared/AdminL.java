package com.Bussin.shared;

import java.io.Serializable;

public class AdminL implements Serializable {
	private static final long serialVersionUID = 1L;

	

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDetail() {
		return Detail;
	}
	public void setDetail(String detail) {
		Detail = detail;
	}
	public String getCost() {
		return Cost;
	}
	public void setCost(String cost) {
		Cost = cost;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String ID;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String Name;
	public String img;
	public String Detail;
	public String Cost;
}
