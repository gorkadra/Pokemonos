package pokemon;

public class EntrenadorBot extends Entrenador{
    //atributos

    //constructor
    public EntrenadorBot(String pNombre, int pDinero) {
        super(pNombre, pDinero);
    }
    //metodos
    public Movimiento usarMovi(Pokemon pPoke){
        int numRandom = (int) (Math.random()*4+1);//numero aleatorio entre 1 y 4
        Movimiento usado = pPoke.usarMovi(numRandom); //guardar movimiento que se va a utilizar
        return usado;
    }
}
