$("#enviar").click(enviaCadastroUsuario);

function enviaCadastroUsuario() {
    let nome = $("#nome").val();
    let matricula = $("#Matricula").val();
    let Ocupacao = $("#Ocupacao option:selected").val();
    let email = $("#email").val();

    $.ajax({
        type: "POST",
        url: "/cadastro",
        data: {
            nome: nome,
            matricula: matricula,
            ocupacao: Ocupacao,
            email: email
        },
        success: function (data) {
            alert(data);
        },
        error: function () {
            alert("Deu Ruim!");
        }
    });
}
