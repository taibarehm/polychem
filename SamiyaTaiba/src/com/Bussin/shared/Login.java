package com.Bussin.shared;

import java.io.Serializable;

public class Login implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String pass;

}
