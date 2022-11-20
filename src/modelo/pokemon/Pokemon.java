package modelo.pokemon;

import modelo.exception.*;

import java.util.Iterator;

public class Pokemon {
	//atributos
	private String nombre;
	private int id;
	private float vida;
	private float vidaMax;
	private float ataque;
	private float veloc;
	private ListaMovi listaMovi;
	private int[] tipo = new int[2];
	private float defensa;
	private float ataqueSp;
	private float defensaSp;
	//constructor
	public Pokemon(String pNombre,int pId,float pVida, float pAtaque, float pVeloc, float pDefensa,int pTipo, float pDefensaSp, float pAtaqueSp) {
		this.nombre = pNombre;
		this.id = pId;
		this.vida = pVida;
		this.ataque = pAtaque;
		this.veloc = pVeloc;
		this.defensa = pDefensa;
		this.tipo[0] = pTipo;
		this.ataqueSp = pAtaqueSp;
		this.defensaSp = pDefensaSp;
		this.listaMovi = new ListaMovi();
	}
	public Pokemon(String pNombre,int pId,float pVida, float pAtaque, float pVeloc, float pDefensa,int pTipo1,int pTipo2, float pDefensaSp, float pAtaqueSp) {
		this.nombre = pNombre;
		this.id = pId;
		this.vida = pVida;
		this.ataque = pAtaque;
		this.veloc = pVeloc;
		this.defensa = pDefensa;
		this.tipo[0] = pTipo1;
		this.tipo[1] = pTipo2;
		this.ataqueSp = pAtaqueSp;
		this.defensaSp = pDefensaSp;
		this.listaMovi = new ListaMovi();
	}
	//gett-er and sett-er
	public void setListaMovi(ListaMovi pListaMovi) {
		this.listaMovi = pListaMovi;
	}
	public void setAtaque(float booster) {
		Pokemon poke = Pokedex.getMiPokedex().getMiLista().buscarPokemonId(this.getId());
		try {
			this.ataque = this.ataque*booster;
			if(booster < 1.0) {
				if(this.ataque < 0.5*poke.getAtaque()) {
					throw new AtaqueBajoException();
				}
			}
			else {
				if(this.ataque > 2*poke.getAtaque()) {
					throw new DemasiadoAtaqueException();
				}
			}
		}catch(DemasiadoAtaqueException e) {
			e.imprimirMensaje();
			this.ataque = 2*poke.getAtaque();
		}catch(AtaqueBajoException e) {
			e.imprimirMensaje();
			this.ataque = (float) (0.5*poke.getAtaque());
		}
	}
	public void setDefensa(float booster) {
		Pokemon poke = Pokedex.getMiPokedex().getMiLista().buscarPokemonId(this.getId());
		try {
			this.defensa = this.defensa*booster;
			if(booster < 1.0) {
				if(this.defensa < 0.5*poke.getDefensa()) {
					throw new DefensaBajaException();
				}
			}
			else {
				if(this.defensa > 2*poke.getDefensa()) {
					throw new DemasiadaDefException();
				}
			}
		}catch(DemasiadaDefException e) {
			e.imprimirMensaje();
			this.defensa = 2*poke.getDefensa();
		}catch(DefensaBajaException e) {
			e.imprimirMensaje();
			this.defensa = (float) (0.5*poke.getDefensa());
		}
	}

	public void setDefensaSp(float booster) {
		Pokemon poke = Pokedex.getMiPokedex().getMiLista().buscarPokemonId(this.getId());
		try {
			this.defensaSp = this.defensaSp*booster;
			if(booster < 1.0) {
				if(this.defensaSp < 0.5*poke.getDefensaSp()) {
					throw new DefensaBajaException();
				}
			}
			else {
				if(this.defensaSp > 2*poke.getDefensaSp()) {
					throw new DemasiadaDefException();
				}

			}
		}catch(DemasiadaDefException e) {
			e.imprimirMensaje();
			this.defensaSp = 2*poke.getDefensaSp();
		}catch(DefensaBajaException e) {
			e.imprimirMensaje();
			this.defensaSp = (float) (0.5*poke.getDefensaSp());
		}
	}

	public void setAtaqueSp(float booster) {
		Pokemon poke = Pokedex.getMiPokedex().getMiLista().buscarPokemonId(this.getId());
		try {
			this.ataqueSp = this.ataqueSp*booster;
			if(booster < 1.0) {
				if(this.ataqueSp < 0.5*poke.getAtaqueSp()) {
					throw new AtaqueBajoException();
				}
			}
			else {
				if(this.ataqueSp > 2*poke.getAtaqueSp()) {
					throw new DemasiadoAtaqueException();
				}
			}
		}catch(DemasiadoAtaqueException e) {
			e.imprimirMensaje();
			this.ataqueSp = 2*poke.getAtaqueSp();
		}catch(AtaqueBajoException e) {
			e.imprimirMensaje();
			this.ataqueSp = (float) (0.5*poke.getAtaqueSp());
		}
	}
	public String devuelveTipo(int pNum) {
		String res = "";
		if(pNum==0) {
			res = "fuego";
		}
		if(pNum==1) {
			res = "agua";
		}
		if(pNum==2) {
			res = "planta";
		}
		if(pNum==3) {
			res = "normal";
		}
		if(pNum==4) {
			res = "fantasma";
		}
		if (pNum==5){
			res = "hielo";
		}
		if (pNum==6){
			res = "lucha";
		}
		if (pNum==7){
			res = "tierra";
		}
		return res;
	}
	public void setVeloc(float booster) {
		Pokemon poke = Pokedex.getMiPokedex().getMiLista().buscarPokemonId(this.getId());
		try {
			this.veloc = this.veloc*booster;
			if(booster < 1.0) {
				if(this.veloc < 0.5*poke.getVeloc()) {
					throw new BajaVelException();
				}
			}
			else {
				if(this.veloc > 2*poke.getVeloc()) {
					throw new DemasiadaVelException();
				}
			}
		}catch(DemasiadaVelException e) {
			e.imprimirMensaje();
			this.veloc = 2*poke.getVeloc();
		}catch(BajaVelException e) {
			e.imprimirMensaje();
			this.veloc = (float) (0.5*poke.getVeloc());
		}
	}
	public void setVidaMax(float pBizitza) {
		this.vidaMax=pBizitza;
	}
	public void setVida(float booster) {
		Pokemon poke = Pokedex.getMiPokedex().getMiLista().buscarPokemonId(this.getId());
		try {
			this.vida = this.vida*booster;
			if(this.vida > poke.getVidaMax()) {
				throw new DemasiadaVidaException();
			}
		}catch(DemasiadaVidaException e) {
			e.imprimirMensaje();
			this.vida = poke.getVida();
		}
	}
	public void RecuperarVida(float pVida) {
		this.vida=pVida;
	}
	public void atacar(float pPotencia,float pEficiencia,float pAtaque,float pDefensa,float pMoviyPokeMismoTipo) {
		this.vida = (float) (this.vida - (pMoviyPokeMismoTipo*pEficiencia*(((21.0*pPotencia*pAtaque)/(25.0*pDefensa))+2.0)));
	}
	public float getVida() {
		return this.vida;
	}
	public float getVidaMax() {
		return this.vidaMax;
	}
	public float getVeloc() {
		return this.veloc;
	}
	public int getId() {
		return this.id;
	}
	public String getNombre() {
		return this.nombre;
	}
	public float getAtaque() {
		return this.ataque;
	}
	public float getDefensa() {
		return this.defensa;
	}
	public int[] getTipo() {
		return this.tipo;
	}
	public ListaMovi getMiLista() {
		return this.listaMovi;
	}
	public float getDefensaSp() {return this.defensaSp;}
	public float getAtaqueSp() {return this.ataqueSp;}
	//resto de metodos
	public Movimiento usarMovi(Integer num) {
		int i = 1;
		Movimiento res = null;
		boolean enc = false;
		Iterator<Movimiento> itr = this.listaMovi.getIterador();
		while(i <= 4 && !enc){
			Movimiento movi = itr.next();
			if(i==num) {
				enc = true;
				res = movi;
			}
			i = i + 1;
		}
		return res;
	}

	/*public void asignarMovim() {
		if(this.getMiLista().listaLongi()==0) { //para que no le ponga mas de 4 ataques a cada model.pokemon
			int[] listaNum = new int[4];
			boolean hay = false;
			int i = 1;
			int loop = 0;
			Movimiento movim = null;
			boolean primerMoviAtaque = false;//aseguramos minimo un movimientoataque
			while(i<=4) {
				int numRandom = (int) (Math.random()*ColeccionMovi.getMiListaMovi().listaLongi());
				while(loop <= 3 && !hay) {
					if(listaNum[loop]==numRandom) {
						hay = true;
					}
					loop = loop + 1;
				}
				if(!hay) {
					movim = ColeccionMovi.getMiListaMovi().aplicarMovi(numRandom);//aleatorioki erabakitako mugimendua bariable batean gordetzeko
					if(!primerMoviAtaque) {//gutxienez eraso bat eraso mugimenduarena izateko
						if(movim instanceof MovimientoAtaque && this.getTipo()[0]==movim.getTipo()) {
							this.listaMovi.addMovi(movim); // uneko pokemonari bere lista mugimenduan gordetzeko
						}
						else {
							if(this.getTipo()[0]==1 || this.getTipo()[1]==1) {
								numRandom = (int) Math.floor(Math.random()*(14-8+1)+8);
								movim = ColeccionMovi.getMiListaMovi().aplicarMovi(numRandom);
								this.listaMovi.addMovi(movim);
							}
							else if(this.getTipo()[0]==2 || this.getTipo()[1]==2) {
								numRandom = (int) Math.floor(Math.random()*(7-1+1)+1);
								movim = ColeccionMovi.getMiListaMovi().aplicarMovi(numRandom);
								this.listaMovi.addMovi(movim);
							}
							else if(this.getTipo()[0]==3 || this.getTipo()[1]==3) {
								numRandom = (int) Math.floor(Math.random()*(21-15+1)+15);
								movim = ColeccionMovi.getMiListaMovi().aplicarMovi(numRandom);
								this.listaMovi.addMovi(movim);
							}
							else if(this.getTipo()[0]==4 || this.getTipo()[1]==4) {
								numRandom = (int) Math.floor(Math.random()*(28-22+1)+22);
								movim = ColeccionMovi.getMiListaMovi().aplicarMovi(numRandom);
								this.listaMovi.addMovi(movim);
							}
							else {
								numRandom = (int) Math.floor(Math.random()*(35-29+1)+29);
								movim = ColeccionMovi.getMiListaMovi().aplicarMovi(numRandom);
								this.listaMovi.addMovi(movim);
							}
						}
						primerMoviAtaque = true;
						i = i + 1;
					}
					else {
						this.listaMovi.addMovi(movim);
						i = i + 1;
					}
					listaNum[i-2]=numRandom;
				}
				else {
					hay = false;
				}
				loop = 0;
			}
		}
	}*/

	public void asignarMovim(){
		if(this.getMiLista().listaLongi()==0) { //para que no le ponga mas de 4 ataques a cada model.pokemon
			int[] listaNum = new int[4];
			boolean hay = false;
			int i = 0;
			int loop = 0;
			Movimiento movim = null;
			boolean primerMoviAtaque = false;//aseguramos minimo un movimientoataque
			while(i<=3) {
				int numRandom = (int) (Math.random()*ColeccionMovi.getMiListaMovi().listaLongi());
				//comprobamos si el movimiento está ya metido
				while(loop <= 3 && !hay) {
					if(listaNum[loop]==numRandom) {
						hay = true;
					}
					loop = loop + 1;
				}
				//Si no está metido lo metemos
				if(!hay) {
					movim = ColeccionMovi.getMiListaMovi().aplicarMovi(numRandom);

					//aleatorioki erabakitako mugimendua bariable batean gordetzeko
					if(!primerMoviAtaque) {//gutxienez eraso bat eraso mugimenduarena izateko
						if(movim instanceof MovimientoAtaque && this.getTipo()[0]==movim.getTipo()) {
							this.listaMovi.addMovi(movim);
						}
						primerMoviAtaque = true;
						i = i + 1;
						listaNum[i-1]=numRandom;
					}
					else {
						this.listaMovi.addMovi(movim);
						i = i + 1;
						listaNum[i-1]=numRandom;
					}

				}
				//Preparamos la siguiente vuelta
				hay = false;
				loop = 0;
			}
		}
	}

	public boolean mismoId(int pId) {
		boolean res = false;
		if(this.getId() == pId) {
			res = true;
		}
		return res;
	}
	public void imprimirMovi() {
		Iterator<Movimiento>	itr = this.listaMovi.getIterador();
		while(itr.hasNext()) {
			Movimiento mom = itr.next();
			if(mom instanceof MovimientoStat) {
				System.out.println(((MovimientoStat)mom).getDescripcion());
				System.out.println(((MovimientoStat)mom).getBooster());
				System.out.println(((MovimientoStat)mom).getEstadistica());
			}
			else {
				System.out.println(((MovimientoAtaque)mom).getDescripcion());
				System.out.println(((MovimientoAtaque)mom).getPotencia());
			}
		}
	}
	public void printBarra() {
		float largo = 20*(this.vida/this.vidaMax);
		int cont=0;
		while (cont<largo) {
			System.out.print("#");
			cont++;
		}
		while (cont<20) {
			System.out.print("·");
			cont++;
		}
	}
}