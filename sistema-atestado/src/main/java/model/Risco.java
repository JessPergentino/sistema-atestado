package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "risco")
public class Risco {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@ManyToOne()
	@JoinColumn(name="id_atestado")
	private Atestado atestado;
	
	public Risco() {
	}

	public Risco(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

}
