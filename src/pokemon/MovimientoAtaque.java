package pokemon;

public class MovimientoAtaque extends Movimiento {
    //atributos
    private int potencia;
    private boolean categoria; //fisico (T) o especial(F)

    //constructor
    public MovimientoAtaque(int pTipo, String pDescripcion, int pId, int pPrecio,boolean pCat, int pPotencia) {
        super(pTipo,pDescripcion,pId, pPrecio);
        this.potencia = pPotencia;
        this.categoria = pCat;
    }
    //metodos
    public int getPotencia() {
        return this.potencia;
    }
    public boolean getCat() {
        return this.categoria;
    }
}