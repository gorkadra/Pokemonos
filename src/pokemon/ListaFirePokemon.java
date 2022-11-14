package pokemon;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.Random;

public class ListaFirePokemon extends ListaPokemon {

	//atributuak
	private Random aux= new Random (System.nanoTime());
	private ArrayList<Fire> listaFire;
	
	//eraikitzailea 
	public ListaFirePokemon(){
		super();
		this.listaFire = new ArrayList<Fire>();
	}
	
	//metodoak
	private Iterator<Fire> getIteradorea() {
		return this.listaFire.iterator();
	}
	
	public void gehitu (Fire pMota){
		this.listaFire.add(pMota);
	}
	
	public Fire aukeratuPokemon (){
		Iterator<Fire> itr = this.getIteradorea();
		int laguntzailea=aux.nextInt(4)+1;
		int soluzioa=0;
		Fire pokemon1=null;
		while (itr.hasNext() && soluzioa!=laguntzailea){
			pokemon1=itr.next();
			soluzioa=soluzioa+1;			
		}
		return pokemon1;
	}
	

}
