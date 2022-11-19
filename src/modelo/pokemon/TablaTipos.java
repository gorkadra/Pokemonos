package modelo.pokemon;

public class TablaTipos {

    private static TablaTipos miTablaTipos;
    private float[][] tablaTipo;
    //eraikitzailea
    private TablaTipos() {
        tablaTipo = new float[8][8];
    }
    public static TablaTipos getMiTablaTipos() {
        if(miTablaTipos == null) {
            miTablaTipos = new TablaTipos();
        }
        return miTablaTipos;
    }
    //gainontzeko metodoak
    public void setNum(int linea,int columna,float valor) {
        TablaTipos.getMiTablaTipos().tablaTipo[linea][columna] = valor;
    }
    public float getNum(int p1,int p2) {
        return tablaTipo[p1][p2];
    }
    public float calcularEfectividad(int linea,int columna) {
        return TablaTipos.getMiTablaTipos().tablaTipo[linea][columna];
    }
    public void resetear() {
        for(int i = 0; i<=3;i++) {
            for(int a = 0; a<=3;a++) {
                tablaTipo[i][a]= 0;
            }
        }
    }

}
