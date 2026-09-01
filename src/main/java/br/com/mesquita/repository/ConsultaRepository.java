package br.com.mesquita.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mesquita.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
