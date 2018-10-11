package com.accp.util;

public class DateUtil {
	
	public static void main(String[] args) {
		
		Color[] col  = Color.values();  //调用构造方法
		Color cole = Color.RED;
		System.out.println(cole);
		System.out.println(cole.getIndex()+cole.getName(cole.getIndex()));
	/*	Color c = Color.RED;
		System.out.println("-------------"+c.getName()+"-----------------"+c.getIndex());
		System.out.println(Color.getName(1));;
		for (Color color : col) {
			System.out.println(color.getName());
			System.out.println(color.getIndex());
			System.out.println(color);
		}
		
		   Light[] allLight = Light.values ();
	    for (Light aLight : allLight) {
	      System. out .println( " 当前灯 name ： " + aLight.name());
	      System. out .println( " 当前灯 ordinal ： " + aLight.ordinal());
	      System. out .println( " 当前灯： " + aLight);
	    }*/
	}

}
