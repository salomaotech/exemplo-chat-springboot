package com.salomaotech.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @GetMapping("/")
    public ModelAndView exibirHome() {

        ModelAndView view = new ModelAndView("Index");
        return view;

    }

    @GetMapping("/chat")
    public ModelAndView exibirChat() {

        ModelAndView view = new ModelAndView("Chat");
        return view;

    }

}
