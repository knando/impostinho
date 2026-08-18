package br.com.mesquita.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.mesquita.model.Medico;
import br.com.mesquita.repository.MedicoRepository;

@Service
public class MedicoService {

	private MedicoRepository medicoRepository;
	
	public MedicoService(MedicoRepository medicoRepository) {
		this.medicoRepository = medicoRepository;
	}
	
	public List<Medico> listar(){
		return medicoRepository.findAll();
	}
	
	public Long salvar(Medico medico) {
		return medicoRepository.save(medico).getId();
	}
	
}
