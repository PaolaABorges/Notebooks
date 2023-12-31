package Reserva.Notebooks.Controller;

import Reserva.Notebooks.Service.S_Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Login {
    @GetMapping("/")
    public String getLogin(HttpSession session) {
        if (session.getAttribute("usuario") != null) {
            return "redirect:/Home";

        } else {
            return "Login/login";
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public boolean validaLogin(@RequestParam("matricula") String matricula,
                               @RequestParam("senha") String senha,
                               HttpSession session) {

        session.setAttribute("usuario", S_Usuario.validaLogin(matricula, senha));
        return session.getAttribute("usuario") != null;

    }
    @GetMapping ("/logout")
    public String logout(HttpSession session){
        session.setAttribute("usuario", null);
        return "redirect:/";
    }
}
