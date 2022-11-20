package modelo.pokemon;

import java.util.Observable;
import java.util.Observer;

public class EntrenadorPropio extends Entrenador {
    //atributos
    private static EntrenadorPropio yo;
    //constructor
    private EntrenadorPropio() {
        super(10);
    }
    public static EntrenadorPropio getEntrenadorPropio(){
        if(yo==null){
            yo=new EntrenadorPropio();
        }
        return yo;
    }
    //metodos
    @Override
    public Movimiento usarMovi(Pokemon pPoke) {
        Integer num = Teclado.getMiTeclado().leerEntero();
        Movimiento usar = pPoke.usarMovi(num);
        return usar;
    }
    @Override
    public void setNombre(String pNombre){
        super.setNombre(pNombre);
        setChanged();
        notifyObservers(Notificaciones.empezar);
    }

    @Override
    public synchronized void addObserver(Observer o) {
        // TODO Auto-generated method stub
        super.addObserver(o);
    }
}
