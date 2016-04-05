package ar.edu.itba.paw.webapp.controllers;

import ar.edu.itba.paw.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.itba.paw.services.UserService;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignupController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/signup")
    public ModelAndView signUp() {
        final ModelAndView mav = new ModelAndView("signup");
        return mav;
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String registerAction(@RequestParam(value="password", required=true) String password,
                                 @RequestParam(value="username", required=true) String username,
                                 @RequestParam(value="firstName", required=true) String firstName,
                                 @RequestParam(value="lastName", required=true) String lastName,
                                 @RequestParam(value="email", required=true) String email) {

        User user = userService.register(username, password, email, firstName, lastName);

        return "redirect:" + "/user/" + user.getUsername();
    }
}
