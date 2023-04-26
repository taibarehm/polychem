package com.Bussin.shared;

import java.io.Serializable;

public class oddercard implements Serializable {
private static final long serialVersionUID = 1L;
public String Address;
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getCity() {
	return City;
}
public void setCity(String city) {
	City = city;
}
public String getState() {
	return State;
}
public void setState(String state) {
	State = state;
}
public String getCountry() {
	return Country;
}
public void setCountry(String country) {
	Country = country;
}
public String getPinCode() {
	return PinCode;
}
public void setPinCode(String pinCode) {
	PinCode = pinCode;
}
public String getPhoneNO() {
	return PhoneNO;
}
public void setPhoneNO(String phoneNO) {
	PhoneNO = phoneNO;
}
public String getPusrchareID() {
	return PusrchareID;
}
public void setPusrchareID(String pusrchareID) {
	PusrchareID = pusrchareID;
}
public String getNAMEOFRODUCT() {
	return NAMEOFRODUCT;
}
public void setNAMEOFRODUCT(String nAMEOFRODUCT) {
	NAMEOFRODUCT = nAMEOFRODUCT;
}
public String getDETAILS() {
	return DETAILS;
}
public void setDETAILS(String dETAILS) {
	DETAILS = dETAILS;
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
public String City ;
public String State;
public String Country;
public String PinCode;
public String PhoneNO;
public String PusrchareID ;
public String NAMEOFRODUCT;
public String DETAILS ;
public String Cost;
}
