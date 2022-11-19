package modelo.pokemon;
public abstract class Movimiento {
    //atributos
    private int tipo;
    private String descripcion;
    private int id;
    private int precio;

    //constructor
    public Movimiento(int pTipo, String pDescripcion, int pId, int pPrecio) {
        this.tipo = pTipo;
        this.descripcion = pDescripcion;
        this.id = pId;
        this.precio = pPrecio;
    }
    //metodos
    public int getTipo() {
        return this.tipo;
    }

    public int getId() {
        return this.id;
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
