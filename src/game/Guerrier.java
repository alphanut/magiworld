package game;

public class Guerrier extends Personnage {

    /**
     * Construit un guerrier
     * @param joueur nom du joueur
     * @param nom le nom
     * @param force la force
     * @param agilite l'agilité
     * @param intelligence l'intelligence
     */
    public Guerrier(String joueur, String nom, int force, int agilite, int intelligence) {
        super(joueur, nom, force, agilite, intelligence);
        _nomAttaqueBasique = "Coup d'Epée";
        _nomAttaqueSpeciale = "Coup de Rage";
    }

    /**
     * Effectue des dommages égaux à la force du joueur sur l’adversaire
     * @param adversaire adversaire attaqué
     */
    @Override
    public void attaqueBasique(Personnage adversaire) {

        System.out.println(_joueur + " utilise " + _nomAttaqueBasique + " et inflige " + _force + " dommages.");
        adversaire.subirDegats(_force);
    }

    /**
     * Effectue des dommages égaux à la force du joueur fois deux sur l’adversaire et perd de la vitalité : la valeur de sa force divisée par 2.
     * @param adversaire adversaire attaqué
     */
    @Override
    public void attaqueSpeciale(Personnage adversaire) {
        int degats = 2 * _force;
        System.out.println(_joueur + " utilise " + _nomAttaqueSpeciale + " et inflige " + degats + " dommages.");
        adversaire.subirDegats(degats);
        subirDegats(_force / 2);
    }

    @Override
    public TypePersonnage typePersonnage() {
        return TypePersonnage.Guerrier;
    }
}
