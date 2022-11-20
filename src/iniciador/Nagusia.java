package iniciador;

import controlador.LogginControl;
import modelo.pokemon.EntrenadorPropio;
import modelo.txt.Lector;
import vista.Loggin;

import java.util.Scanner;

public class Nagusia {
	public static void main (String[] args){



		//Vista
		Loggin log = new Loggin();
		//Modelo
		EntrenadorPropio yo = EntrenadorPropio.getEntrenadorPropio();
		//Controlador
		LogginControl lgc = new LogginControl(yo, log);
		log.setController(lgc);

		yo.addObserver(AJugar.getAJugar());
		
	}

		
}
