package br.com.mesquita.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class BaseController {

	@GetMapping
	public String home() {
		return "home";
	}

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model) {

        if (error != null) {
            model.addAttribute("mensagemErro", "Username e/ou senha incorretos.");
        }

        if (logout != null) {
            model.addAttribute("mensagemLogout", "Você saiu.");
        }

        return "base/login";
	}
	
}
 