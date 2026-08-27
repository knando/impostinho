package br.com.mesquita.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
	/**
	 * @param especialidade
	 */
	public void setEspecialidade(Set<String> especialidade) {
		this.especialidade = especialidade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getDataAdmissaoFormatada() {
		return dataAdmissao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
	public String getCpfFormatada() {
		return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
	}

	public boolean equals(Medico medico) {
		return StringUtils.equals(this.getCpf(), medico.getCpf());
	}
}
