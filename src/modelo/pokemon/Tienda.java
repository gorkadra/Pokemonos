package modelo.pokemon;
import java.util.Iterator;

public class Tienda {
    // Atributos
    private static Tienda miTienda;
    private ListaMovi lista;

    // constructor
    private Tienda() {
        lista = new ListaMovi();
    }

    public static Tienda getMiTienda() {
        if (miTienda == null) {
            miTienda = new Tienda();
        }
        return miTienda;
    }
    public ListaMovi getMiListaMovi() {
        return this.lista;
    }
    private void ponerMovi() {
        int[] listaNum = new int[4];
        boolean dago = false;
        int i = 1;
        int loop = 0;
        while(i<=4) {
            int numAleatorio = (int) (Math.random()*ColeccionMovi.getMiListaMovi().listaLongi());
            while(loop <= 3 && !dago) {
                if(listaNum[loop]==numAleatorio) {
                    dago = true;
                }
                loop = loop + 1;
            }
            if(!dago) {
                Movimiento mov = ColeccionMovi.getMiListaMovi().aplicarMovi(numAleatorio);
                this.lista.addMovi(mov); // guardar movimiento en la tienda
                i = i + 1;
            }
            else {
                dago = false;
            }
            loop = 0;
        }
    }
    public Movimiento comprarMov() {
        this.ponerMovi();
        int kont = 0;
        boolean todoBien = false;
        Movimiento comprable = null;
        while (kont < 5 && !todoBien) {
            Tienda.getMiTienda().imprimirMov();
            comprable = this.lista.hartuXPosiziokoMugimendua(1);
            System.out.println("Quieres comprar este movimiento?");
            if (comprable instanceof MovimientoStat) {
                System.out.println(((MovimientoStat) comprable).getDescripcion());
                System.out.println("Este movimiento " + ((MovimientoStat) comprable).getEstadistica() + " por " + ((MovimientoStat) comprable).getBooster());
                //System.out.println(((MovimientoStat) comprable).get() + "$ kostatzen du");
                System.out.println("");
            } else {
                System.out.println(((MovimientoAtaque) comprable).getDescripcion());
                System.out.println("La potencia de este movimiento es: " + ((MovimientoAtaque) comprable).getPotencia());
                //System.out.println(((MovimientoStat) comprable).getPrezioa() + "$ kostatzen du");
                System.out.println("");
            }

            kont = kont + 1;
        }
        if(todoBien) {
            return comprable;
        }
        else {
            return  null;
        }
    }

    private void imprimirMov() {
        Iterator<Movimiento> itr = this.lista.getIterador();
        while (itr.hasNext()) {
            Movimiento actual = itr.next();
            if (actual instanceof MovimientoStat) {
                System.out.println(((MovimientoStat) actual).getDescripcion());
                // System.out.println(((MugimenduBerezia) erosteko).getBooster());
                // System.out.println(((MugimenduBerezia) erosteko).getEstadistika());
                System.out.println("Mugimendu honek zure " + ((MovimientoStat) actual).getEstadistica() + " "
                        + ((MovimientoStat) actual).getBooster() + " bider aldatzen du");
                //System.out.println(((MovimientoStat) actual).getPrezioa() + "$ kostatzen du");
                System.out.println("");
            } else {
                System.out.println(((MovimientoAtaque) actual).getDescripcion());
                System.out.println(
                        "Mugimendu honek honako potentzia du " + ((MovimientoAtaque) actual).getPotencia());
                //System.out.println(((MovimientoAtaque) actual).getPrezioa() + "$ kostatzen du");
                System.out.println("");
            }
        }
    }
    public void erreseteatu() {
        this.lista.getMiLista().clear();
    }
}
