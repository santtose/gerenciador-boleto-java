package servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidade.Boleto;
import entidade.Empresa;

@Stateless
public class ServicoBoleto {

	@PersistenceContext
	private EntityManager em;

	public void cadastrarBoleto(Boleto boleto) {
		this.em.persist(boleto);
	}

	public void excluirBoleto(Boleto boleto) throws Exception {
		if (boleto.getTipo() != null && !boleto.getTipo().equalsIgnoreCase("Sim")) {
			throw new Exception("Não é permitido excluir boletos não pagos!");
		}
		this.em.remove(this.em.merge(boleto));
	}

	public List<Boleto> listar() {
		return this.em.createQuery("FROM Boleto b", Boleto.class).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Boleto> listarPorEmpresa(Empresa empresa) {
		Query query = this.em.createQuery("FROM Boleto b WHERE b.empresa=:pl", Boleto.class);
		query.setParameter("pl", empresa);
		return query.getResultList();
	}

}
