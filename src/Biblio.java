import java.util.ArrayList;

class Auteur {
    
    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    // Completer la classe Auteur ici
    private String _nom;
    private boolean _prime; // indication permettant de savoir s’il a été primé
    
    public Auteur(String nom, boolean prime) {
        this._nom = nom;
        this._prime = prime;
    }
    
    public String getNom() {
        return this._nom;
    }
    
    public boolean getPrix() {
        return this._prime;
    }
    
}

class Oeuvre
{
    // Completer la classe Oeuvre ici
    private String _titre;
    private String _langue;
    private Auteur _auteur;
    
    public Oeuvre(String titre, Auteur auteur, String langue) {
        this._titre = titre;
        this._auteur = auteur;
        this._langue = langue;
    }
    
    public Oeuvre(String titre, Auteur auteur) {
        this(titre, auteur, "francais");
    }
    
    public String getTitre() {
        return this._titre;
    }
    
    public Auteur getAuteur() {
        return this._auteur;
    }
    
    public String getLangue() {
        return this._langue;
    }
    
    public String afficher() {
        return this._titre + ", " + this._auteur.getNom() + ", en " + this._langue;
    }
}

class Exemplaire {
    private Oeuvre _oeuvre;
    private String _message;
    
    public Exemplaire(Oeuvre oeuvre) {
        this._oeuvre = oeuvre;
        this._message = "Nouvel exemplaire -> ";
        this.afficher();
    }
    
    public Exemplaire(Exemplaire exemplaire) {
        this._oeuvre = exemplaire.getOeuvre();
        this._message = "Copie d'un exemplaire de -> ";
        this.afficher();
    }
    
    public Oeuvre getOeuvre() {
        return _oeuvre;
    }
    
    public void afficher() {
        System.out.print(this._message + this._oeuvre.afficher() + "\n");
        this._message = "Un exemplaire de ";
    }
}

class Bibliotheque {
    private String _nom;
    private ArrayList<Exemplaire> _exemplaires = new ArrayList();;
    
    public Bibliotheque(String nom) {
        _nom = nom;
        System.out.print("La bibliothèque " + this._nom + " est ouverte !\n");
    }
    
    public String getNom() {
        return this._nom;
    }
    
    public int getNbExemplaires(){
        return this._exemplaires.size();
    }
    
    public void stocker(Oeuvre o) {
        Exemplaire exemplaire = new Exemplaire(o);
        this._exemplaires.add(exemplaire);
    }
    
    public void stocker(Oeuvre o, int n) {
        for (int i = 0; i < n; i++) {
            Exemplaire exemplaire = new Exemplaire(o);
            this._exemplaires.add(exemplaire);
        }
    }
    
    public ArrayList<Exemplaire> listerExemplaires() {
        return this._exemplaires;
    }
    
    public ArrayList<Exemplaire> listerExemplaires(String langue) {
        ArrayList<Exemplaire> exemplairesParLangue = new ArrayList();
        for(Exemplaire exemplaire : this._exemplaires) {
            if(exemplaire.getOeuvre().getLangue() == langue) {
                exemplairesParLangue.add(exemplaire);
            }
        }
        return exemplairesParLangue;
    }
    
    public int compterExemplaires(Oeuvre oeuvre) {
        int nExemplaires = 0;
        for (Exemplaire exemplaire : this._exemplaires) {
            nExemplaires += exemplaire.getOeuvre() == oeuvre ? 1 : 0;
        }
        return nExemplaires;
    }
    
    public void afficherAuteur(boolean value) {
        for (Exemplaire exemplaire : this._exemplaires) {
            Auteur auteur = exemplaire.getOeuvre().getAuteur();
            if (!value && !auteur.getPrix()) { // si value est égal à false : afficher les auteurs sans prix
                System.out.print(auteur.getNom() + "\n");
            } else if (value && auteur.getPrix()) { // afficher les noms des auteurs avec un prix
                System.out.print(auteur.getNom() + "\n");
            }
        }
    }
    
    public void afficherAuteur() {
        this.afficherAuteur(true);
    }
}

// completer les autres classes ici


/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

public class Biblio {
    
    public static void afficherExemplaires(ArrayList<Exemplaire> exemplaires) {
        for (Exemplaire exemplaire : exemplaires) {
            System.out.print("\t");
            exemplaire.afficher();
        }
    }
    
    public static void main(String[] args) {
        // create and store all the exemplaries
        Auteur a1 = new Auteur("Victor Hugo", false);
        Auteur a2 = new Auteur("Alexandre Dumas", false);
        Auteur a3 = new Auteur("Raymond Queneau", true);
        
        Oeuvre o1 = new Oeuvre("Les Miserables", a1, "francais");
        Oeuvre o2 = new Oeuvre("L\'Homme qui rit", a1, "francais");
        Oeuvre o3 = new Oeuvre("Le Comte de Monte-Cristo", a2, "francais");
        Oeuvre o4 = new Oeuvre("Zazie dans le metro", a3, "francais");
        Oeuvre o5 = new Oeuvre("The count of Monte-Cristo", a2, "anglais");
        
        Bibliotheque biblio = new Bibliotheque("municipale");
        biblio.stocker(o1, 2);
        biblio.stocker(o2);
        biblio.stocker(o3, 3);
        biblio.stocker(o4);
        biblio.stocker(o5);
        
        // ...
        System.out.println("La bibliotheque " + biblio.getNom() + " offre ");
        afficherExemplaires(biblio.listerExemplaires());
        String langue = "anglais";
        System.out.println("Les exemplaires en " + langue + " sont  ");
        afficherExemplaires(biblio.listerExemplaires(langue));
        System.out.println("Les auteurs a succes sont  ");
        biblio.afficherAuteur();
        System.out.print("Il y a " + biblio.compterExemplaires(o3) + " exemplaires");
        System.out.println(" de  " + o3.getTitre());
    }
}
