$("#enviar").click(enviaCadastroUsuario);

function enviaCadastroUsuario() {
    let nome = $("#nome").val();
    let matricula = $("#Matricula").val();
    let ocupacao = $("#Ocupacao option:selected").val();
    let email = $("#email").val();

    $.ajax({
        type: "POST",
        url: "/cadastro",
        data: {
            nome: nome,
            matricula: matricula,
            ocupacao: ocupacao,
            email: email,
        },
        sucess: function (data) {
            alert(data);
        },
        error: function () {
            alert("Deu Ruim!");
        }
    });
}
