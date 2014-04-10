package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import be.vdab.valueobjects.Adres;

@Entity
@Table(name="brouwers")
public class Brouwer implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue
	@Id
	private long brouwerNr;
	private String naam;
	private BigDecimal omzet;
	@Embedded
	private Adres adres;
	@OrderBy("naam")
	@OneToMany(mappedBy="brouwer")
	private Set<Bier> bieren;
	protected Brouwer(){
		
	}
	public long getBrouwerNr() {
		return brouwerNr;
	}
	public String getNaam() {
		return naam;
	}
	public Adres getAdres() {
		return adres;
	}
	public Set<Bier> getBieren() {
		return Collections.unmodifiableSet(bieren);
	}
}
