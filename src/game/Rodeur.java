package game;

public class Rodeur extends Personnage {
    /**
     * Construit un rodeur
     * @param force la force
     * @param agilite l'agilité
     * @param intelligence l'intelligence
     */
    public Rodeur(int force, int agilite, int intelligence) {
        super(force, agilite, intelligence);
        _nomAttaqueBasique = "Tir à l'Arc";
        _nomAttaqueSpeciale = "Concentration";
    }

    /**
     * Améliore l'agilité du rodeur
     * @param valeur agilité à ajouter
     */
    protected void ameliorerAgilite(int valeur) {
        _agilite += valeur;
        if (_agilite > 100)
            _agilite = 100;

        calculerNiveau();
    }

    /**
     * Effectue des dommages égaux à l’agilité du joueur sur l’adversaire
     * @param adversaire adversaire attaqué
     */
    @Override
    public void attaqueBasique(Personnage adversaire) {
        adversaire.subirDegats(_agilite);
    }

    /**
     * Le rodeur gagne son niveau divisé par 2 en agilité
     * @param adversaire adversaire attaqué
     */
    @Override
    public void attaqueSpeciale(Personnage adversaire) {
        ameliorerAgilite(_niveau / 2);
    }
}
