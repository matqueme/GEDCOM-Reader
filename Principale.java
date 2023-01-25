import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principale {
    static String sexe = null;
    static String nom = null;
    static String prenoms = null;
    static int anneeNaissance, anneeDeces;
    static List<Personne> tribu = new ArrayList<Personne>();

    public static void main(String[] args) throws FileNotFoundException {

        // ouvrir le fichier
        File doc = new File("geneafinder.ged");
        Scanner obj = new Scanner(doc, "UTF-8");

        List<String> gedcomData = new ArrayList<String>();

        while (obj.hasNextLine()) {
            gedcomData.add(new String(obj.nextLine()));
        }
        for (int i = 0; i < gedcomData.size(); i++) {
            if (gedcomData.get(i).startsWith("0 @")) {

                while (!gedcomData.get(i + 1).startsWith("0 @") && i + 2 < gedcomData.size()) {
                    if (gedcomData.get(i).startsWith("2 SURN")) {
                        nom = gedcomData.get(i).substring(7);
                        if (nom.equals("?")) {
                            nom = null;
                        }
                    }
                    if (gedcomData.get(i).startsWith("2 GIVN")) {
                        prenoms = gedcomData.get(i).substring(7);
                        if (prenoms.equals("?")) {
                            prenoms = null;
                        }
                    }
                    if (gedcomData.get(i).startsWith("1 SEX")) {
                        sexe = gedcomData.get(i).substring(6);
                    }
                    if (gedcomData.get(i).startsWith("1 BIRT")) {
                        if (gedcomData.get(i + 1).startsWith("2 DATE")) {
                            anneeNaissance = Integer
                                    .parseInt(gedcomData.get(i + 1).substring(gedcomData.get(i + 1).length() - 4));
                        }
                    }
                    if (gedcomData.get(i).startsWith("1 DEAT")) {
                        if (gedcomData.get(i + 1).startsWith("2 DATE")) {
                            anneeDeces = Integer
                                    .parseInt(gedcomData.get(i + 1).substring(gedcomData.get(i + 1).length() - 4));
                        }
                    }
                    i++;
                }
                if (sexe != null && nom != null && prenoms != null && anneeNaissance != 0 && anneeDeces != 0) {
                    tribu.add(new Personne(sexe, prenoms, nom, anneeNaissance, anneeDeces));
                }
                sexe = null;
                nom = null;
                prenoms = null;
                anneeNaissance = 0;
                anneeDeces = 0;
            }
        }
        System.out.println(tribu);
        new MyInterface(tribu);
        // fermer le fichier
        obj.close();
    }
}
