package ar.edu.itba.paw.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.itba.paw.services.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/register")  
	public String register(@RequestParam(value="username", required=true, defaultValue="lsoncini") String username,
			@RequestParam(value="password", required=true, defaultValue="1234") String password,
			@RequestParam(value="firstName", required=true, defaultValue="Lucas") String firstName,
			@RequestParam(value="lastName", required=true, defaultValue="Soncini") String lastName,
			@RequestParam(value="email", required=true, defaultValue="blabla@hotmail.com") String email,
			@RequestParam(value="id", required=true, defaultValue="7") String id, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("email", email);
        model.addAttribute("id", id);
        
        userService.register(username, password, email, firstName, lastName, id);
        
        return "register";
    }
}
