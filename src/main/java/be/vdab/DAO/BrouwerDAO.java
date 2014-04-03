package be.vdab.DAO;

import be.vdab.entities.Brouwer;

public class BrouwerDAO extends AbstractDAO {
	public Brouwer read(long id) {
		return getEntityManager().find(Brouwer.class, id);
	}

	public Iterable<Brouwer> findAll() {
		return  getEntityManager()
				.createNamedQuery("Brouwer.findAll", Brouwer.class)
				.getResultList();
				
	}

}
