package web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import entidade.Empresa;
import servico.ServicoEmpresa;

@Named
@RequestScoped
public class EmpresaBean {
	
	@EJB
	private ServicoEmpresa servicoEmpresa;
	
	private Empresa empresa;
	
	private List<Empresa> empresas;
	
	public EmpresaBean() {
		this.empresa = new Empresa();
	}
	
	public void cadastrar() {
			this.servicoEmpresa.cadastrarEmpresa(empresa);
			MsgUtils.enviarSucesso("Cadastrado com sucesso!");
			this.empresa = new Empresa();
	}
	
	public List<Empresa> listarTodas(){
		return this.servicoEmpresa.listar();
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public List<Empresa> getEmpresas() {
		if (this.empresas == null) {
			this.empresas = this.servicoEmpresa.listar();
		}
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

}
