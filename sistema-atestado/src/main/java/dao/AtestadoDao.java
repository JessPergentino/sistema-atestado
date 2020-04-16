package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Atestado;

public class AtestadoDao {
	private static AtestadoDao instance;
	protected EntityManager entityManager;

	public static AtestadoDao getInstance() {
		if (instance == null) {
			instance = new AtestadoDao();
		}

		return instance;
	}

	public AtestadoDao() {
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
	public List<Atestado> findAll() {
		return entityManager.createQuery("FROM " + Atestado.class.getName()).getResultList();
	}

	public void persist(Atestado atestado) {
		try {
			entityManager.persist(atestado);
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Atestado atestado) {
		try {
			entityManager.merge(atestado);
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Atestado atestado) {
		try {
			atestado = entityManager.find(Atestado.class, atestado.getId());
			entityManager.remove(atestado);
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public Atestado getById(final Long id) {
		return entityManager.find(Atestado.class, id);
	}
}
