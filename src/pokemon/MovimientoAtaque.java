package pokemon;

public class MovimientoAtaque extends Movimiento {
    //atributos
    private int potencia;
    //constructor
    public MovimientoAtaque(int pTipo, String pDescripcion, int pId,boolean pCat, int pPotencia) {
        super(pTipo,pDescripcion,pId,pCat);
        this.potencia = pPotencia;
    }
    //metodos
    public int getPotencia() {
        return this.potencia;
    }
}