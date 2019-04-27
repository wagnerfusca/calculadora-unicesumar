package br.edu.unicesumar.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.edu.unicesumar.model.Produto;

public class ProdutoDao extends DAO {

	public void save(Produto produto) {
		EntityManager manager = getEntityManager();

		manager.getTransaction().begin();
		manager.persist(produto);
		manager.getTransaction().commit();
	}

	public List<Produto> list() {
		EntityManager manager = getEntityManager();

		return manager.createQuery("from produto").getResultList();
	}

}
