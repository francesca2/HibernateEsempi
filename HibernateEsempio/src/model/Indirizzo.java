package model;

import javax.persistence.Embeddable;

@Embeddable
public class Indirizzo {

	private String città;
	private String via;
	
	
	public Indirizzo() {
	}

	public Indirizzo(String città, String via) {
		this.città = città;
		this.via = via;
	}

	public String getCittà() {
		return città;
	}

	public void setCittà(String città) {
		this.città = città;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}
	
}
