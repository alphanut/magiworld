package game;

import java.util.Scanner;

public class PersonnageBuilder {

    private PersonnageBuilder() { }

    private static PersonnageBuilder _instance = null;

    public static PersonnageBuilder get_instance() {
        if (_instance == null)
            _instance = new PersonnageBuilder();

        return _instance;
    }

    /**
     * Construit un personnage cohérent pour un joueur
     * @param joueur nom du joueur
     * @param typePersonnage type de personnage (Guerrier, Roduer, Mage)
     * @return un personnage cohérent i.e. niveau = force + agilite + intelligence
     */
    public Personnage Build(String joueur, TypePersonnage typePersonnage) {

        int niveau, force, agilite, intelligence;
        boolean saisieValide = false;

        Personnage personnage = null;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Niveau du personnage ?");
            niveau = sc.nextInt();

            System.out.println("Force du personnage ?");
            force = sc.nextInt();

            System.out.println("Agilité du personnage ?");
            agilite = sc.nextInt();

            System.out.println("Intelligence du personnage ?");
            intelligence = sc.nextInt();

            saisieValide = (niveau == (force + agilite + intelligence));

            if (!saisieValide)
                System.out.println("Attention le total force + agilité + intelligence doit être égal au niveau du joueur.");

        } while (!saisieValide);

        switch (typePersonnage) {
            case Guerrier:
                personnage = new Guerrier(joueur, "Woarg", force, agilite, intelligence);
                break;
            case Rodeur:
                personnage = new Rodeur(joueur, "Ninja", force, agilite, intelligence);
                break;
            case Mage:
                personnage = new Mage(joueur, "Abracadabra", force, agilite, intelligence);
                break;
        }


        return personnage;
    }
}
