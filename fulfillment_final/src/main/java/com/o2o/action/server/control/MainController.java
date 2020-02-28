package com.o2o.action.server.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String mainIndex(Model model) {
		return "index";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@GetMapping("/channel")
	public String channel(Model model) {
		return "channel";
	}

	@GetMapping("/product")
	public String product(Model model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("id"));
		model.addAttribute("productId", request.getParameter("id"));
		return "product";
	}
}
