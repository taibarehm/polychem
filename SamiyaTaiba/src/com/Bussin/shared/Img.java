package com.Bussin.shared;
import java.io.Serializable;
public class Img implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String img;
	public String getSat() {
		return img;
	}
	public void setSat(String sat) {
		this.img = sat;
	}
	

}
