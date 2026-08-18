package br.com.mesquita.controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	String cadastrarMedicos() {
		return "medico/cadastro";
	}
	
	@PostMapping("/salvar")
	String cadastrarMedicos(@RequestParam Map<String, String> data) {
		Medico medico = new Medico();
		medico.setNome(data.get("nome"));
		medico.setCpf(data.get("cpf"));
		medico.setDataAdmissao(Date.valueOf(data.get("data-admissao")));
		IO.println(medico.toString());
		medicoService.salvar(medico);
		return "redirect:/medico/listar";
	}
	
}
