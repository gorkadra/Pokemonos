package pokemon;

public class MovimientoStat extends Movimiento {
    //atributos
    private float booster;
    private String estadistica;
    private boolean propio;
    //constructor
    public MovimientoStat(int pTipo, String pDescripcion, int pId, int pPrecio,float pBooster, String pEstadistica,boolean pPropio) {
        super(pTipo,pDescripcion,pId, pPrecio);
        this.booster = pBooster;
        this.estadistica = pEstadistica;
        this.propio = pPropio;
    }
    //metodos
    public float getBooster() {
        return this.booster;
    }

    public String getEstadistica() {
        return this.estadistica;
    }
    public boolean getPropio() { //booster propio o rival
        return this.propio;
    }
}
