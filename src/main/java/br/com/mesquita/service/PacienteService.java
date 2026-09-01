package br.com.mesquita.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.mesquita.model.Medico;
import br.com.mesquita.model.Paciente;
import br.com.mesquita.repository.PacienteRepository;

@Service
public class PacienteService {
	
	private PacienteRepository pacienteRepository;
	
	
	public Paciente buscarPorId(Long id) {
	    return pacienteRepository.findById(id).orElse(null);
	}
	
	public PacienteService(PacienteRepository pacienteRepository) {
		this.pacienteRepository = pacienteRepository;
	}

	public List<Paciente> listar(){
		return pacienteRepository.findAll();
	}
	
	public Long salvar(Paciente paciente) {
		return pacienteRepository.save(paciente).getId();
	}
}
