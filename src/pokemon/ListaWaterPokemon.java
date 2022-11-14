package pokemon;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.Random;

public class ListaWaterPokemon extends ListaPokemon {

	//atributuak
	private Random aux= new Random (System.nanoTime());
	private ArrayList<Water> listaWater;
	
	//eraikitzailea 
	public ListaWaterPokemon(){
		super();
		this.listaWater = new ArrayList<Water>();
	}
	
	//metodoak
	private Iterator<Water> getIteradorea() {
		return this.listaWater.iterator();
	}
	
	public void gehitu (Water pMota){
		this.listaWater.add(pMota);
	}
	
	public Water aukeratuPokemon (){
		Iterator<Water> itr = this.getIteradorea();
		int laguntzailea=aux.nextInt(4)+1;
		int soluzioa=0;
		Water pokemon1=null;
		while (itr.hasNext() && soluzioa!=laguntzailea){
			pokemon1=itr.next();
			soluzioa=soluzioa+1;			
		}
		return pokemon1;
	}
	

}
