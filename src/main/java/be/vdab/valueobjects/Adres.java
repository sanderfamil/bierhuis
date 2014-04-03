package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Adres implements Serializable  {
	private static final long serialVersionUID = 1L;
	private String straat;
	private String huisNr;
	private int postCode;
	private String gemeente;
	
	protected Adres(){
		
	}
	public Adres(String straat, String huisNr, int postCode, String gemeente){
		this.straat=straat;
		this.huisNr=huisNr;
		this.postCode=postCode;
		this.gemeente=gemeente;
	}

	public String getStraat() {
		return straat;
	}

	public String getHuisNr() {
		return huisNr;
	}

	public int getPostCode() {
		return postCode;
	}

	public String getGemeente() {
		return gemeente;
	}
	
	

}
