package be.vdab.services;

import be.vdab.DAO.BrouwerDAO;
import be.vdab.entities.Brouwer;

public class BrouwerService {
	private final BrouwerDAO brouwerDAO = new BrouwerDAO();
	
	public Brouwer read(long id){
		return brouwerDAO.read(id);
	}
	public Iterable<Brouwer> findAll(){
		return brouwerDAO.findAll();
	}

}
