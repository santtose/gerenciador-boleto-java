package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Boleto {
	

	@Id
	@SequenceGenerator(name = "CONTADOR_BOLETO", sequenceName = "NUM_SEQ_BOLETO", allocationSize = 0) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTADOR_BOLETO" )
	private Integer id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "fk_empresa")
	private Empresa empresa;
	
	@NotBlank
	private String descricao;
	
	@NotNull
	private Double valor;
	
	private String tipo;
	
	public Boleto(){}

	
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
