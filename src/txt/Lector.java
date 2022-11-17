package txt;

import java.io.FileReader;
import java.util.Scanner;

public class Lector {

    public void leerTipos(){
        try{
            Scanner sc=new Scanner(new FileReader("src/txt/Tipos.txt"));

            while(sc.hasNext()){

                if(mailaSt.equals(sc.nextLine())){
                    aurkituta=true;
                }

            }

            //tableroa kargatu
            int err=0;
            while(err<9){
                String linea=sc.nextLine();
                int zut=0;
                while(zut<9){
                    char c=linea.charAt(zut);
                    String str=String.valueOf(c);
                    sudoku[err][zut]=Integer.parseInt(str);
                    sudokuStart[err][zut]=Integer.parseInt(str);
                    zut++;
                }
                err++;
            }


            //tablero emaitza kargatu
            int err_2=0;
            while(err_2<9){
                String linea=sc.nextLine();
                int zut_2=0;
                while(zut_2<9){
                    char c=linea.charAt(zut_2);
                    String str=String.valueOf(c);
                    sudokuEma[err_2][zut_2]=Integer.parseInt(str);
                    zut_2++;
                }
                err_2++;
            }


        }catch (FileNotFoundException e) {
            System.out.println("Ez da aurkitu fitxategia");

        }
    }

    public void leerPokemons(){
        try{
            Scanner sc=new Scanner(new FileReader("src/txt/Pokemons.txt"));


            while(sc.hasNext()){

                if(mailaSt.equals(sc.nextLine())){
                    aurkituta=true;
                }

            }

            //tableroa kargatu
            int err=0;
            while(err<9){
                String linea=sc.nextLine();
                int zut=0;
                while(zut<9){
                    char c=linea.charAt(zut);
                    String str=String.valueOf(c);
                    sudoku[err][zut]=Integer.parseInt(str);
                    sudokuStart[err][zut]=Integer.parseInt(str);
                    zut++;
                }
                err++;
            }


            //tablero emaitza kargatu
            int err_2=0;
            while(err_2<9){
                String linea=sc.nextLine();
                int zut_2=0;
                while(zut_2<9){
                    char c=linea.charAt(zut_2);
                    String str=String.valueOf(c);
                    sudokuEma[err_2][zut_2]=Integer.parseInt(str);
                    zut_2++;
                }
                err_2++;
            }


        }catch (FileNotFoundException e) {
            System.out.println("Ez da aurkitu fitxategia");

        }
    }

    public void leerAtaques(){
        try{
            Scanner sc=new Scanner(new FileReader("src/txt/Ataques.txt"));

            while(sc.hasNext()){
                String linea=sc.nextLine();
                String[] listadeLinea = linea.split(",");
                int i;
                String palabra;
                for ( i=0, i++, i<listadeLinea.length){
                    palabra = listadeLinea[i];
                }

            }

            //tableroa kargatu
            int err=0;
            while(err<9){
                String linea=sc.nextLine();
                String[] listadeLinea = linea.split(",");
                int zut=0;
                while(zut<9){
                    char c=linea.charAt(zut);
                    String str=String.valueOf(c);
                    sudoku[err][zut]=Integer.parseInt(str);
                    sudokuStart[err][zut]=Integer.parseInt(str);
                    zut++;
                }
                err++;
            }


            //tablero emaitza kargatu
            int err_2=0;
            while(err_2<9){
                String linea=sc.nextLine();
                int zut_2=0;
                while(zut_2<9){
                    char c=linea.charAt(zut_2);
                    String str=String.valueOf(c);
                    sudokuEma[err_2][zut_2]=Integer.parseInt(str);
                    zut_2++;
                }
                err_2++;
            }


        }catch (FileNotFoundException e) {
            System.out.println("Ez da aurkitu fitxategia");

        }
    }
}
