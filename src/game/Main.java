package game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Choix des personnages
        System.out.println("Création du personnage du Joueur 1");
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        int choix1 = sc.nextInt();
        Personnage joueur1 = PersonnageBuilder.get_instance().Build("Joueur 1", TypePersonnage.convert(choix1));

        System.out.println("");
        System.out.println("Création du personnage du Joueur 2");
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        int choix2 = sc.nextInt();
        Personnage joueur2 = PersonnageBuilder.get_instance().Build("Joueur 2", TypePersonnage.convert(choix2));

        System.out.println("");

        while (joueur1.estVivant() && joueur2.estVivant()) {
            joueur1.attaquer(joueur2);

            if (!joueur2.estVivant()) {
                System.out.println("Joueur 2 a perdu !");
                break;
            }

            if (joueur1.estVivant() && joueur2.estVivant()) {
                joueur2.attaquer(joueur1);

                if (!joueur1.estVivant()) {
                    System.out.println("Joueur 1 a perdu !");
                    break;
                }
            }
        }
    }
}
