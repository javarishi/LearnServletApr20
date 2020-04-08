package com.h2k.web.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class TestSessionActivationListener implements HttpSessionActivationListener {

	
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSessionActivationListener.super.sessionWillPassivate(se);
	}
	
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSessionActivationListener.super.sessionDidActivate(se);
		
	}
	
}
