package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="bieren")
public class Bier implements Serializable {

	private static final long serialVersionUID = 1L;
	@GeneratedValue
	@Id
	private long bierNr;
	private String naam;
	private BigDecimal alcohol;
	private BigDecimal prijs;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="soortNr")
	private Soort soort;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="brouwerNr")
	private Brouwer brouwer;
	
	protected Bier(){
		
	}

	public long getbierNr() {
		return bierNr;
	}

	public String getNaam() {
		return naam;
	}

	public BigDecimal getAlcohol() {
		return alcohol;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public Soort getSoort() {
		return soort;
	}

	public Brouwer getBrouwer() {
		return brouwer;
	}
	
	@Override
	public boolean equals(Object object){
		if(!(object instanceof Bier)){
			return false;
		}
		else{
			Bier anderBier = (Bier) object;
			return(naam.equals(anderBier.getNaam()) && 
					brouwer.getNaam().equals(anderBier.getBrouwer().getNaam()));
		}
	}
	@Override
	public int hashCode() {
		String hashCode = naam+brouwer.getNaam();
		return hashCode.hashCode();
	}
	@Override
	public String toString(){
		return "Naam:"+naam+
				" Brouwer:"+brouwer.getNaam()+
				" Soort:"+soort.getNaam()+
				" Alcoholpercentage:"+alcohol+
				" Prijs:"+prijs;
	}


	
	

}
