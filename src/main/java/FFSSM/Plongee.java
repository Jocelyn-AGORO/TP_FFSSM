/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Plongee {

	public Site lieu;

	public Moniteur chefDePalanquee;

	private List<Licence> palanquee;
	public LocalDate date;

	public int profondeur;

	public int duree;

	public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
		this.lieu = lieu;
		this.chefDePalanquee = chefDePalanquee;
		this.date = date;
		this.profondeur = profondeur;
		this.duree = duree;
		this.palanquee = new ArrayList<>();
	}

	public void ajouteParticipant(Plongeur participant) {
		if(!participant.getLicences().isEmpty()){
			palanquee.add(participant.derniereLicence());
		}
	}

	public LocalDate getDate() {
		return date;
	}

	/**
	 * Détermine si la plongée est conforme. 
	 * Une plongée est conforme si tous les plongeurs de la palanquée ont une
	 * licence valide à la date de la plongée
	 * @return vrai si la plongée est conforme
	 */
	public boolean estConforme() {
		boolean res= true;
		LocalDate now= LocalDate.now();
		for(Licence list: palanquee){
			if(!list.estValide(now)){
				res=false;
				break;
			}
		}
		return res;
	}

}
