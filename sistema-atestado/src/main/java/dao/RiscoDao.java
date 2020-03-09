package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


// TODO: Terminar de Desenvolver os DAOs
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

	//TODO: Configurar o EntityManager
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

}
