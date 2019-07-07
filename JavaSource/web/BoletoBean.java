package web;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import entidade.Boleto;
import entidade.Empresa;
import servico.ServicoBoleto;

@Named
@RequestScoped
public class BoletoBean {
	
	@EJB
	private ServicoBoleto servicoBoleto;
	
	private Boleto boleto;
	
	public BoletoBean() {
		this.boleto = new Boleto();
	}
	
	public void cadastrar() {
		this.servicoBoleto.cadastrarBoleto(boleto);
		MsgUtils.enviarSucesso("Cadastrado com sucesso!");
		this.boleto = new Boleto();
	}
	
	public List<Boleto> listarBoletos(){
		return this.servicoBoleto.listar();
	}
	
	public ArrayList<Empresa> listarTodas(){
		return this.listarTodas();
	}
	
	public void excluirBolero(Boleto boleto) {
		try {
			this.servicoBoleto.excluirBoleto(boleto);
			MsgUtils.enviarSucesso("Boleto excluido!");
		} catch (Exception e) {
			MsgUtils.enviarAtencao(e.getMessage());
		}
	}

	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}

}

