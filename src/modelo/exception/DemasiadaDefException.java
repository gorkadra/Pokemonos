package modelo.exception;

public class DemasiadaDefException extends Throwable {

    public DemasiadaDefException() {
        super();
    }
    //gainontzeko metodoak
    public void imprimirMensaje() {
        System.out.println("-----------------------------------------");
        System.out.println("El indice de defensa del model.pokemon ha subido en exceso");
        System.out.println("-----------------------------------------");
    }

}
