package br.com.mesquita.model;

import java.util.Date;
import java.util.Set;

import org.thymeleaf.util.StringUtils;

public class Medico {
	private String nome;
	private Set<String> especialidade;
	private String cpf;
	private Date dataAdmissao;
	
	public Medico() {
		
	}
	public Medico(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Set<String> getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Set<String> especialidade) {
		this.especialidade = especialidade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
	public boolean equals(Medico medico) {
		return StringUtils.equals(this.getCpf(), medico.getCpf());
	}
}
