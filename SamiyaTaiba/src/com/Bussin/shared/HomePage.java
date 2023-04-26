package com.Bussin.shared;

import java.io.Serializable;

public class HomePage implements Serializable {
	private static final long serialVersionUID = 1L;

	public String Name;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDetail() {
		return Detail;
	}
	public void setDetail(String detail) {
		Detail = detail;
	}
	public int getCost() {
		return Cost;
	}
	public void setCost(int cost) {
		Cost = cost;
	}
	public String Detail;
	public int Cost;

}
