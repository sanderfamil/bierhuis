package be.vdab.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.BestelbonLijn;

@Entity
@Table(name="bestelbonnen")
public class Bestelbon implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue
	@Id
	private long bonNr;
	private String naam;
	@Embedded
	private Adres adres;
	@ElementCollection
	@CollectionTable(name = "bestelbonlijnen", joinColumns = @JoinColumn(name = "bonNr"))
	private Set<BestelbonLijn> bestelbonLijnen;
	protected Bestelbon(){
		
	}
	public Bestelbon(String naam, Adres adres, Set<BestelbonLijn> bestelbonLijnen){
		this.naam=naam;
		this.adres=adres;
		this.bestelbonLijnen=bestelbonLijnen;
	}
	public long getBonNr() {
		return bonNr;
	}
	

}
