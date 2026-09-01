package br.com.mesquita.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.mesquita.model.Paciente;
import br.com.mesquita.service.PacienteService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
	
	PacienteService pacienteService;
	
	public PacienteController(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}
	
	@GetMapping("/listar")
	String listarPacientes(Model model) {
		List<Paciente> listaPaciente = pacienteService.listar();
		model.addAttribute("listaP", listaPaciente);
		System.out.println(listaPaciente.get(0).getDataNasc());
		return "paciente/listar";
	}
	
	@GetMapping("/cadastro")
	String cadastrarPacientes(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "paciente/cadastro";
	}
	
	@PostMapping("/salvar")
	String cadastrarPacientes(@ModelAttribute Paciente paciente) {
		pacienteService.salvar(paciente);
		return "redirect:/paciente/listar";
	}

}
