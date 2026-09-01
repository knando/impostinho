package br.com.mesquita.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mesquita.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
	
	
	public List<Medico> findAllByAtivo(boolean ativo); 
}

