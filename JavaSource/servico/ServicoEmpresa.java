package servico;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidade.Empresa;

@Stateless
public class ServicoEmpresa {

	@PersistenceContext
	private EntityManager em;
	
	@EJB
	private ServicoBoleto servicoBoleto;
	
	public void cadastrarEmpresa(Empresa empresa) {	
		this.em.persist(empresa);		
	}
	
	public List<Empresa> listar(){
		return this.em.createQuery("FROM Empresa e", Empresa.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Empresa> listarPorNome(String nome) {
		Query query = this.em.createQuery("SELECT m FROM Marca m WHERE m.nome=:p1", Empresa.class);
		query.setParameter("p1", nome);
		return query.getResultList();
	}
	
}
