package pokemon;

import exception.EntradaErroneaException;

import java.util.Scanner;



public class Teclado {
    //atributuak
    private Scanner sc;
    private static Teclado miTeclado=null;


    //constructor
    private Teclado() {
        this.sc=new Scanner(System.in);
    }

    //metodos
    public static Teclado getMiTeclado() {
        if (miTeclado==null) {
            miTeclado=new Teclado();
        }
        return miTeclado;
    }

    public int leerEntero() {
        String num=this.leerString();
        boolean adec=false;
        do {
            if (num.isEmpty()) {
                num=this.leerString();
            }
            else {
                try {
                    Integer numero = Integer.parseInt(num);
                    if(numero > 4) {
                        throw new NumberFormatException();
                    }
                    adec=true;
                }
                catch (NumberFormatException e) {
                    System.out.println("Solo número enteros entre 1 y 4");
                    num=this.leerString();
                }
            }
        } while (!adec);
        return Integer.parseInt(num);
    }

    public String leerString() {
        String msj=this.sc.nextLine();
        return msj;
    }

    public void leerEnter() {
        System.out.println("Presiona enter para continuar");
        this.sc.nextLine();
    }
    public int leerEleccion(int pDesde, int pHasta) {
        boolean todoOk=false;
        int res=(pDesde-1);
        do {
            String str=sc.nextLine();
            try {
                res=Integer.parseInt(str);
                if(res<pDesde||res>pHasta) {
                    throw new EntradaErroneaException();
                }
                todoOk=true;
            }
            catch(NumberFormatException e) {
                System.out.println("Sarrera zenbaki bat izan behar da");
            }
            catch(EntradaErroneaException e) {
                e.imprimirMsj();
            }
        }while(!todoOk);
        return res;
    }
}
