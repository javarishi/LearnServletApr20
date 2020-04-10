package com.h2k.web.util;

public class CompareFour {

	public static void main(String[] args) {
		int var1 = 100;
		int var2 = 400;
		int var3 = 400;
		int var4 = 400;
		int greater = 0;
		
		if(var1 > var2 && var1 > var3 && var1 > var4) {
			greater = var1;
		}else if(var2 > var3 && var2 > var4) {
			greater = var2;
		}else if (var3 > var4) {
			greater = var3;
		}else {
			greater = var4;
		}
		System.out.println(greater);
		
		

	}

}
