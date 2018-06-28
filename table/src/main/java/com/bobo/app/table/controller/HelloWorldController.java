package com.bobo.app.table.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@RequestMapping("/hello")
	@ResponseBody
	String index() {
		return "Hello World";
	}
}
