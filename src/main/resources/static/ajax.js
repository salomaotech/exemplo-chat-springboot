// autor: www.salomaotech.com
$(document).ready(function () {

    // envia mensagem para o servidor
    function enviarMensagem() {

        var apelido = $("#apelido").val();
        var mensagem = $("#mensagem").val();

        $.post("/enviar", {apelido: apelido, mensagem: mensagem}, function () {

            carregarMensagens();

        });

    }

    function carregarMensagens() {

        $.get("/carregar", function (mensagens) {

            $.each(mensagens, function (chave, valor) {

                $("#mensagens-lista").append("<p class='mensagem-recebida'>" + mensagens[chave].apelido + " : " + mensagens[chave].mensagem + "</p>");

            });

        });

    }


    carregarMensagens();








    // adiciona evento ao clicar no botão para enviar a mensagem
    $("#botao-enviar-mensagem").on("click", function () {

        enviarMensagem();

    });







});