package be.vdab.services;

import be.vdab.DAO.BestelbonDAO;
import be.vdab.entities.Bestelbon;

public class BestelbonService {
	BestelbonDAO bestelbonDAO = new BestelbonDAO();
	public void create (Bestelbon bestelbon){
			bestelbonDAO.beginTransaction();
			bestelbonDAO.create(bestelbon);
			bestelbonDAO.commit();
	}	
}
