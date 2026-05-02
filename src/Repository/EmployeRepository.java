package repository;

import java.util.ArrayList;

import modele.Employe;

public class EmployeRepository {

    private ArrayList<Employe> employes = new ArrayList<>();
    private final int MAX = 10;

    public void ajouter(Employe e) {
        if (employes.size() >= MAX) {
            System.out.println("❌ Tableau plein !");
            return;
        }
        employes.add(e);
    }

    public Employe[] listerTous() {
        return employes.toArray(new Employe[0]);
    }
    public Employe rechercherParMatricule(String matricule) {
        for (Employe e : employes) {
            if (e.getMatricule().equals(matricule)) {
                return e;
            }
        }
        return null;
    }

    public int compter() {
        return employes.size();
    }
}
