package be.vdab.services;

import java.util.List;

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
	public Bier readBierSoortAndBrouwer(long id){
		return bierDAO.readBierSoortAndBrouwer(id);
	}

	public Iterable<Bier> findAllById(List<Long> id) {
		return bierDAO.findAllById(id);
	}

}
