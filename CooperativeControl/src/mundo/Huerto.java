package mundo;

import java.util.Observable;


/**
 * Clase que modela las huertas <br>
 */

public class Huerto extends Observable{

	//--------------------------------------------------------------------------
	//Atributos
	//--------------------------------------------------------------------------
	
	
	public final static int EN_RECOLECCION=2;
	public final static int DISPONIBLE=1;
	public final static int VACIO=0;
	public final static int ERROR=-1;
	public final static int NODOS_POR_HUERTO=2;
	
	/**
	 * Tiempo que tarda el vehículo en recoger cada fruto del huerto.<br>
	 */
	private int tiempoRecoleccion;
	
	/**
	 * Número de frutos disponibles en el huerto. Número mayor o igual a cero<br> 
	 */
	private int numFrutos;
	
	/**
	 * Identificador del huerto.<br>
	 */
	private int codigo;
	
	
	private int estado;
	

	
	
	//--------------------------------------------------------------------------
	//Constructor
	//--------------------------------------------------------------------------
	
	/**
	 * Inicializador de los objetos pertenecientes a la clase huerto. Se utiliza 
	 * el constructor de la clase Nodo para inicializar la posición del huerto y
	 * su disponibilidad<br>
	 * <b>post:</b> Inicializados los atributos de la clase <br>
	 * @param pX Posición en X del huerto <br>
     * @param pY Posición en Y del huerto <br>
     * @param pTiempoRecoleccion Tiempo que se tarda en recoger un fruto del puerto <br>
     * @param pNumFrutos Número de frutos disponibles en el huerto <br>
     * @param pCodigo Identificador del huerto <br>
	 */
	
	public Huerto(int pCodigo, int pTiempoRecoleccion, int pNumFrutos)
	{
		
		tiempoRecoleccion=pTiempoRecoleccion;
		numFrutos=pNumFrutos;
		codigo=pCodigo;
		estado=DISPONIBLE;
	}
	
	
	//--------------------------------------------------------------------------
	//Métodos
	//--------------------------------------------------------------------------

		//Get
	

	/**
     * Retorna el tiempo de recoleccion de los fruto en el huerto<br>
     * <b>post: </b>se retornó el tiempo de recoleccion del los frutos del huerto. 
     * Número mayor a cero<br>
     * @return tiempo de recoleccion de los frutos.
     */
	public int getTiempoRecoleccion()
	{
		return tiempoRecoleccion;
	}

	/**
     * Retorna el numero de frutos disponibles en el huerto<br>
     * <b>post: </b>Se retornó en número de frutos disponibles en el huerto. 
     * Número mayor o igual a cero<br>
     * @return número de frutos en el huerto
     */
	public int getNumFrutos()
	{
		return numFrutos;
	}
	
	/**
     * Retorna el código que identifica al huerto.<br>
     * <b>post: </b>Se retornó el código identificador del huerto.<br>
     * @return codigo del huerto.
     */
	public int getCodigo()
	{
		return codigo;
	}
	
		//Set
	
	/**
     * Establece el valor del tiempo de recoleccion como el número ingresado por parámetro <br>
     * @param pTiempoRecoleccion Tiempo que debe demorarseun el vehículo recogiendo un fruto <br>
     * <b>post: </b>Se cambió el tiempo de recolección<br>
     */
	public void setTiempoRecoleccion(int pTiempoRecoleccion)
	{
		tiempoRecoleccion=pTiempoRecoleccion;
	}

	
	/**
     * Establece el número de frutos dsponibles de acuerdo al valor ingresado por parámetro. Si
     * despues de la operación, el número de frutos es igual a cero, se deshabilita el nodo.<br>
     * @param pNumFrutos Número de frutos disponibles en el huerto. pNumFrutos => 0 <br>
     * <b>post: </b>Se cambió el número de frutos disponibles.Si numeró de frutos es cero, se 
     * cambió la disponibilidad del nodo<br>
     */
	public void setNumFrutos(int pNumFrutos)
	{
		numFrutos=pNumFrutos;
		if(numFrutos==0){
			setEstado(VACIO);
		}
	}
	
	/**
     *  Disminuye en uno el número de frutos disponibles. Si despues de la operación, el número 
     *  de frutos es igual a cero, se deshabilita el nodo.<br>
     * <b>post: </b>Se cambió el número de frutos disponibles.Si numeró de frutos es cero, se 
     * cambió la disponibilidad del nodo<br>
     */
	
	public int decrementarFrutos()
	{
		numFrutos--;
		setChanged();
		notifyObservers(codigo);
		return numFrutos;

	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int b) {
		estado=b;
	}


}
