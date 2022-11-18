package pokemon;
public abstract class Movimiento {
    //atributos
    private int tipo;
    private String descripcion;
    private int id;

    //constructor
    public Movimiento(int pTipo, String pDescripcion, int pId) {
        this.tipo = pTipo;
        this.descripcion = pDescripcion;
        this.id = pId;
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
