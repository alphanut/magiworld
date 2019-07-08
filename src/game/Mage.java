package game;

public class Mage extends Personnage {

    int _vieInitiale;

    /**
     * Construit un mage
     * @param nom le nom
     * @param force la force
     * @param agilite l'agilité
     * @param intelligence l'intelligence
     */
    public Mage(String nom, int force, int agilite, int intelligence) {
        super(nom, force, agilite, intelligence);
        _nomAttaqueBasique = "Boule de Feu";
        _nomAttaqueSpeciale = "Soin";
        _vieInitiale = _vie;
    }

    /**
     * Effectue des dommages égaux à l’intelligence du joueur sur l’adversaire
     * @param adversaire adversaire attaqué
     */
    @Override
    public void attaqueBasique(Personnage adversaire) {
        System.out.println(_joueur + " utilise " + _nomAttaqueBasique + " et inflige " + _intelligence + " dommages.");
        adversaire.subirDegats(_intelligence);
    }

    /**
     * Regagne des points de vie: intelligence x 2
     * @param adversaire adversaire attaqué
     */
    @Override
    public void attaqueSpeciale(Personnage adversaire) {
        int vie = _intelligence * 2;
        System.out.println(_joueur + " utilise " + _nomAttaqueSpeciale + " et gagne " + vie + " en vitalité.");
        soigner(vie);
    }

    @Override
    public String typePersonnage() {
        return "Mage";
    }

    /**
     * Soigne le mage sans dépasser le niveau de vie initial
     * @param vie point de vie à ajouter
     */
    protected void soigner(int vie) {
        _vie += vie;
        if (_vie > _vieInitiale)
            _vie = _vieInitiale;
    }

    public int get_vieInitiale() { return _vieInitiale; }
}
