package pokemon;

import java.util.Random;

public abstract class Pokemon {

	//atributuak
	protected String izena;
	protected int bizitza;
	protected int lvl;
	protected ListaErasoak lista;
	
	private Random aux= new Random (System.nanoTime());
	
	//eraikitzailea
	public Pokemon (String pMota, String pIzena, int pBizitza){
		
		lvl=aux.nextInt(5)+1; //+1 egin dugu, gutxienez lvl->1 izateko//
		
		this.izena=pIzena;
		this.bizitza=pBizitza;
	}
	
	public void imprimatuosoa (String pIzena, String pPokemon, int pBizitza){
		System.out.println("Izena: "+pIzena+"   Pokemon: "+pPokemon+ "Level: "+lvl+"   Bizitza: "+pBizitza);
	}
	
	public void imprimatu (String pPokemon, int pBizitza){
		System.out.println("Pokemon: "+pPokemon+" Level: "+lvl+"   Bizitza: "+pBizitza);
	}
	
	public abstract void gehituErasoa(Erasoa pErasoa);
}
