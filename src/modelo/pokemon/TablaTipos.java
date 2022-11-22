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
        tablaTipo[linea][columna] = valor;
    }
    public float getNum(int p1,int p2) {
        return tablaTipo[p1][p2];
    }
    public float calcularEfectividad(int ataque,int t1,int t2) {
        float total,efe1,efe2;
        efe1 = tablaTipo[ataque][t1];
        efe2 = tablaTipo[ataque][t2];
        total=efe1*efe2;
        return total;
    }
    public void resetear() {
        for(int i = 0; i<=3;i++) {
            for(int a = 0; a<=3;a++) {
                tablaTipo[i][a]= 0;
            }
        }
    }
    public void imprimirTabla(){
        for (int i = 0; i <8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(tablaTipo[i][j]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }

}
