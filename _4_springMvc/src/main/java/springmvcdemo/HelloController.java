package springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String hello() {
        return "hello"; // hello.html, rozszerzenie opcjonalne
    }

    @RequestMapping("/powitanie")
    public String siema(Model model) {

        // model do thymeleafa - procesora html
        model.addAttribute("superDane", "moje dane 123");
        return "powitanie";
    }

    @RequestMapping("/formularz")
    public String form(Model model) {
        model.addAttribute("daneZForma", new DaneForma());
        return "formularz";
    }

    @RequestMapping("/przetwarzajFormularz")
    public String processForm(@ModelAttribute DaneForma daneZForma, Model model) {
;
        model.addAttribute("dane", daneZForma.getNapis());
        return "processForm";
    }
}
