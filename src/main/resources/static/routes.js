function controleDeRotas(url){
switch (url){
case "/logout":
gerarSwal(url);
   break;
    case "/cadastro/notebook":
//Renderizar tela
   $.get(url, function(data){
       $('#mainContainer').html(data);
   //Definir as açoes dos componentes
    $("#enviar").click(enviaCadastroNotebook);
   });
   break;
     case "/cadastro":
   $.get(url, function(data){
       $('#mainContainer').html(data);
   //Definir as açoes dos componentes
   $("#enviar").click(enviaCadastroUsuario);
   });
     break;
     case "/edit/usuario":
        $.get(url, function(data){
        $('#mainContainer').html(data);
        });
        break;
          default:
        $.get(url, function(data){
           $('#mainContainer').html(data);
      });
     }
    }