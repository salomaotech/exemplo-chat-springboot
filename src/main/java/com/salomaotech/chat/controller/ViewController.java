package com.salomaotech.chat.controller;

import com.salomaotech.chat.model.Mensagem;
import com.salomaotech.chat.model.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @Autowired
    private MensagemRepository mensagemRepository;

    @GetMapping("/")
    public ModelAndView exibirHome() {

        ModelAndView view = new ModelAndView("Index");
        view.addObject("mensagens", mensagemRepository.findAll());
        return view;

    }

    @PostMapping("/enviar")
    public String enviarMensagem(@RequestParam("apelido") String apelidoParametro, @RequestParam("mensagem") String mensagemParametro) {

        if (!apelidoParametro.equals("") && !mensagemParametro.equals("")) {

            Mensagem mensagem = new Mensagem();
            mensagem.setApelido(apelidoParametro);
            mensagem.setMensagem(mensagemParametro);
            mensagemRepository.save(mensagem);

        }

        return "redirect:/";

    }

}
