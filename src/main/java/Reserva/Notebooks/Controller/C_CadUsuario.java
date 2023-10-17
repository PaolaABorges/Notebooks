package Reserva.Notebooks.Controller;

import Reserva.Notebooks.Model.M_Usuario;
import Reserva.Notebooks.Service.S_Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_CadUsuario {


    @GetMapping("/cadastro")
    public String getCadastro(HttpServletRequest request) {
        if (request.getHeader("Referer") != null) {
            return "cadastro/usuario";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/cadastro")
    @ResponseBody
    public String postCadastro(@RequestParam("nome") String nome,
                               @RequestParam("matricula") String matricula,
                               @RequestParam("ocupacao") String Ocupacao,
                               @RequestParam("email") String email) {
        return S_Usuario.CadastrarUsuario(nome, matricula, Ocupacao, email);
    }

    @GetMapping("/edit/usuario")
    public String getEditUsuario(HttpServletRequest request,
                                 HttpSession session, Model model) {
        if (request.getHeader("Referer") != null) {
            M_Usuario usuario = (M_Usuario) session.getAttribute("usuario");
            model.addAttribute("usuario",usuario);
            if (usuario.getOcupacao() == 1) {
                return "/cadastro/partial_view/edit_cad_usuario_gestor";
            } else {
                return "/cadastro/partial_view/edit_cad_usuario_defaul";
            }

        } else {
            return null;
        }
    }
}