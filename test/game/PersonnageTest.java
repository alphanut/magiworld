package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PersonnageTest {

    @Test
    public void Guerrier_AttaqueBasique() {

        Guerrier guerrier = new Guerrier("Woarg", 10, 0, 0);
        Mage mage = new Mage("Abracadabra", 0, 0, 10);
        int vieMageAvant = mage.get_vie();
        guerrier.attaqueBasique(mage);
        int viePerduMage = vieMageAvant - mage.get_vie();

        assertEquals(guerrier.get_force(), viePerduMage);
    }

    @Test
    public void Guerrier_AttaqueSpeciale() {

        Guerrier guerrier = new Guerrier("Woarg", 10, 0, 0);
        Mage mage = new Mage("Abracadabra", 0, 0, 10);
        int vieMageAvant = mage.get_vie();
        int vieGuerrierAvant = guerrier.get_vie();
        guerrier.attaqueSpeciale(mage);
        int viePerduMage = vieMageAvant - mage.get_vie();
        int viePerduGuerrier = vieGuerrierAvant - guerrier.get_vie();

        assertEquals(2*guerrier.get_force(), viePerduMage);
        assertEquals(guerrier.get_force()/2, viePerduGuerrier);
    }
}
