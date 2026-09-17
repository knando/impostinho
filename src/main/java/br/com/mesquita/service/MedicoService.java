package br.com.mesquita.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.mesquita.model.Medico;
import br.com.mesquita.repository.MedicoRepository;

@Service
public class MedicoService {

	private final MedicoRepository medicoRepository;
	private final PasswordEncoder passwordEncoder;

	public MedicoService(MedicoRepository medicoRepository, PasswordEncoder passwordEncoder) {
		this.medicoRepository = medicoRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public List<Medico> listar() {
		return medicoRepository.findAll();
	}

	public void demitir(Long id) {
		Medico medico = buscarPorId(id);
		medico.setAtivo(false);
		medico.setDataDemissao(LocalDate.now());
		medicoRepository.save(medico);
	}

	public Long salvar(Medico medico) {
		reativarSeJaExistente(medico);

		if (medico.getSenha() != null && !medico.getSenha().isBlank()) {
			medico.setSenha(passwordEncoder.encode(medico.getSenha()));
			medico.setRole("ROLE_USUARIO");
		}

		return medicoRepository.save(medico).getId();
	}

	private void reativarSeJaExistente(Medico medico) {
		for (Medico m : listar()) {
			if (m.getCpf() != null && m.getCpf().equals(medico.getCpf()) && !m.getAtivo()) {
				m.setAtivo(true);
			}
		}
	}

	public Medico buscarPorId(Long id) {
		return medicoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Médico não encontrado: " + id));
	}

	public List<Medico> buscaPorStatus(boolean estaAtivo) {
		return medicoRepository.findAllByAtivo(estaAtivo);
	}
}