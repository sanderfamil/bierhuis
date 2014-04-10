package be.vdab.services;

import be.vdab.DAO.BrouwerDAO;
import be.vdab.entities.Brouwer;

public class BrouwerService {
	private final BrouwerDAO brouwerDAO = new BrouwerDAO();
	
	public Iterable<Brouwer> findAll(){
		return brouwerDAO.findAll();
	}
	public Brouwer readBrouwerAndBier(long id){
		return brouwerDAO.readBrouwerAndBier(id);
	}

}
