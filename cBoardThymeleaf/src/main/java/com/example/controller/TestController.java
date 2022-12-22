package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/hello")
	public void hello(Model m) {
		m.addAttribute("msg","안녕하세요.");
	}
	
	@RequestMapping({"/","index"})
	public void index() {
		
	}
}
