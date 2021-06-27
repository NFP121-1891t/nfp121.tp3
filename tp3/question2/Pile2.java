package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        if (taille <= 0){
            taille = PileI.CAPACITE_PAR_DEFAUT;
        }
        this.stk = new Stack<Object>();
        this.capacite = taille;
    }

    // constructeur fourni
    public Pile2() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
       if(estPleine())  
        throw new  PilePleineException();
       this.stk.push(o);
    }

    public Object depiler() throws PileVideException {
        // a completer
        if(estVide())
          throw new PileVideException();
        return this.stk.pop();
    }

    public Object sommet() throws PileVideException {
        // a completer
        if (estVide()) throw new PileVideException();
        return this.stk.peek();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        // a completer
          return this.stk.empty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        // a complete   
        return this.stk.size()== capacite();
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
      String s = "[";
        // a completer
       
        for (int i = this.stk.size() - 1; i >= 0; i--) {
            s+= this.stk.get(i).toString();
            if(i >0){
                s+= ",";
            }       
        }
        return s + "]"; 
   
    }

    public boolean equals(Object o) {
        // a completer
         if( this== o ){
            return true;
        }      
        if(!(o instanceof Pile)){
            return false;
        }
        Pile2 p2 = (Pile2)o;
         if (p2.taille() == this.taille() && p2.capacite() == this.capacite()){
            boolean estEgale = false;
            //this pile 
            for(int i=this.stk.size() - 1; i >=0; i--){
                Object element =this.stk.get(i);
                  estEgale = false;
                  //compare the seconde pile
                for(int j = this.stk.size()-1; j>=0; j--){
                    if(element == p2.stk.get(i)){
                        estEgale = true;
                    }       
                }
                
            }
            return true;
            
        }                
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        // a completer
        return this.stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        // a completer
        return this.stk.capacity();
    }
} // Pile2.java
