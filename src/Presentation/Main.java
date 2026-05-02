package Presentation;

import Service.EmployeService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeService service = new EmployeService();
        int choix;

        do {
            System.out.println("===== GESTION DES EMPLOYÉS =====");
            System.out.println("1. Ajouter");
            System.out.println("2. Afficher tous");
            System.out.println("3. Rechercher");
            System.out.println("4. Statistiques");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");

            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Matricule : ");
                    String m = sc.nextLine();
                    System.out.print("Nom : ");
                    String nom = sc.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = sc.nextLine();
                    System.out.print("Département : ");
                    String dep = sc.nextLine();
                    System.out.print("Salaire : ");
                    double sal = sc.nextDouble();

                    service.inscrireEmploye(m, nom, prenom, dep, sal);
                    break;

                case 2:
                    service.afficherTousLesEmployes();
                    break;

                case 3:
                    System.out.print("Matricule : ");
                    String mat = sc.nextLine();
                    service.rechercherEtAfficher(mat);
                    break;

                case 4:
                    service.afficherStatistiques();
                    break;

                case 5:
                    System.out.println("Fin du programme.");
                    break;

                default:
                    System.out.println("❌ Choix invalide.");
            }

        } while (choix != 5);

        sc.close();
    }
}