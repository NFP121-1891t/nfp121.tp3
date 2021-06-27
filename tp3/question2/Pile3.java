package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;
 /** la capacite de la pile */
    private int capacite;
    public Pile3() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public Pile3(int taille) {
         if (taille <= 0){
            taille = PileI.CAPACITE_PAR_DEFAUT;
        }
        this.v = new Vector<Object>();
        this.capacite = taille;
    }

    public void empiler(Object o) throws PilePleineException {
        // à compléter 
        if(estPleine())
         throw new PilePleineException();
        this.v.add(o);
    }

    public Object depiler() throws PileVideException {
        // à compléter
        if(estVide()) 
         throw new PileVideException();
          int element = v.lastIndexOf(sommet());  
        return this.v.remove(element);
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return this.v.lastElement();
    }

    public int taille() {
        // à compléter
        return this.v.size();
    }

    public int capacite() {
        // à compléter
        return  this.v.capacity();
    }

    public boolean estVide() {
        // à compléter
        return this.v.isEmpty();
    }

    public boolean estPleine() {
        // à compléter
        return taille()==capacite();
    }

    public String toString() {
        String s = "[";
        for (int i = this.v.size() - 1; i >= 0; i--) {
            s+= this.v.get(i).toString();
            if(i >0){
                s+= ",";
            }

        }
        return s + "]"; 
    }

    public boolean equals(Object o) {
        if( this== o ){
            return true;
        }
        if(!(o instanceof Pile3)){
            return false;
        }
        Pile3 p = (Pile3) o;
        if(this.taille() == p.taille()){
            if(this.capacite() == p.capacite()){
               boolean estEgale = false; 
               for (int i = this.v.size() - 1; i >= 0; i--) {
                    Object element = this.v.get(i);
                       estEgale = false;
                    for(int j = this.v.size() - 1; j >= 0; j--){
                        if((element == p.v.get(i))){
                               estEgale = true;
                        }
                    }
               }
               return true;
               
            }

        }
        return false;
    
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
