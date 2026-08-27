package br.com.mesquita.service;

import java.time.LocalDate;
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
	
	public void demitir(Long id) {
		Medico medico = medicoRepository.findById(id).orElse(null);
		medico.setAtivo(false);
		medico.setDataDemissao(LocalDate.now());
		medicoRepository.save(medico);
	}
	
	public Long salvar(Medico medico) {
		List<Medico> listaMedico = listar();
		for(Medico m : listaMedico) {
			if(m.getCpf() == medico.getCpf() && m.getAtivo() == false) { m.setAtivo(true);}
		}
		return medicoRepository.save(medico).getId();
	}
}