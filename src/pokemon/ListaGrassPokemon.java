package pokemon;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.Random;

public class ListaGrassPokemon extends ListaPokemon {

	//atributuak
	private Random aux= new Random (System.nanoTime());
	private ArrayList<Grass> listaGrass;
	
	//eraikitzailea 
	public ListaGrassPokemon(){
		super();
		this.listaGrass = new ArrayList<Grass>();
	}
	
	//metodoak
	private Iterator<Grass> getIteradorea() {
		return this.listaGrass.iterator();
	}
	
	public void gehitu (Grass pMota){
		this.listaGrass.add(pMota);
	}
	
	public Grass aukeratuPokemon (){
		Iterator<Grass> itr = this.getIteradorea();
		int laguntzailea=aux.nextInt(4)+1;
		int soluzioa=0;
		Grass pokemon1=null;
		while (itr.hasNext() && soluzioa!=laguntzailea){
			pokemon1=itr.next();
			soluzioa=soluzioa+1;			
		}
		return pokemon1;
	}
	

}
