package sg.edu.nus.iss.ssf_13t.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("")
public class HomeController {

    @PostMapping()
    public String login(@RequestBody MultiValueMap<String, String> entity, HttpSession session, Model model) {
        String username = entity.getFirst("username");
        session.setAttribute("username", username);
        return "redirect:/store";
    }

    @GetMapping()
    public String homePage() {
        return "index";
    }
    
    
}
