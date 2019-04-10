package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	@GetMapping({"/resources/1"})
	public String login3() {
		return "resources 1";
	}
	@GetMapping({"/resources/2"})
	public String login324() {
		return "resources 2";
	}
	@GetMapping({"/admin/1"})
	public String admin() {
		return "admin 1";
	}
	@GetMapping({"/admin/2"})
	public String admin2() {
		return "admin 2";
	}
	@GetMapping({"/db/1"})
	public String db1() {
		return "db 1";
	}
	@GetMapping({"/db/2"})
	public String db2() {
		return "db 2";
	}
	@PostMapping({"/logout"})
	public String logout() {
		return "logout";
	}
	@GetMapping({"/logoutsuccess"})
	public String logoutsuccess() {
		return "logoutsuccess";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("/about")
	public String login1() {
		return "logout";
	}
}
