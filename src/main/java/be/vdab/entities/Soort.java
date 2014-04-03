package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "soorten")
public class Soort implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue
	@Id
	private long soortNr;
	private String naam;

	protected Soort() {

	}

	public long getSoortNr() {
		return soortNr;
	}

	public String getNaam() {
		return naam;
	}

}
