package mundo;

public class TamanosInvalidosInicializacionException extends Exception {
	
	
	public TamanosInvalidosInicializacionException(){
		super("El tamaño de los vectores de inicialización no coincide con el numero de elementos");
	}

}
