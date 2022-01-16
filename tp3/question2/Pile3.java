package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * D�crivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un num�ro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;
    private int cap;

    public Pile3() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public Pile3(int taille) {
        // traiter le cas <=0
        // � compl�ter
         if (taille <= 0){
            taille = CAPACITE_PAR_DEFAUT;
        }
        this.v = new Vector<Object>();
        this.cap = taille;
    }

    public void empiler(Object o) throws PilePleineException {
        // � compl�ter
          if(estPleine()){
            throw new PilePleineException();
        }
        this.v.add(o);
    }

    public Object depiler() throws PileVideException {
        // � compl�ter
         if (estVide()){
            throw new PileVideException();
        }
        int d = v.lastIndexOf(sommet());    
        return this.v.remove(d);
    }

    public Object sommet() throws PileVideException {
        // � compl�ter
            if (estVide())
            throw new PileVideException();
        return this.v.lastElement();
    }

    public int taille() {
        // � compl�ter
        return v.size();
    }

    public int capacite() {
        // � compl�ter
        return this.cap;
    }

    public boolean estVide() {
        // � compl�ter
        return v.isEmpty();
    }

    public boolean estPleine() {
        // � compl�ter
        return this.v.size()==this.cap;
    }

    public String toString() {
        // � compl�ter
           String s = "[";
        for (int i = this.v.size() - 1; i >= 0; i--) {
            s+= this.v.get(i).toString();
            if(i >0){
                s+= ", ";
            }

        }
        return s + "]"; 
    }

    public boolean equals(Object o) {
        // � compl�ter
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
                    Object tmp = this.v.get(i);
                    boolean existe = false;
                    for(int j = this.v.size() - 1; j >= 0; j--){
                        if((tmp == p.v.get(i))){
                               existe = true;
                        }
                    }
                    if(existe){
                        estEgale = true;
                    } else{
                        return false;
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