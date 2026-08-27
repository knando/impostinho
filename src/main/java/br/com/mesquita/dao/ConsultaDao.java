package br.com.mesquita.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.mesquita.model.Consulta;
import br.com.mesquita.model.Medico;
import br.com.mesquita.model.Paciente;

@Service
public class ConsultaDao {
	
	public List<Consulta> listarConsulta(){
		List<Consulta> lista = new ArrayList<>();
		lista.add(new Consulta(LocalDateTime.now(), new Medico("123.456.789-11", "Marcos Paulo"), new Paciente("Rogerio", "123.456.789-00", new Date())));
		lista.add(new Consulta(LocalDateTime.now(), new Medico("123.456.789-33", "Carla Maria"), new Paciente("Felipe", "123.456.788-01", new Date())));
		
		return lista;
	}
}
