package Reserva.Notebooks.Controller;

import Reserva.Notebooks.Service.S_Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_CadUsuario {

    @GetMapping ("/")
        public String redirecionaCadastro(){
            return "redirect:/cadastro";
        }

    @GetMapping("/cadastro")
    public String getCadastro() {

        return "cadastro/usuario";
    }

    @PostMapping("/cadastro")
    @ResponseBody
    public String postCadastro(@RequestParam("nome") String nome,
                               @RequestParam("matricula") String matricula,
                               @RequestParam("Ocupacao") String Ocupacao,
                               @RequestParam("email") String email) {
        S_Usuario.CadastrarUsuario(nome, matricula, Ocupacao, email);

        return "cadastro/usuario";
    }

}
