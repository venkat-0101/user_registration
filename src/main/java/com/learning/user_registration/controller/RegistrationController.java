package com.learning.user_registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.user_registration.model.Registration;
import com.learning.user_registration.service.RegistrationService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/users")
public class RegistrationController {


    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/register")
    public String registerUser(){
        return "register_form";
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Registration user) {
        try{
            if(!registrationService.isUserAvailable(user.getEmail()))
            {
            registrationService.registerUser(user);
            return ResponseEntity.ok("User registered successfully");
            }
            else{
                return ResponseEntity.badRequest().body("User already exists");
            }
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST.toString()+" Unable to register user due to the following exception: "+e);
        }
    }

    
    @GetMapping("/user/{email}")
    public String getMethodName(@PathVariable String email, Model model) throws Exception {
        try{
        Registration user = registrationService.getUser(email);
        model.addAttribute("user", user);
        return "homepage";
        }
        catch(Exception e){
         model.addAttribute("email", email);
         return "404_page";
        }
        
    }
    
    
    
    
}
