package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
   
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    
    public Pile2(int taille){
         if (taille <= 0){
            taille = CAPACITE_PAR_DEFAUT;
        }
        this.stk = new Stack<T>();
        this.capacite = taille;
    }

    public Pile2(){
          this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(T o) throws PilePleineException{
       if(estPleine()){
            throw new PilePleineException();
        }
        this.stk.push(o);
    }

    public T depiler() throws PileVideException{
         if (estVide())
            throw new PileVideException();
        return this.stk.pop();
    }

    public T sommet() throws PileVideException{
        if (estVide())
            throw new PileVideException();
        return this.stk.peek();
    }

    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile
  public int capacite(){
         return this.capacite;
    }

    /**
     * Retoune le nombre d'�l�ments pr�sent dans la pile.
     */
    public int taille(){
         return this.stk.size();
    }

    /**
     * Retourne true si la pile est vide.
     */
    public boolean estVide(){
        return this.stk.empty();
    }

    /**
     * Retourne true si la pile est pleine.
     */
    public boolean estPleine(){
        return this.stk.size() == this.capacite;
    }   
} // Pile2
