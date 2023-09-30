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
    public String getLogin() {
        return "Login/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public boolean validaLogin(@RequestParam("matricula") String matricula,
                               @RequestParam("senha") String senha,
                               HttpSession session) {


        session.setAttribute("usuario", S_Usuario.validaLogin(matricula, senha));
        if (session.getAttribute("usuario") != null){
            return true;
        }
        return false;

    }
}
