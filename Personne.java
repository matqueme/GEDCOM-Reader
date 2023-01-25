public class Personne {
    // les attributs
    String sexe;
    String nom;
    String prenoms;
    int anneeNaissance, anneeDeces, age;

    // le constructeur
    Personne(String sexe, String nom, String prenoms, int anneeNaissance, int anneeDeces) {
        this.sexe = sexe;
        this.nom = nom;
        this.prenoms = prenoms;
        this.anneeNaissance = anneeNaissance;
        this.anneeDeces = anneeDeces;
        this.age = this.anneeDeces - this.anneeNaissance;
    }
    // les accesseurs en lecture

    public String getSexe() {
        return (this.sexe);
    }

    public String getNom() {
        return (this.nom);
    }

    public String getPrenoms() {
        return (this.prenoms);
    }

    public int getAnneeNaissance() {
        return (this.anneeNaissance);
    }

    public int getAnneeDeces() {
        return (this.anneeDeces);
    }

    public int getAge() {
        return (this.age);
    }
    // autres méthodes

    public String toString() {
        return (this.prenoms + " " + this.nom
                + " (" + this.sexe + ")\n"
                + "Naissance : " + this.anneeNaissance + "\t"
                + "Décès : " + this.anneeDeces + "\t"
                + "Age : " + this.age + " ans\n");
    }
}