package edu.bu.ist.ci.jenkins;

import java.util.Enumeration;

public class MainClass {
	
	public static void main(String[] args) {
		System.out.println("ARGS:");
		for(String arg : args) {
			System.out.println(arg);
		}
		
		System.out.println();
		
		System.out.println("Environment Variables:");
		for(String key : System.getenv().keySet()) {
			System.out.print(key + " = ");
			System.out.println(System.getenv(key));
		}
		
		System.out.println();
		
		System.out.println("System Variables:");
		Enumeration<?> names = System.getProperties().propertyNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement().toString();
			System.out.print(name + " = ");
			System.out.println(System.getProperty(name));
		}
	}
}
