package pokemon;

import java.util.ArrayList;

public class ListaJokalariak {

	//atributuak
	private ArrayList<Jokalaria> lista;
	private static ListaJokalariak nireListaJokalariak = null;
	
	//eraikitzailea
	private ListaJokalariak(){
		this.lista = new ArrayList<Jokalaria>();
	}
	
	//metodoak
	public static synchronized ListaJokalariak getListaJokalariak(){
		if(nireListaJokalariak == null){
			nireListaJokalariak = new ListaJokalariak();
		}
		return nireListaJokalariak;
	}
	
	//amaitu
	//private 
	
}
