package com.cg.pp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/ShowHome")
	public String showHome() {
		return "home";
	}

}
