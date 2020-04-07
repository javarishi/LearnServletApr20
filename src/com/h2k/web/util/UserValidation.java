package com.h2k.web.util;

public class UserValidation {

	
	public static boolean authenticateUser(String userName, String password) {
	 		String rightPassword = "pass@" + userName.strip();
			if(password.equals(rightPassword)) {
				return true;
			}else {
				return false;
			}
	}
	
	public static boolean validateUser(String userName, String password) {
		if(userName != null && 
				password != null &&
				userName.strip().length() > 0 && 
				password.strip().length() > 0 ) {
			return true;
		}else {
			return false;
		}
	}
}
