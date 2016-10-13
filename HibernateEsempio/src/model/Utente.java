package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity //Dichiaro che questa è una entità, dovrò poi mapparla nell'Hibernate.cfg.xml
@Table(name="UTable") //Anotazione per impostare il nome della tabella, altrimenti assegna alla tabella lo stesso nome della classe
public class Utente {

	@Id //dichiaro che la variabile che segue è una primary key
	@GeneratedValue(strategy=GenerationType.AUTO) // dichiaro che il valore sarà generato automaticamente secondo la strategia che imposto
	private int id_utente;
	
//	@Column(name="nm") //Serve per rinominare le colonne in modo opportuno, se ha già creato le colonne ne aggiunge una nuova!
	private String nome;
	//	@Transient annotazione per dichiarare che questo campo non è da inserire nella tabella
	private String cognome;
		
	@Embedded
	private Indirizzo indirizzo;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="Stringhe")
	private Set<String> lista=new HashSet<String>();
	
	public Utente() {
	}
	
	public Utente(int id_utente, String nome, String cognome) {
		this.id_utente = id_utente;
		this.nome = nome;
		this.cognome = cognome;
	}

	public int getId_utente() {
		return id_utente;
	}

	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Set<String> getLista() {
		return lista;
	}

	public void setLista(Set<String> lista) {
		this.lista = lista;
	}
	
	public void addString(String s){
		this.lista.add(s);
	}
	
}
