package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name="nome")
	private String nome;
	@Column(name="crm")
	private String crm;

	public Medico() {
		// TODO Auto-generated constructor stub
	}
	
	public Medico(String nome, String crm) {
		super();
		this.nome = nome;
		this.crm = crm;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

}
