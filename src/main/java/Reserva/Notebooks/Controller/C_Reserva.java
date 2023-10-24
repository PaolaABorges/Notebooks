package Reserva.Notebooks.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Reserva {

    @GetMapping("/reserva/notebook")
    public String getReserva(){
        return "/reserva/notebook";
    }
}
