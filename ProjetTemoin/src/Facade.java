import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import commandesEnLigne.*;

@Stateless
public class Facade {

	@PersistenceContext
	EntityManager em;

	public void ajout(String n, String p) {
		//Person pe = new Person();
		Utilisateur_itf pe = new Utilisateur();
		pe.setNom(n);
		pe.setPrenom(p);
		em.persist(pe);
	}

	public ArrayList<String> liste() {
		ArrayList<String> l = new ArrayList<String>();
		List<Utilisateur> lp = em.createQuery("from Client", Utilisateur.class).getResultList();
		//List<Person> lp = em.createQuery("from Person", Person.class).getResultList();
		for (Utilisateur p : lp) l.add(p.getNom() + "/" + p.getPrenom()+" / "+p.getId());
		//for (Person p : lp) l.add(p.getNom() + "/" + p.getPrenom()+" / "+p.getId());
		return l;
	}
}


