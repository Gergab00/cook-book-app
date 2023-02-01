package com.spring.cookbook;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CookbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(CookbookApplication.class, args);
		String hostAddress = "";
		try {
			hostAddress = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	System.out.println("Your app is running at " + hostAddress);
		System.out.println("Hello World! from Spring");
	}

}
