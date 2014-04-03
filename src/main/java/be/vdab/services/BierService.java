package be.vdab.services;

import be.vdab.DAO.BierDAO;
import be.vdab.entities.Bier;

public class BierService {
	private final BierDAO bierDAO =  new BierDAO();
	public Bier read(long id){
		return bierDAO.read(id);
	}
	public long countAll(){
		return bierDAO.countAll();
	}

}
