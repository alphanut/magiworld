package game;

public abstract class Personnage {

    int _niveau;
    int _vie;
    int _force;
    int _agilite;
    int _intelligence;
    String _nomAttaqueBasique;
    String _nomAttaqueSpeciale;
    String _joueur;
    String _nomPersonnage;

    /**
     * Construit un personnage
     * @param nom nom du personnage
     * @param force la force
     * @param agilite l'agilité
     * @param intelligence l'intelligence
     */
    public Personnage(String nom, int force, int agilite, int intelligence) {
        _nomPersonnage = nom;
        _force = force;
        _agilite = agilite;
        _intelligence = intelligence;
        calculerNiveau();
        initialiserVie();

        System.out.println(_nomPersonnage + " je suis le " + typePersonnage() + " " + _joueur + " niveau " + _niveau + " je possède " +
                _vie + " de vitalité, " + _force + " de force, " + _agilite + " d'agilité et " + _intelligence + " d'intelligence !");
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

    /**
     * Indique le tpe de personnage
     * @return Guerrier ou Mage ou Rodeur
     */
    public abstract String typePersonnage();

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
        System.out.println(_joueur + " perd " + valeur + " points de vie");
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

    public void set_joueur(String joueur) { _joueur = joueur; }
    public String get_joueur() { return _joueur; }

    /**
     * Indique si le personnage est en vie.
     * @return true si vivant sinon false
     */
    public boolean estVivant() { return _vie > 0; }

    public String get_nomPersonnage() { return _nomPersonnage; }
    public void set_nomPersonnage(String nom) { _nomPersonnage = nom; }

    public int get_niveau() { return _niveau; }
    public int get_vie() { return _vie; }
    public int get_force() { return _force; }
    public int get_agilite() { return _agilite; }
    public int get_intelligence() { return _intelligence; }
}
