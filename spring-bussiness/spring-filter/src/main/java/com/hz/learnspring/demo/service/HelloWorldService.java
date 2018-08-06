package com.hz.learnspring.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

	public String getHelloMessage() {
		return "Hello World";
	}
	
}
