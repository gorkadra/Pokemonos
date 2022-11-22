package modelo.pokemon;

import java.util.Observable;
import java.util.Observer;

public class EntrenadorPropio extends Entrenador {
    //atributos
    private static EntrenadorPropio yo;
    private float efec;
    private String usado;
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
    public Movimiento usarMoviNum(Pokemon pPoke, int num) {
        Movimiento usar = pPoke.usarMovi(num);
        return usar;
    }
    @Override
    public void setNombre(String pNombre){
        super.setNombre(pNombre);
        setChanged();
        notifyObservers(Notificaciones.empezar);
    }
    public void setUsado(String ataque, float pMul){
        usado = ataque;
        efec = pMul;
    }
    public String getUsadoNom(){
        return usado;
    }
    public float getUsadoMul(){
        return efec;
    }

    @Override
    public Movimiento usarMovi(Pokemon pPoke) {
        return null;
    }

    @Override
    public synchronized void addObserver(Observer o) {
        // TODO Auto-generated method stub
        super.addObserver(o);
    }
}
