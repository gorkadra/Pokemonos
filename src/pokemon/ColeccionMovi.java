package pokemon;

public class ColeccionMovi {
    //atributos
    private static ColeccionMovi nColeccionMovi = null;
    private ListaMovi listaMovi;
    //constructor
    private ColeccionMovi() {
        this.listaMovi = new ListaMovi();
    }

    public static ColeccionMovi getMiListaMovi() {
        if(nColeccionMovi == null) {
            nColeccionMovi = new ColeccionMovi();
        }
        return nColeccionMovi;

    }
    //metodos
    public ListaMovi getMiLista() {
        return this.listaMovi;
    }
    public int listaLongi() {
        return listaMovi.listaLongi();
    }
    public Movimiento aplicarMovi(int moviId) {
        return listaMovi.buscarPorId(moviId);
    }
}
