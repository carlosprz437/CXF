package com.spring.bean;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class DBUSER {

	BigDecimal USER_ID; 
	String USERNAME; 
	String CREATED_BY;
	Date CREATED_DATE;
	
	public BigDecimal getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(BigDecimal bigDecimal) {
		USER_ID = bigDecimal;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getCREATED_BY() {
		return CREATED_BY;
	}
	public void setCREATED_BY(String cREATED_BY) {
		CREATED_BY = cREATED_BY;
	}
	public Date getCREATED_DATE() {
		return CREATED_DATE;
	}
	public void setCREATED_DATE(Date cREATED_DATE) {
		CREATED_DATE = cREATED_DATE;
	}
	
}
