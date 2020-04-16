package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Medico;

public class MedicoDao {
	private static MedicoDao instance;
	protected EntityManager entityManager;

	public static MedicoDao getInstance() {
		if (instance == null) {
			instance = new MedicoDao();
		}

		return instance;
	}

	public MedicoDao() {
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
	public List<Medico> findAll() {
		return entityManager.createQuery("FROM " + Medico.class.getName()).getResultList();
	}

	public void persist(Medico medico) {
		try {
			entityManager.persist(medico);
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Medico medico) {
		try {
			entityManager.merge(medico);
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Medico medico) {
		try {
			medico = entityManager.find(Medico.class, medico.getId());
			entityManager.remove(medico);
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public Medico getById(final Long id) {
		return entityManager.find(Medico.class, id);
	}
}
