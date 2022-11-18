package exception;

public class DefensaBajaException extends Throwable {

    public DefensaBajaException() {
        super();
    }
    //gainontzeko metodoak
    public void imprimirMensaje() {
        System.out.println("-----------------------------------------");
        System.out.println("El indice de defensa del pokemon ha bajado en exceso");
        System.out.println("-----------------------------------------");
    }

}
