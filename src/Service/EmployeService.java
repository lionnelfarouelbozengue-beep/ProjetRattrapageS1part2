package Service;

import Entity.Employe;
import Repository.EmployeRepository;

public class EmployeService {

    private EmployeRepository repo = new EmployeRepository();

    public void inscrireEmploye(String matricule, String nom, String prenom,
                                String departement, double salaireBrut) {

        if (matricule == null || matricule.isEmpty()) {
            System.out.println("❌ Matricule invalide.");
            return;
        }

        if (repo.rechercherParMatricule(matricule) != null) {
            System.out.println("❌ Matricule déjà existant.");
            return;
        }

        if (nom.isEmpty() || prenom.isEmpty()) {
            System.out.println("❌ Nom ou prénom invalide.");
            return;
        }

        if (salaireBrut <= 0) {
            System.out.println("❌ Salaire invalide.");
            return;
        }

        Employe e = new Employe(matricule, nom, prenom, departement, salaireBrut);
        repo.ajouter(e);

        System.out.println("✔ Employé enregistré avec succès.");
    }

    public void afficherTousLesEmployes() {
        Employe[] list = repo.listerTous();

        if (list.length == 0) {
            System.out.println("Aucun employé.");
            return;
        }

        for (Employe e : list) {
            e.afficher();
        }
    }

    public void rechercherEtAfficher(String matricule) {
        Employe e = repo.rechercherParMatricule(matricule);

        if (e == null) {
            System.out.println("❌ Employé non trouvé.");
        } else {
            e.afficher();
        }
    }

    public void afficherStatistiques() {
        Employe[] list = repo.listerTous();

        if (list.length == 0) {
            System.out.println("Aucune donnée.");
            return;
        }

        double totalBrut = 0;
        double totalNet = 0;

        for (Employe e : list) {
            totalBrut += e.getSalaireBrut();
            totalNet += e.calculerSalaireNet();
        }

        int n = list.length;

        System.out.println("STATISTIQUES");
        System.out.println("Nombre d'employés : " + n);
        System.out.println("Salaire brut moyen : " + (totalBrut / n));
        System.out.println("Salaire net moyen : " + (totalNet / n));
        System.out.println("========================");
    }
}