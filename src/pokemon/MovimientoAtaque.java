package pokemon;

public class MovimientoAtaque extends Movimiento {
    //atributos
    private int potencia;
    //constructor
    public MovimientoAtaque(int pTipo, String pDescripcion, int pId,int pPrecio, int pPotencia) {
        super(pTipo,pDescripcion,pId,pPrecio);
        this.potencia = pPotencia;
    }
    //metodos
    public int getPotencia() {
        return this.potencia;
    }
}