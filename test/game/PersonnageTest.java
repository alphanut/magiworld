package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PersonnageTest {

    @Test
    public void When_GuerrierAttaqueBasique_Then_AdversairePerdVie() {

        Guerrier guerrier = new Guerrier("Woarg", 10, 0, 0);
        Mage mage = new Mage("Abracadabra", 0, 0, 10);
        int vieMageAvant = mage.get_vie();
        guerrier.attaqueBasique(mage);
        int viePerduMage = vieMageAvant - mage.get_vie();

        assertEquals(guerrier.get_force(), viePerduMage);
    }

    @Test
    public void When_GuerrierAttaqueSpeciale_Then_AdversairePerdDoubleVieEtGuerrierPerdVie() {

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

    @Test
    public void When_MageAttaqueBasique_AdversairePerdVie() {
        Mage mage = new Mage("Abracadabra", 0, 0, 10);
        Guerrier guerrier = new Guerrier("Woarg", 10, 0, 0);
        int vieGuerrierAvant = guerrier.get_vie();
        mage.attaqueBasique(guerrier);
        int viePerdue = vieGuerrierAvant - guerrier.get_vie();

        assertEquals(mage.get_intelligence(), viePerdue);
    }

    @Test
    public void When_MageAttaqueSpeciale_Then_MageGainDeVie() {
        Mage mage = new Mage("Abracadabra", 0, 0, 10);
        Guerrier guerrier = new Guerrier("Woarg", 10, 0, 0);
        guerrier.attaqueBasique(mage);
        guerrier.attaqueBasique(mage);

        int vieAvant = mage.get_vie();
        mage.attaqueSpeciale(null);
        int vieGagnee = mage.get_vie() - vieAvant;

        assertEquals(2*mage.get_intelligence(), vieGagnee);
    }

    @Test
    public void When_MageAttaqueSpeciale_Then_GainDeVieMajore() {
        Mage mage = new Mage("Abracadabra", 0, 0, 10);
        Guerrier guerrier = new Guerrier("Woarg", 10, 0, 0);
        guerrier.attaqueBasique(mage);

        int vieAvant = mage.get_vie();
        mage.attaqueSpeciale(null);
        int vieGagnee = mage.get_vie() - vieAvant;
        int expectedVieGagne = mage.get_vieInitiale() - vieAvant; // la vie gagnée par un mage est majorée par la vie initiale

        assertEquals(expectedVieGagne, vieGagnee);
    }

    @Test
    public void When_RodeurAttaqueBasique_Then_AdversairePerdVie() {
        Rodeur rodeur = new Rodeur("Ninja", 0, 10, 0);
        Guerrier guerrier = new Guerrier("Woarg", 10, 0, 0);
        int vieAvant = guerrier.get_vie();
        rodeur.attaqueBasique(guerrier);
        int viePerdue = vieAvant - guerrier.get_vie();

        assertEquals(rodeur.get_agilite(), viePerdue);
    }

    @Test
    public void When_RodeurAttaqueSpeciale_Then_RodeurGainAgiliteEtNiveau() {
        Rodeur rodeur = new Rodeur("Ninja", 0, 10, 0);
        int agiliteAvant = rodeur.get_agilite();
        int niveauAvant = rodeur.get_niveau();
        rodeur.attaqueSpeciale(null);

        int agiliteGagnee = rodeur.get_agilite() - agiliteAvant;
        int niveauGagne = rodeur.get_niveau() - niveauAvant;

        assertEquals(niveauAvant / 2, agiliteGagnee);
        assertEquals(niveauAvant / 2, niveauGagne);
    }

    @Test
    public void When_PersonnageConstruit_Then_CalculNiveau() {
        Rodeur rodeur = new Rodeur("Ninja", 5, 10, 7);

        assertEquals(22, rodeur.get_niveau());
    }

    @Test
    public void When_PersonnageConstruit_Then_CalculVie() {
        Rodeur rodeur = new Rodeur("Ninja", 5, 10, 7);

        assertEquals(5*22, rodeur.get_vie());
    }
}
