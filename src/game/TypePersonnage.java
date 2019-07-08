package game;

public enum TypePersonnage {
    Guerrier,
    Rodeur,
    Mage;

    public static TypePersonnage convert(int num) {
        if (num == 1)
            return Guerrier;
        else if (num == 2)
            return Rodeur;
        else
            return Mage;
    }
}
