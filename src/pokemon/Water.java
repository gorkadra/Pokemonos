package pokemon;

public class Water extends Pokemon{

	
	//eraikitzailea
	public Water(String pMota, String pIzena, int pBizitza){
		super (pMota,pIzena,pBizitza);
	}
	
	public boolean indartsua (String pMota){
		boolean emaitza=false;
		if (pMota=="Fire"){
			emaitza=true;
		}
		return emaitza;	
	}
	
	public boolean ahula (String pMota){
		boolean emaitza=false;
		if (pMota=="Grass"){
			emaitza=true;
		}
		return emaitza;		
	}
	
	public boolean motaberdina (String pMota){
		boolean emaitza=false;
		if (pMota=="Water"){
			emaitza=true;
		}
		return emaitza;
	}
	
	public void gehituErasoa(Erasoa pErasoa){
		if(super.lista.getTamaina()<4){
			super.lista.gehituErasoak();
		}
	}
	
}
