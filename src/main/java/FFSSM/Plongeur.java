package FFSSM;

import java.time.LocalDate;
import java.util.TreeSet;

public class Plongeur extends Personne {

    private TreeSet<Licence> licences;

    private GroupeSanguin groupeSanguin;
    private int niveau;

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.licences = new TreeSet<>();
    }

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin groupeSanguin) {
        this(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau);
        this.groupeSanguin = groupeSanguin;
    }

    public TreeSet<Licence> getLicences() {
        return licences;
    }

    public GroupeSanguin getGroupeSanguin() {
        return groupeSanguin;
    }

    public int getNiveau() {
        return niveau;
    }

    public void ajouteLicence(String numero, LocalDate delivrance, Club club) {
        this.licences.add(new Licence(this, numero, delivrance, club));
    }
    public Licence derniereLicence() {
        return licences.last();
    }

}
