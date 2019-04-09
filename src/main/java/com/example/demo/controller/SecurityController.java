package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	@GetMapping("/*")
	public String login() {
		return "login";
	}
	@GetMapping("/lo")
	public String login1() {
		return "lo";
	}
}
