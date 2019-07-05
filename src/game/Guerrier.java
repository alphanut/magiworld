package game;

public class Guerrier extends Personnage {

    /**
     * Construit un guerrier
     * @param force la forece
     * @param agilite l'agilité
     * @param intelligence l'intelligence
     */
    public Guerrier(int force, int agilite, int intelligence) {
        super(force, agilite, intelligence);
        _nomAttaqueBasique = "Coup d'Epée";
        _nomAttaqueSpeciale = "Coup de Rage";
    }

    /**
     * Effectue des dommages égaux à la force du joueur sur l’adversaire
     * @param adversaire adversaire attaqué
     */
    @Override
    public void attaqueBasique(Personnage adversaire) {
        adversaire.subirDegats(_force);
    }

    /**
     * Effectue des dommages égaux à la force du joueur fois deux sur l’adversaire et perd de la vitalité : la valeur de sa force divisée par 2.
     * @param adversaire adversaire attaqué
     */
    @Override
    public void attaqueSpeciale(Personnage adversaire) {
        adversaire.subirDegats(2 * _force);
        subirDegats(_force / 2);
    }
}
