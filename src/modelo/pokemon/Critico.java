package modelo.pokemon;

import java.util.Random;

public class Critico {

	//atributuak
	private Random aux= new Random (System.nanoTime());
	
	//Eraikitzailea
	public Critico (){
	}
	
	//metodoak
	public int ataqueCritico(){
		
		return aux.nextInt(5)+1; //+1 egin dugu, gutxienez lvl->1 izateko//

	}
}
