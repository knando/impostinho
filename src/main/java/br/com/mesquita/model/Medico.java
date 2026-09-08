package br.com.mesquita.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	private LocalDate dataDemissao;
	@Column(nullable = false)
	public boolean ativo = true;
	
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
	    if (this.dataAdmissao == null) {
	        return "N/A"; 
	    }
	    
	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    
	    return this.dataAdmissao.format(formato);
	}
	
	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
  
	public LocalDate getDataDemissao() {
		return dataDemissao;
	}
	public String getDataDemissaoFormatada() {
		return dataDemissao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public void setDataDemissao(LocalDate dataDemissao) {
		this.dataDemissao = dataDemissao;
	}
	
	public String getCpfFormatada() {
		return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
	}

	public boolean equals(Medico medico) {
		return StringUtils.equals(this.getCpf(), medico.getCpf());
	}
	public boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
