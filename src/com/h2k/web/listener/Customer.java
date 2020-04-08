package com.h2k.web.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Customer implements HttpSessionBindingListener{

	
	private String firstName;
	private String custId;
	private String ssn;
	private String creditCardInfo;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}	
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getCreditCardInfo() {
		return creditCardInfo;
	}
	public void setCreditCardInfo(String creditCardInfo) {
		this.creditCardInfo = creditCardInfo;
	}
	
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("Customer is goining inside the session " );
		setSsn(null);
		setCreditCardInfo(null);
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("Customer is goining outside the session " );
	}
	
	
}
