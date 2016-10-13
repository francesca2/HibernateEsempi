package model;

import javax.persistence.Embeddable;

@Embeddable
public class Indirizzo {

	private String citt�;
	private String via;
	
	
	public Indirizzo() {
	}

	public Indirizzo(String citt�, String via) {
		this.citt� = citt�;
		this.via = via;
	}

	public String getCitt�() {
		return citt�;
	}

	public void setCitt�(String citt�) {
		this.citt� = citt�;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}
	
}
