package br.com.mesquita.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mesquita.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
