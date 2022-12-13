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



}
