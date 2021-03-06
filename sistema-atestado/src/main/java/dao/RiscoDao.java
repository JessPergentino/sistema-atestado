package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Risco;

public class RiscoDao {
	private static RiscoDao instance;
	protected EntityManager entityManager;

	public static RiscoDao getInstance() {
		if (instance == null) {
			instance = new RiscoDao();
		}

		return instance;
	}

	public RiscoDao() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("banco-atestado");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	@SuppressWarnings("unchecked")
	public List<Risco> findAll() {
		return entityManager.createQuery("FROM " + Risco.class.getName()).getResultList();
	}

	public void persist(Risco risco) {
		try {
			entityManager.persist(risco);
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Risco risco) {
		try {
			entityManager.merge(risco);
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Risco risco) {
		try {
			risco = entityManager.find(Risco.class, risco.getId());
			entityManager.remove(risco);
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public Risco getById(final Long id) {
		return entityManager.find(Risco.class, id);
	}

}
