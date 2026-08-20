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
		this.medicoService = medicoService;
	}
		
	@GetMapping("/listar")
	String listarMedicos(Model model) {
		List<Medico> listaMedico = medicoService.listar();
		model.addAttribute("listaP", listaMedico);
		System.out.println(listaMedico.get(0).getDataAdmissao());
		return "medico/listar";
	}
	
	@GetMapping("/cadastro")
	String cadastrarMedicos(Model model) {
		 model.addAttribute("medico", new Medico());
		return "medico/cadastro";
	}
	
	@PostMapping("/salvar")
	String cadastrarMedicos(@ModelAttribute Medico medico) {
		medicoService.salvar(medico);
		return "redirect:/medico/listar";
	}
	
}
