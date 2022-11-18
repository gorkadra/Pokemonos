package pokemon;

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
	
	System.out.println();
	
	System.out.println("Sartu Pokemonaren izena:");
	String deitura;
	deitura=lag.nextLine();
	
	System.out.println();
	
	System.out.println("Aukeratu zenbaki bat:");
	System.out.println("1) Fire");
	System.out.println("2) Water");
	System.out.println("3) Grass");
	
	
	int aukera;
	aukera=lag.nextInt();
	
	
	while (aukera!=1 && aukera!=2 && aukera!=3){
		System.out.println("Zuk sartu duzun balioa ez dago eskuragarri, sartu 1,2 edo 3 zenbakia:");
		aukera=lag.nextInt();
	}
		
	if (aukera==1){
		ListaFirePokemon pokemonlista=new ListaFirePokemon();
		Fire Charmander=new Fire("Fire", "Charmander", 1000);
		Fire Growlithe=new Fire("Fire", "Growlithe",850);
		Fire Charizard=new Fire("Fire", "Charizard", 1400);
		Fire Moltres=new Fire ("Fire", "Moltres",1200);		
		pokemonlista.gehitu(Growlithe);
		pokemonlista.gehitu(Charmander);
		pokemonlista.gehitu(Charizard);
		pokemonlista.gehitu(Moltres);
		Fire pokemonfire=pokemonlista.aukeratuPokemon();	
		String ema=pokemonfire.izena;
		int hp=pokemonfire.bizitza;
		pokemonfire.imprimatuosoa(deitura,ema,hp);
		jokalari1.gehituPokemon(pokemonfire);
	}	
		
	else if (aukera==2){
		ListaWaterPokemon waterlista=new ListaWaterPokemon();
		Water Squirtle=new Water ("Water", "Squirtle", 900);
		Water Totodile=new Water ("Water", "Totodile",950);
		Water Blastoise=new Water ("Water", "Blastoise",1300);
		Water Vaporeon=new Water ("Water", "Vaporeon", 1100);
		waterlista.gehitu(Vaporeon);
		waterlista.gehitu(Squirtle);
		waterlista.gehitu(Blastoise);
		waterlista.gehitu(Totodile);
		Water pokemonwater=waterlista.aukeratuPokemon();
		String sol=pokemonwater.izena;
		int hp=pokemonwater.bizitza;
		pokemonwater.imprimatuosoa(deitura,sol,hp);		
		jokalari1.gehituPokemon(pokemonwater);
	}
	
	else{ 
		ListaGrassPokemon grasslista=new ListaGrassPokemon();
		Grass Bulbasur=new Grass ("Grass", "Bulbasur", 900);
		Grass Victreebel=new Grass ("Grass", "Victreebel", 1100);
		Grass Ludicolo=new Grass ("Grass", "Ludicolo", 1250);
		Grass Sceptile=new Grass ("Grass", "Sceptile",1400);
		grasslista.gehitu(Victreebel);
		grasslista.gehitu(Bulbasur);
		grasslista.gehitu(Ludicolo);
		grasslista.gehitu(Sceptile);
		Grass pokemongrass=grasslista.aukeratuPokemon();
		String aux=pokemongrass.izena;
		int hp=pokemongrass.bizitza;
		pokemongrass.imprimatuosoa(deitura,aux,hp);
		jokalari1.gehituPokemon(pokemongrass);
	}
	
	System.out.println();

	String entrenatzaileak;
	System.out.println("Zure Aurkariaren izena:");
	entrenatzaileak=num.nextLine();
	Entrenatzailea jokalari2=new Entrenatzailea("Lurenux",0);
	jokalari2.imprimatuta(entrenatzaileak);
	
	System.out.println();
	
	System.out.println("Zure Aurkariaren Pokemon:");
	
	Random id= new Random (System.nanoTime());
	int zenbakia=id.nextInt(3)+1;
	
	if (zenbakia==1){
		ListaFirePokemon pokemonlista=new ListaFirePokemon();
		Fire Charmander=new Fire("Fire", "Charmander", 1000);
		Fire Growlithe=new Fire("Fire", "Growlithe",850);
		Fire Charizard=new Fire("Fire", "Charizard", 1400);
		Fire Moltres=new Fire ("Fire", "Moltres",1200);		
		pokemonlista.gehitu(Growlithe);
		pokemonlista.gehitu(Charmander);
		pokemonlista.gehitu(Charizard);
		pokemonlista.gehitu(Moltres);
		Fire pokemonfire=pokemonlista.aukeratuPokemon();	
		String ema=pokemonfire.izena;
		int hp=pokemonfire.bizitza;
		pokemonfire.imprimatu(ema,hp);
		jokalari2.gehituPokemon(pokemonfire);
	}	
		
	else if (zenbakia==2){
		ListaWaterPokemon waterlista=new ListaWaterPokemon();
		Water Squirtle=new Water ("Water", "Squirtle", 900);
		Water Totodile=new Water ("Water", "Totodile",950);
		Water Blastoise=new Water ("Water", "Blastoise",1300);
		Water Vaporeon=new Water ("Water", "Vaporeon", 1100);
		waterlista.gehitu(Vaporeon);
		waterlista.gehitu(Squirtle);
		waterlista.gehitu(Blastoise);
		waterlista.gehitu(Totodile);
		Water pokemonwater=waterlista.aukeratuPokemon();
		String sol=pokemonwater.izena;
		int hp=pokemonwater.bizitza;
		pokemonwater.imprimatu(sol,hp);
		jokalari2.gehituPokemon(pokemonwater);
	}
	
	else{ 
		ListaGrassPokemon grasslista=new ListaGrassPokemon();
		Grass Bulbasur=new Grass ("Grass", "Bulbasur", 900);
		Grass Victreebel=new Grass ("Grass", "Victreebel", 1100);
		Grass Ludicolo=new Grass ("Grass", "Ludicolo", 1250);
		Grass Sceptile=new Grass ("Grass", "Sceptile",1400);
		grasslista.gehitu(Victreebel);
		grasslista.gehitu(Bulbasur);
		grasslista.gehitu(Ludicolo);
		grasslista.gehitu(Sceptile);
		Grass pokemongrass=grasslista.aukeratuPokemon();
		String aux=pokemongrass.izena;
		int hp=pokemongrass.bizitza;
		pokemongrass.imprimatu(aux,hp);
		jokalari2.gehituPokemon(pokemongrass);
	}
	
	System.out.println();
	
	System.out.println("Jokoa hasi baino aurretik:");
	
	System.out.println();

		
		
		
	}

		
}
