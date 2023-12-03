package password;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choisissez le niveau de sécurité pour votre mot de passe:");
        System.out.println("1: Faible");
        System.out.println("2: Moyen");
        System.out.println("3: Fort");

        int choix = scanner.nextInt();
        String password = "";

        switch (choix) {
            case 1: // Faible: seulement des lettres minuscules, longueur 6-8
                password = PasswordGenerator.generate(6 + (int)(Math.random() * 3), true, false, false, false);
                break;
            case 2: // Moyen: lettres minuscules et majuscules, longueur 8-10
                password = PasswordGenerator.generate(8 + (int)(Math.random() * 3), true, true, false, false);
                break;
            case 3: // Fort: tous les types de caractères, longueur 12-16
                password = PasswordGenerator.generate(12 + (int)(Math.random() * 5), true, true, true, true);
                break;
            default:
                System.out.println("Choix invalide. Génération d'un mot de passe fort par défaut.");
                password = PasswordGenerator.generate(12 + (int)(Math.random() * 5), true, true, true, true);
        }

        System.out.println("Votre mot de passe: " + password);
        scanner.close();
    }
}
