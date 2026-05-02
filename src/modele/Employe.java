package modele;

public class Employe {

    private String matricule;
    private String nom;
    private String prenom;
    private String departement;
    private double salaireBrut;

    public Employe(String matricule, String nom, String prenom, String departement, double salaireBrut) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.departement = departement;
        this.salaireBrut = salaireBrut;
    }

    public String getMatricule() { return matricule; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getDepartement() { return departement; }
    public double getSalaireBrut() { return salaireBrut; }

    public double calculerSalaireNet() {
        return salaireBrut * 0.78;
    }

    public void afficher() {
        double charges = salaireBrut * 0.22;

        System.out.println("===== FICHE EMPLOYÉ =====");
        System.out.println("Matricule : " + matricule);
        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Département : " + departement);
        System.out.println("Salaire brut : " + salaireBrut + " F");
        System.out.println("Charges (22%): " + charges + " F");
        System.out.println("Salaire net : " + calculerSalaireNet() + " F");
        System.out.println("=========================");
    }
    
}
