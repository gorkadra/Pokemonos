package pokemon;

import txt.Lector;

import java.util.Random;
import java.util.Scanner;

public class Nagusia {
	public static void main (String[] args){
	
	Scanner lag=new Scanner(System.in);
	Scanner num=new Scanner(System.in);
	
	String izena;
	System.out.println("Sartu zure izena:");
	izena=lag.nextLine();
	Entrenatzailea jokalari1=new Entrenatzailea("JonBarHD",0);
	jokalari1.imprimatuta(izena);
	
	Lector elLector = new Lector();
	elLector.leerTipos();
	elLector.leerPokemons();
	elLector.leerAtaques();
	
	System.out.println();
	
	System.out.println("Jokoa hasi baino aurretik:");
	
	System.out.println();

		
		
		
	}

		
}
