package pokemon;
public abstract class Movimiento {
    //atributos
    private int tipo;
    private String descripcion;
    private int id;
    private boolean categoria; //fisico (T) o especial(F)
    //constructor
    public Movimiento(int pTipo, String pDescripcion, int pId,boolean pCat) {
        this.tipo = pTipo;
        this.descripcion = pDescripcion;
        this.id = pId;
        this.categoria = pCat;
    }
    //metodos
    public int getTipo() {
        return this.tipo;
    }

    public int getId() {
        return this.id;
    }
    public boolean getCat() {
        return this.categoria;
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
