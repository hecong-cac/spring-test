package com.example.springtest;


import com.example.springtest.dao.entity.User;
import com.example.springtest.service.GreetingService;
import com.example.springtest.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

    private final GreetingService service;
    private final UserService userService;

    public GreetingController(GreetingService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @RequestMapping("/greeting")
    @ResponseBody
    public String greeting() {
        return service.greet();
    }

    @RequestMapping("/greeting/{userName}")
    @ResponseBody
    public String greetingToUser(@PathVariable("userName") String userName) {
        User user = userService.getUserByUserName(userName);
        return "Hello :" + user.getName() + " password : " + user.getPassword();
    }

}
