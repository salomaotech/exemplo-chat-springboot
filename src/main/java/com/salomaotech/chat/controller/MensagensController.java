package com.salomaotech.chat.controller;

import com.salomaotech.chat.model.Mensagem;
import com.salomaotech.chat.model.MensagemRepository;
import java.util.ArrayList;
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

    private static final List<Long> novasMensagensId = new ArrayList();

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

        int contador = 0;

        List<Mensagem> mensagensDoRepositorio = mensagemRepository.findAll();
        List<Mensagem> retorno = new ArrayList();

        for (Mensagem mensagem : mensagensDoRepositorio) {

            /* checa se o ID da mensagem já foi carregado */
            if (!novasMensagensId.contains(mensagem.getId())) {

                novasMensagensId.add(mensagem.getId());
                

            }

        }

        return retorno;

    }

}
