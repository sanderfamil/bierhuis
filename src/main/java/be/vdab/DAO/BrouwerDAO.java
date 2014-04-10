package be.vdab.DAO;

import be.vdab.entities.Brouwer;

public class BrouwerDAO extends AbstractDAO {

	public Iterable<Brouwer> findAll() {
		return  getEntityManager()
				.createNamedQuery("Brouwer.findAll", Brouwer.class)
				.getResultList();
				
	}
	public Brouwer readBrouwerAndBier(long id){
		return getEntityManager()
				.createNamedQuery("Brouwer.readBrouwerAndBier", Brouwer.class)
				.setParameter("id", id)
				.getSingleResult();
	}
}
