package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Empresa;

public class EmpresaDao {
	private static EmpresaDao instance;
	protected EntityManager entityManager;

	public static EmpresaDao getInstance() {
		if (instance == null) {
			instance = new EmpresaDao();
		}

		return instance;
	}

	public EmpresaDao() {
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
	public List<Empresa> findAll() {
		return entityManager.createQuery("FROM " + Empresa.class.getName()).getResultList();
	}

	public void persist(Empresa empresa) {
		try {
			entityManager.persist(empresa);
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Empresa empresa) {
		try {
			entityManager.merge(empresa);
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Empresa empresa) {
		try {
			empresa = entityManager.find(Empresa.class, empresa.getId());
			entityManager.remove(empresa);
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public Empresa getById(final Long id) {
		return entityManager.find(Empresa.class, id);
	}
}
