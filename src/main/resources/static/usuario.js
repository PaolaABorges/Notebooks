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
   function salvarEditUsuario(){
   let nome = $("#nome").val();
   let Ocupacao = $("#Ocupacao option:selected").val();
   let matricula = $("#Matricula").val();
   let email = $("#email").val();
   let ativo = $("#ativo").prop("checked");
   let senhaAtual = $("#senhaAtual").val();
   let novaSenha = $("#novaSenha").val();
   let confSenha = $("#confSenha").val();

   $.ajax({
     type: "Post",
     url:"/edit/usuario",
     data:{
       nome: nome,
       Ocupacao: Ocupacao,
       matricula: matricula,
       email: email,
       ativo: ativo,
       senhaAtual: senhaAtual,
       novaSenha: novaSenha,
       confSenha: confSenha
     },
     success: function(data){
         if(data.sucesso){
            alert("ok: " + data.mensagem);
         }else{
     alert("error: " + data.mansagem);
     }
     },
     error: function(){
     alert ("Deu Ruim!");
     }
   });
   }