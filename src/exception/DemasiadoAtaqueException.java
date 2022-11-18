package exception;

public class DemasiadoAtaqueException extends Throwable {

    public DemasiadoAtaqueException() {
        super();
    }
    //gainontzeko metodoak
    public void imprimirMensaje() {
        System.out.println("-----------------------------------------");
        System.out.println("El indice de ataque del pokemon ha subido en exceso");
        System.out.println("-----------------------------------------");
    }

}
