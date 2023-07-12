package com.salomaotech.chat.controller;

import com.salomaotech.chat.model.Mensagem;
import com.salomaotech.chat.model.MensagemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MensagensController {

    @Autowired
    private MensagemRepository mensagemRepository;

    @PostMapping("/enviar")
    public void enviarMensagem(@RequestParam("apelido") String apelidoParametro, @RequestParam("mensagem") String mensagemParametro) {

        if (!apelidoParametro.equals("") && !mensagemParametro.equals("")) {

            Mensagem mensagem = new Mensagem();
            mensagem.setApelido(apelidoParametro);
            mensagem.setMensagem(mensagemParametro);
            mensagemRepository.save(mensagem);

        }

    }

    @GetMapping("/carregar")
    public List<Mensagem> listarMensagens() {

        return mensagemRepository.findAll();

    }

}
