package com.example.userdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.userdata.model.User;
// import com.example.userdata.model.Users;

@Controller
public class UserController {
    @RequestMapping("/hello")
    private String hello() {
        return "hello";
    }

    @RequestMapping("/users")
    @ResponseBody
    public ModelAndView getUsers() {
        String uri = "https://jsonplaceholder.typicode.com/users";
        RestTemplate restTemplate = new RestTemplate();
        User[] users = restTemplate.getForObject(uri, User[].class);

        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", users);

        return modelAndView;
    }

    @RequestMapping("/users/{id}")
    @ResponseBody
    public ModelAndView getUser(@PathVariable int id) {
        String uri = "https://jsonplaceholder.typicode.com/users/{id}";
        // Build the URI with the provided id value
        UriComponents builder = UriComponentsBuilder.fromUriString(uri)
                .buildAndExpand(id);

        RestTemplate restTemplate = new RestTemplate();
        // Use the built URI to retrieve user details
        User user = restTemplate.getForObject(builder.toUriString(), User.class);
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", user);

        return modelAndView;
    }
}
