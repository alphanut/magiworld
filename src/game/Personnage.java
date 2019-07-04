package game;

public abstract class Personnage {

    int _niveau;
    int _vie;
    int _force;
    int _agilite;
    int _intelligence;

    abstract void attaqueBasique(Personnage adversaire);
    abstract void attaqueSpecial(Personnage adversaire);
}
