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
	private long BierNr;
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

	public long getBierNr() {
		return BierNr;
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


	
	

}
