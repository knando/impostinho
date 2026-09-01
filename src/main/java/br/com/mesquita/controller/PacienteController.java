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
	String cadastrarPacientes() {
		return "paciente/cadastro";
	}
	
	@PostMapping("/salvar")
	String cadastrarPacientes(@RequestParam Map<String, String> data) {
		Paciente paciente = new Paciente();
		paciente.setNome(data.get("nome"));
		paciente.setCpf(data.get("cpf"));
		paciente.setDataNascimento(Date.valueOf(data.get("data-nascimento")));
		IO.println(paciente.toString());
		pacienteService.salvar(paciente);
		return "redirect:/paciente/listar";
	}

}
