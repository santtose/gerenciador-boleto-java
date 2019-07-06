package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

@Entity
public class Empresa {
	
	@Id
	@SequenceGenerator(name = "CONTADOR_EMPRESA", sequenceName = "NUM_SEQ_EMPRESA", allocationSize = 0) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTADOR_EMPRESA" )
	private Integer id;
	
	@NotBlank
	private String nomeEmpresa;
	
	@NotBlank
	private String CNPJ;
	
	@NotBlank
	private String ramo;
	
	public Empresa() {}

	public Empresa(Integer id, String nomeEmpresa, String cNPJ, String ramo) {
		this.id = id;
		this.nomeEmpresa = nomeEmpresa;
		CNPJ = cNPJ;
		this.ramo = ramo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}
	


}
