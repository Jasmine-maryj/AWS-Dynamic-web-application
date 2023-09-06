package org.dev.springaws.controller;

import org.dev.springaws.entity.Greeting;
import org.dev.springaws.service.DynamoDBEnhanced;
import org.dev.springaws.service.PublishTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

    @Autowired
    private DynamoDBEnhanced dynamoDBEnhanced;

    @Autowired
    private PublishTextMessage msg;

    @GetMapping("/")
    public String greetingForm(Model model){
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting){
        dynamoDBEnhanced.injectDynamoItem(greeting);
        msg.sendMessage(greeting.getId());
        return "result";
    }
}
