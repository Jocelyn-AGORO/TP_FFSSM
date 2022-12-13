package FFSSM;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class FFSSMJUnitTest {

    Club club;
    Moniteur moniteur;
    Licence licence;
    Plongee plongee;
    Plongeur plongeur;



    @BeforeEach
    public void setUp() {
        plongeur = new Plongeur("BX-LO1000", "Dupont", "Jean", "31 Rue Louis Vieu", "0612587963", LocalDate.of(2000, 10, 12), 20);
        moniteur = new Moniteur("BX-LO1000", "Dupont", "Jean", "31 Rue Louis Vieu", "0612587963", LocalDate.of(2000, 10, 12), 20, 5217896);
        club = new Club(moniteur, "ClubY", "0652369874");
        licence = new Licence(plongeur, "1555558", LocalDate.of(2022, 5, 23), club);
    }

    @Test
    public void testLicenceValide() {
        LocalDate aDate = LocalDate.of(2022, 12 , 10);
        LocalDate anotherDate = LocalDate.of(2020, 12 , 5);
        assertTrue(licence.estValide(aDate));
        assertFalse(licence.estValide(anotherDate));
    }

    @Test
    public void testDerniereLicence() {
        plongeur.ajouteLicence("1455584", LocalDate.of(2020, 5, 23), club);
        plongeur.ajouteLicence("1555558", LocalDate.of(2021, 6, 10), club);
        plongeur.ajouteLicence("1555558", LocalDate.of(2022, 11, 10), club);
        Licence attendu = new Licence(plongeur,"1555558", LocalDate.of(2022, 11, 10), club);
        boolean result = attendu.equals(plongeur.derniereLicence());
        assertTrue(result, "La dernière licence n'est pas correcte");
    }

    @Test
    public void testPlongeeConforme(){
        Plongeur plongeur2 = new Plongeur("BX-LO1004", "Durand", "Loris", "8 Rue de Metz", "0612587763", LocalDate.of(2021, 10, 12), 10);
        Plongeur plongeur3 = new Plongeur("BX-LO1002", "Durand", "Jean", "10 Rue de Metz", "0612587963", LocalDate.of(2020, 10, 5), 5);
        Plongee plonge = new Plongee(null, moniteur, LocalDate.of(2022, 5, 10), 7, 25);
        plongeur2.ajouteLicence("1555558", LocalDate.of(2021, 6, 10), club);
        plongeur3.ajouteLicence("1455584", LocalDate.of(2020, 5, 23), club);
        plonge.ajouteParticipant(plongeur2);
        plonge.ajouteParticipant(plongeur3);
        assertFalse(plonge.estConforme());
    }



}
