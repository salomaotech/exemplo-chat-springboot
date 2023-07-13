package com.salomaotech.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @GetMapping("/")
    public ModelAndView exibirHome() {

        ModelAndView view = new ModelAndView("Index");
        return view;

    }

    @PostMapping("/logar")
    public ModelAndView acessarChat(@RequestParam("apelido") String apelidoParametro) {

        if (!apelidoParametro.equals("")) {

            ModelAndView view = new ModelAndView("redirect:/chat?apelido=" + apelidoParametro);
            return view;

        } else {

            return new ModelAndView("redirect:/");

        }

    }

    @GetMapping("/chat")
    public ModelAndView exibirChat() {

        ModelAndView view = new ModelAndView("Chat");
        return view;

    }

}
