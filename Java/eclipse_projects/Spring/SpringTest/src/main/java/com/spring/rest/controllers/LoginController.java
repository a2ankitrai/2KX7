package com.spring.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	 @RequestMapping("/login")
	    public String greeting() {
	        return "enter credentials";
	    }
}
