package pokemon;
public abstract class Movimiento {
    //atributuak
    private int tipo;
    private String descripcion;
    private int id;
    private int precio;
    //eraikitzailea
    public Movimiento(int pTipo, String pDescripcion, int pId,int pPrecio) {
        this.tipo = pTipo;
        this.descripcion = pDescripcion;
        this.id = pId;
        this.precio = pPrecio;
    }
    //gainontzeko metodoak
    public int getTipo() {
        return this.tipo;
    }

    public int getId() {
        return this.id;
    }
    public int getPrecio() {
        return this.precio;
    }
    public String getDescripcion() {
        return this.descripcion;
    }

    public boolean idIgual(int pId) {
        boolean res = false;
        if(this.getId() == pId) {
            res = true;
        }
        return res;
    }

}
