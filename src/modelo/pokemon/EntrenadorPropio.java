package modelo.pokemon;

public class EntrenadorPropio extends Entrenador{
    //atributos

    //constructor
    public EntrenadorPropio(String pNombre, int pDinero) {
        super(pNombre, pDinero);
    }
    //metodos
    @Override
    public Movimiento usarMovi(Pokemon pPoke) {
        Integer num = Teclado.getMiTeclado().leerEntero();
        Movimiento usar = pPoke.usarMovi(num);
        return usar;
    }
}
