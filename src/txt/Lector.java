package txt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import pokemon.*;


public class Lector {

    public void leerTipos(){
        try{
            Scanner sc=new Scanner(new FileReader("src/txt/Tipos.txt"));

            int linea;
            int columna;
            float valor;

            while(sc.hasNext()){
                String lineatxt=sc.nextLine();
                String[] listadeLinea = lineatxt.split(",");
                if(listadeLinea.length==3){
                    linea = Integer.parseInt(listadeLinea[0]);
                    columna = Integer.parseInt(listadeLinea[1]);
                    valor = Float.parseFloat(listadeLinea[2]);
                    TablaTipos.getMiTablaTipos().setNum(linea,columna,valor);
                }
                else{
                    sc.nextLine();
                }
            }
        }catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el txt");

        }
    }

    public void leerPokemons(){
        try{
            Scanner sc=new Scanner(new FileReader("src/txt/Pokemons.txt"));
            String nombre;
            int id;
            float vida;
            float ataque;
            float velocidad;
            float defensa;
            int tipo;
            float ataquesp;
            float defensasp;
            while(sc.hasNext()){
                String linea=sc.nextLine();
                System.out.println(linea);
                String[] listadeLinea = linea.split(",");
                if(listadeLinea.length==9){
                    nombre = listadeLinea[0];
                    id = Integer.parseInt(listadeLinea[1]);
                    vida = (float) Integer.parseInt(listadeLinea[2]);
                    ataque = (float) Integer.parseInt(listadeLinea[3]);
                    velocidad = (float) Integer.parseInt(listadeLinea[4]);
                    defensa = (float) Integer.parseInt(listadeLinea[5]);
                    tipo = Integer.parseInt(listadeLinea[6]);
                    ataquesp = (float) Integer.parseInt(listadeLinea[7]);
                    defensasp = (float) Integer.parseInt(listadeLinea[8]);

                    Pokemon poke = new Pokemon(nombre,id,vida,ataque,velocidad,defensa,tipo,ataquesp,defensasp);
                    Pokedex.getMiPokedex().getMiLista().addPokemon(poke);
                }
                else{
                    sc.nextLine();
                }
            }
        }catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el txt");

        }
    }

    public void leerAtaques(){
        try{
            Scanner sc=new Scanner(new FileReader("src/txt/Ataques.txt"));
            int tipo;
            String descripcion;
            int id;
            String cat;
            boolean catBool;
            int potencia;
            float booster;
            String estadistica;
            String propio;
            boolean propioBool;
            while(sc.hasNext()){
                String linea=sc.nextLine();
                String[] listadeLinea = linea.split(",");

                if(listadeLinea.length==5){
                    tipo = Integer.parseInt(listadeLinea[0]);
                    descripcion = listadeLinea[1];
                    id = Integer.parseInt(listadeLinea[2]);
                    cat = listadeLinea[3];
                    if (cat=="true"){
                        catBool=true;
                    }
                    else{
                        catBool=false;
                    }
                    potencia = Integer.parseInt(listadeLinea[4]);
                    MovimientoAtaque movAtac = new MovimientoAtaque(tipo,descripcion,id,catBool,potencia);
                    ColeccionMovi.getMiListaMovi().getMiLista().addMovi(movAtac);
                }
                else if(listadeLinea.length==7){
                    tipo = Integer.parseInt(listadeLinea[0]);
                    descripcion = listadeLinea[1];
                    id = Integer.parseInt(listadeLinea[2]);
                    cat = listadeLinea[3];
                    if (cat=="true"){
                        catBool=true;
                    }
                    else{
                        catBool=false;
                    }
                    System.out.println(listadeLinea[4]);
                    booster = Float.parseFloat(listadeLinea[4]);
                    estadistica = listadeLinea[5];
                    propio =  listadeLinea[6];
                    if (propio=="true"){
                        propioBool=true;
                    }
                    else{
                        propioBool=false;
                    }
                    MovimientoStat movStat = new MovimientoStat(tipo,descripcion,id,catBool,booster,estadistica,propioBool);
                    ColeccionMovi.getMiListaMovi().getMiLista().addMovi(movStat);
                }
                else{
                    sc.nextLine();
                }
            }
        }catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el txt");

        }
    }
}
