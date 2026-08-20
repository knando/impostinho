package br.com.mesquita.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import org.thymeleaf.util.StringUtils;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@ElementCollection
	@CollectionTable(
			name = "especialidade", // Name of the target table
			joinColumns = @JoinColumn(name = "medico_id") // Foreign key to main table
			)
	@Column(name = "nome_especialidade")
	private Set<String> especialidade;
	private String cpf;
	private LocalDate dataAdmissao;

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
	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(LocalDate date) {
		this.dataAdmissao = date;
	}

	public boolean equals(Medico medico) {
		return StringUtils.equals(this.getCpf(), medico.getCpf());
	}
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
