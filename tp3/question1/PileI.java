package question1;


/**
 * Write a description of interface PileI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface PileI
{
    public final static int CAPACITE_PAR_DEFAUT = 6;
  
  public void empiler(Object o) throws PilePleineException;
  public Object depiler() throws PileVideException;
  
  public Object sommet() throws PileVideException;
  public int capacite();
  public int taille();
  public boolean estVide();
  public boolean estPleine();
  public boolean equals(Object o);
  public int hashCode();
  public String toString();
}
