package com.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
	
@RequestMapping("/test")	
public String test() {
	
	System.out.println(" Project Work ");
	
	return "home";
}
	
}
