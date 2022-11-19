package modelo.pokemon;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaMovi {
    //atributos
    private ArrayList<Movimiento> listaMovi;
    //constructor
    public ListaMovi() {
        this.listaMovi = new ArrayList<Movimiento>();
    }
    //metodos
    public ArrayList<Movimiento> getMiLista(){
        return this.listaMovi;
    }
    public int listaLongi() {
        return this.listaMovi.size();
    }
    public void addMovi(Movimiento pMovi) {
        this.listaMovi.add(pMovi);
    }

    public void removeMugimendu(Movimiento pMovi) {
        this.listaMovi.remove(pMovi);
    }

    public Movimiento buscarPorId(int moviId) {
        Movimiento res = null;
        boolean enc = false;
        Iterator<Movimiento> itr = this.getIterador();
        while(itr.hasNext() &&!enc){
            Movimiento mom = itr.next();
            if(mom.idIgual(moviId)) {
                enc = true;
                res = mom;
            }
        }
        return res;
    }
    public void cambiarMovi(Movimiento pMovi,int pNum){
        this.listaMovi.set(pNum- 1, pMovi);
    }
    public Movimiento hartuXPosiziokoMugimendua(int pPosicion) {
        return this.getMiLista().get(pPosicion-1);
    }
    public Iterator<Movimiento> getIterador() {
        return this.listaMovi.iterator();
    }
    public void imprimirMovi() {
        for (int i = 0;i<listaMovi.size();i++) {
            System.out.println(this.listaMovi.get(i).getDescripcion());
        }
    }
    public void reset() {
        this.listaMovi.clear();
    }
}