package br.com.mesquita.model;

import java.util.Date;

public class Consulta {
	private Date horario;
	private Medico medico;
	private Paciente paciente;
	
	public Consulta(Date horario, Medico medico, Paciente paciente) {
		this.horario = horario;
		this.medico = medico;
		this.paciente = paciente;
	}
	
	public Date getHorario() {
		return horario;
	}
	public void setHorario(Date horario) {
		this.horario = horario;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
