// autor: www.salomaotech.com
$(document).ready(function () {

    var mensagensId = [];

    // envia mensagem para o servidor
    function enviarMensagem() {

        var apelido = $("#apelido").val();
        var mensagem = $("#mensagem").val();

        // limpa campos
        $("#mensagem").val("");

        // envia a mensagem
        $.post("/enviar", {apelido: apelido, mensagem: mensagem}, function () {

            // desabilita a edição do apelido
            $("#apelido").prop("disabled", true);

        });

    }

    // carrega as mensagens
    function carregarMensagens() {

        $.get("/carregar", function (mensagens) {

            $.each(mensagens, function (chave, valor) {

                if (!mensagensId.includes(mensagens[chave].id)) {

                    $("#mensagens-lista").append("<p class='chat-mensagem-recebida'>" + mensagens[chave].apelido + " : " + mensagens[chave].mensagem + "</p>");
                    mensagensId.push(mensagens[chave].id);

                }

            });

        });

    }

    // envia com enter
    $("#mensagem").keypress(function (e) {

        if (e.which === 13) {

            enviarMensagem();

        }

    });

    // timer para carregar novas mensagens
    setInterval(function () {

        carregarMensagens();

    }, 2000);

});
