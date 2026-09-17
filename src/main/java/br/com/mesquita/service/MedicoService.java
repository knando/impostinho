package br.com.mesquita.service;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.PropertyValueException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.mesquita.model.Medico;
import br.com.mesquita.repository.MedicoRepository;
import io.micrometer.common.util.StringUtils;

@Service
public class MedicoService {
	
	private MedicoRepository medicoRepository;
	
	public MedicoService(MedicoRepository medicoRepository) {
		this.medicoRepository = medicoRepository;
	}
	
	public List<Medico> listar(){
		return medicoRepository.findAll();
	}
	
	public void demitir(Long id) {
		Medico medico = medicoRepository.findById(id).orElse(null);
		medico.setAtivo(false);
		medico.setDataDemissao(LocalDate.now());
		medicoRepository.save(medico);
	}

	public Long salvar(Medico medico) throws PropertyValueException {
		
		if (medico.getId() != null) {
			Medico medicoBanco = buscarPorId(medico.getId());
			
			if (medicoBanco.getAtivo() == false) { // lógica antiga
				medico.setAtivo(true);
			}
			if (StringUtils.isBlank(medico.getSenha())) { // médico está sendo atualizado e a senha não foi alterada
				medico.setSenha(medicoBanco.getSenha());
			} else {
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				medico.setSenha(encoder.encode(medico.getSenha()));
				medico.setRole("ROLE_USUARIO");
			}
		}
		
		if (StringUtils.isBlank(medico.getSenha())) {
			throw new PropertyValueException("Senha não pode estar vazia.", "Medico", "Senha");
		}
		
		return medicoRepository.save(medico).getId();
	}
	
	public Medico buscarPorId(Long id) {
		return medicoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Médico não encontrado: " + id));
  }
  
	public List<Medico> buscaPorStatus(boolean estaAtivo) {
		return medicoRepository.findAllByAtivo(estaAtivo);
	}
}