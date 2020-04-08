package com.h2k.web.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class TestServletRequestListener implements ServletRequestListener , ServletRequestAttributeListener{

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println(" TestServletRequestListener :: requestInitialized ");
	}
	
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println(" TestServletRequestListener :: requestDestroyed ");
	}
	
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println(" TestServletRequestListener :: attributeAdded " 
					+ srae.getName() + " Value " + srae.getValue());
	}
	
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println(" TestServletRequestListener :: attributeRemoved " 
				+ srae.getName() + " Value " + srae.getValue());
	}
	
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println(" TestServletRequestListener :: attributeReplaced " 
				+ srae.getName() + "Old Value " + srae.getValue());
	}
	
	
}
