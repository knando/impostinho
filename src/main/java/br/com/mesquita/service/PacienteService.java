package br.com.mesquita.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.mesquita.model.Paciente;
import br.com.mesquita.repository.PacienteRepository;

@Service
public class PacienteService {

	private final PacienteRepository pacienteRepository;
	private final PasswordEncoder passwordEncoder;

	public PacienteService(PacienteRepository pacienteRepository, PasswordEncoder passwordEncoder) {
		this.pacienteRepository = pacienteRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public List<Paciente> listar() {
		return pacienteRepository.findAll();
	}

	public Long salvar(Paciente paciente) {
		if (paciente.getSenha() != null && !paciente.getSenha().isBlank()) {
			paciente.setSenha(passwordEncoder.encode(paciente.getSenha()));
			paciente.setRole("ROLE_USUARIO");
		}
		return pacienteRepository.save(paciente).getId();
	}

	public Paciente buscarPorId(Long id) {
		return pacienteRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado: " + id));
	}
}