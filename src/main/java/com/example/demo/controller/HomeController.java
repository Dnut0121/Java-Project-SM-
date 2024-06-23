package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
    @GetMapping("/")
    public String index() {
        return "index";
    }

	/*
	 * @GetMapping("/nike") public String nike() { return "nike"; }
	 * 
	 * @GetMapping("/adidas") public String adidas() { return "adidas"; }
	 * 
	 * @GetMapping("/converse") public String converse() { return "converse"; }
	 * 
	 * @GetMapping("/nb") public String nb() { return "nb"; }
	 */
}
