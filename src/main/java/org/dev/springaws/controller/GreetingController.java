package org.dev.springaws.controller;

import org.dev.springaws.service.DynamoDBEnhanced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @Autowired
    private final DynamoDBEnhanced dynamoDBEnhanced;

    @Autowired
    private final PublishTextMessage msg;

    @GetMapping("/")
    public String greetingForm(Model model){
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

}
