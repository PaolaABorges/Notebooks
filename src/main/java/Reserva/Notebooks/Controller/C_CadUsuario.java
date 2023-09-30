package Reserva.Notebooks.Controller;

import Reserva.Notebooks.Service.S_Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_CadUsuario {


    @GetMapping("/cadastro")
    public String getCadastro() {

        return "cadastro/usuario";
    }

    @PostMapping("/cadastro")
    @ResponseBody
    public String postCadastro(@RequestParam("nome") String nome,
                               @RequestParam("matricula") String matricula,
                               @RequestParam("ocupacao") String Ocupacao,
                               @RequestParam("email") String email) {
        return S_Usuario.CadastrarUsuario(nome, matricula, Ocupacao, email);
    }

}
