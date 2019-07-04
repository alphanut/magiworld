package game;

public abstract class Personnage {

    int _niveau;
    int _vie;
    int _force;
    int _agilite;
    int _intelligence;
    String _nomAttaqueBasique;
    String _nomAttaqueSpeciale;

    /**
     * Attaque de base qui cause des dommages à l'adversaire
     * @param adversaire adversaire attaqué
     */
    public abstract void attaqueBasique(Personnage adversaire);

    /**
     * Attaque spéciale aux effets variés
     * @param adversaire adversaire attaqué
     */
    public abstract void attaqueSpeciale(Personnage adversaire);

    public String get_nomAttaqueBasique() {
        return _nomAttaqueBasique;
    }

    public String get_nomAttaqueSpeciale() {
        return _nomAttaqueSpeciale;
    }
}
