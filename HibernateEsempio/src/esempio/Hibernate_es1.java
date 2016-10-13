package esempio;

import hibernateUtil.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Indirizzo;
import model.Utente;

public class Hibernate_es1 {

	public static void main(String[] args) {

		Utente u1=new Utente();
		u1.setNome("AAAAA");
		u1.setCognome("aaaaa");
		Indirizzo i1=new Indirizzo("Torino", "corso Vittorio");
		u1.setIndirizzo(i1);
		u1.addString("cccc");
		u1.addString("mmmm");
		u1.addString("rrrr");
//		Utente u2=new Utente(13,"BBBBB","bbbbb");
		Utente u2=new Utente();
		u2.setNome("BBBBB");
		u2.setCognome("bbbbb");
		Indirizzo i=new Indirizzo("Torino", "corso Svizzera");
		u2.setIndirizzo(i);
		u2.addString("lll");
		u2.addString("mmmm");
		u2.addString("rrrr");
//		Utente u3=new Utente();
//		u3.setNome("CCCC");
//		u3.setCognome("cccc");
		Utente u=null;
				
//		SessionFactory sf= new Configuration().configure().buildSessionFactory();
//		
//		Session session=sf.openSession();
//		
//		session.beginTransaction();
		
		//per salvare i dati sulla tabella
//		session.save(u1);
//		session.save(u2);
//		session.save(u3);
		
		//per leggere un elemento dalla tabella di cui conosco l'id.
//		u=session.get(Utente.class,14);
		//per eliminare una riga
//		session.delete(u2);
//		
//		session.getTransaction().commit();
//		session.close();
//		
//		System.out.println(u.getNome()+ " " + u.getCognome());
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;
		//Voglio gestire gli eventuali problemi che posso avere nel comunicare con il database
		try{
		tx=session.getTransaction();
		tx.begin();
		//lavori da fare
		session.save(u1);
		session.save(u2);
		u=session.get(Utente.class, 3);
		 
		 tx.commit();
		}catch(Exception ex){
			//Annulla ogni cosa che abbiamo fatto se c'è stato un problema. Mantiene il database ACID
			tx.rollback();
		}finally{
			session.close();
		}
		System.out.println(u.getNome()+ " " + u.getIndirizzo().getCittà());
		
		for(String s: u.getLista())
		{
			System.out.println(s);
		}
	}

}
