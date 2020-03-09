package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import converter.TipoExameConverter;
import enumeracoes.TipoExameEnum;

@Entity
@Table(name = "atestado")
public class Atestado {

	@Id
	@GeneratedValue
	private Long id;
	
	@Convert(converter = TipoExameConverter.class)
    @Column(columnDefinition = "CHAR(2)", nullable = false)
	private Enum<TipoExameEnum> tipoExame;
	
	@Column(nullable = false)
	private boolean aptidao;
	
	@OneToMany(mappedBy = "atestado")
	private List<Risco> riscos;
	
	@ManyToOne()
	@JoinColumn(name="id_funcionario")
	private Funcionario funcionario;
	
	@ManyToOne()
	@JoinColumn(name="id_medico")
	private Medico medico;
	

	public Atestado() {
	}

	public Atestado(Enum<TipoExameEnum> tipoExame, boolean aptidao) {
		super();
		this.tipoExame = tipoExame;
		this.aptidao = aptidao;
	}

	public Enum<TipoExameEnum> getTipoExame() {
		return tipoExame;
	}

	public void setTipoExame(Enum<TipoExameEnum> tipoExame) {
		this.tipoExame = tipoExame;
	}

	public boolean isAptidao() {
		return aptidao;
	}

	public void setAptidao(boolean aptidao) {
		this.aptidao = aptidao;
	}

	public Long getId() {
		return id;
	}

	public List<Risco> getRiscos() {
		return riscos;
	}

	public void setRiscos(List<Risco> riscos) {
		this.riscos = riscos;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
