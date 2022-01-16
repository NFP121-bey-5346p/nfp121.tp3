package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        // traiter le cas <=0
        // a completer
          if (taille <= 0){
            taille = CAPACITE_PAR_DEFAUT;
        }
        this.zone = new Object[taille];
        this.ptr = 0;

    }

    public Pile() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        // a completer
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] =o;
        this.ptr++;

    }

    public Object depiler() throws PileVideException {
        // a completer
         if (estVide())
            throw new PileVideException();
        this.ptr--;
        return this.zone[ptr];
    }

    public Object sommet() throws PileVideException {
        // a completer
        
        if (estVide())
            throw new PileVideException();

        return this.zone[ptr-1];

    }

    public int capacite() {
        // a completer
        return this.zone.length;
    }

    public int taille() {
        // a completer
        if(estVide()){
            ptr = 0;
        }
        return this.ptr;

    }

    public boolean estVide() {
        // a completer
        return this.ptr==0;
    }

    public boolean estPleine() {
        // a completer
        return this.ptr == this.zone.length;

    }

    public boolean equals(Object o) {
        if( this== o ){
            return true;
        }      
        if(!(o instanceof Pile)){
            return false;
        }
        Pile p = (Pile)o;

        if (p.taille() == this.taille() && p.capacite() == this.capacite()){
            boolean estEgale = false;
            for(int i=zone.length - 1; i >=0; i--){
                Object tmp = zone[i];
                boolean egal = false;
                for(int j = zone.length-1; j>=0; j--){
                    if(tmp == p.zone[i]){
                        egal = true;
                    }       
                }
                if(egal){
                    estEgale = true;
                }else{
                    return false;
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

    public String toString() {
         StringBuffer s = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            s.append(zone[i].toString());
            if (i > 0)
                s.append(", ");
        }
        s.append("]");
        return s.toString();
    }
}