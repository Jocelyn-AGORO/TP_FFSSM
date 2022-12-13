/**
 * @(#) LicencePlongeur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Licence implements Comparable<Licence> {
    public final Personne possesseur;
    private List<Plongee> plongees;
    public Club emetteur;
    public String numero;

    public LocalDate delivrance;

    public Licence(Personne possesseur, String numero, LocalDate delivrance, Club club) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.emetteur = club;
        this.plongees = new ArrayList<>();
    }

    public Personne getPossesseur() {
        return possesseur;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDelivrance() {
        return delivrance;
    }

    public Club getClub() {
        return emetteur;
    }

    public List<Plongee> getPlongees() { return plongees; }

    /**
     * Est-ce que la licence est valide à la date indiquée ?
     * Une licence est valide pendant un an à compter de sa date de délivrance
     * @param d la date à tester
     * @return vrai si valide à la date d
     **/
    public boolean estValide(LocalDate d) {
         return (d.isBefore(delivrance.plusYears(1)) && d.isAfter(delivrance) ) || d.isEqual(delivrance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Licence licence = (Licence) o;
        return possesseur.equals(licence.possesseur) && emetteur.equals(licence.emetteur) && numero.equals(licence.numero) && delivrance.equals(licence.delivrance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(possesseur, emetteur, numero, delivrance);
    }

    @Override
    public int compareTo(Licence autre) {
        int comparaison = 0;
        if(this.delivrance.isAfter(autre.getDelivrance())){
            comparaison = 1;
        }else{
            comparaison = -1;
        }
        return comparaison;
    }
}
