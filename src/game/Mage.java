package game;

public class Mage extends Personnage {

    int _vieInitiale;

    /**
     * Construit un mage
     * @param force la force
     * @param agilite l'agilité
     * @param intelligence l'intelligence
     */
    public Mage(int force, int agilite, int intelligence) {
        super(force, agilite, intelligence);
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
        adversaire.subirDegats(_intelligence);
    }

    /**
     * Regagne des points de vie: intelligence x 2
     * @param adversaire adversaire attaqué
     */
    @Override
    public void attaqueSpeciale(Personnage adversaire) {
        soigner(_intelligence * 2);
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
}
