package demo.springboot.controller;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.springboot.domain.User;
import demo.springboot.service.UserService;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	UserService userService;


	@RequestMapping
	@ResponseBody
	public String index() {
		return "Hello! Spring Boot~";
	}


	@RequestMapping(value = { "/user/{id}" }, method = { RequestMethod.GET })
	@ResponseBody
	public User findOne( @PathVariable("id") String id ) throws Exception {
		Future<User> res = userService.findOne(id);
		return res.get(1000, TimeUnit.MILLISECONDS);
	}


	@RequestMapping(value = { "/user" }, method = { RequestMethod.GET })
	@ResponseBody
	public String register( @RequestParam("name") String name ) {
		userService.addUser(name);
		return "success";
	}


	@RequestMapping("/velocity")
	public String velocity( Model model ) {
		model.addAttribute("testparam", "hi boot..");
		return "index";
	}
}
