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
     * Construit un personnage
     * @param force la force
     * @param agilite l'agilité
     * @param intelligence l'intelligence
     */
    public Personnage(int force, int agilite, int intelligence) {
        _force = force;
        _agilite = agilite;
        _intelligence = intelligence;
        calculerNiveau();
        initialiserVie();
    }

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

    /**
     * Dégâts subis par le personnage lors d'une attaque
     * @param valeur nombre de points de vie perdu
     */
    public void subirDegats(int valeur) {
        _vie -= valeur;
        if (_vie < 0)
            _vie = 0;
    }

    /**
     * Calcule le niveau à partir de la force, de l'agilité et de l'intelligence
     */
    protected void calculerNiveau() {
        _niveau = _force + _agilite + _intelligence;
    }

    /**
     * Initialiser les points de vie du personnage
     */
    protected void initialiserVie() {
        _vie = 5 * _niveau;
    }
}
