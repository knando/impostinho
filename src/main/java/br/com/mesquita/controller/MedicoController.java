package br.com.mesquita.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mesquita.model.Medico;
import br.com.mesquita.service.MedicoService;


@Controller
@RequestMapping("/medico")
public class MedicoController {

	MedicoService medicoService;

	public MedicoController(MedicoService medicoService) {
		this.medicoService=medicoService;
	}

	@GetMapping("/listar")
	String listarMedicos(Model model) {
		List<Medico> ListarMedico=medicoService.listar();
		model.addAttribute("listaM",ListarMedico);
		return "medico/listar";
	}

	@GetMapping("/cadastro")
	String cadastrarMedicos(Model model) {
		model.addAttribute("medico",new Medico());
		return "medico/cadastro";
	}

	@PostMapping("/salvar")
	String cadastrarMedico(@ModelAttribute Medico medico) {
		
		medicoService.salvarm(medico);
		return "redirect:/medico/listar";
	}

}
