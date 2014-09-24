package mundo;


/**
 * Unidad constitutiva de la malla que representa el estado físico del 
 * sistema<br>
 */

public class Nodo {
	
	//--------------------------------------------------------------------------
	//Atributos
	//--------------------------------------------------------------------------
	
	
	/**
	 * Posición normalizada del nodo sobre el eje X de la malla. Corresponde a la
	 *  columna de la matriz en la que está ubicado el nodo.<br>
	 */
	private int posX;
	
	/**
	 * Posición normalizada del nodo sobre el eje Y de la malla. Corresponde a la
	 * fila de la matriz de nodos en la que está ubicado el nodo.<br>
	 */
	private int posY;
	
	/**
	 * Variable que determina si el nodo está o no está disponible para ser usado 
	 * en la planeación de una ruta.<br>
	 */
	private boolean enable;
	

	//--------------------------------------------------------------------------
	//Constructor
	//--------------------------------------------------------------------------
	
	/**
	 * Inicializador de los objetos pertenecientes a la clase Nodo. El atributo 
	 * enable se inicializa como true.<br>
	 * @param pX Posición en X del nodo <br>
     * @param pY Posición en Y del nodo <br>
	 */
	
	public Nodo(int pX, int pY)
	{
	
		posX=pX;
		posY=pY;
		
		enable=true;
	}
	
	
	//--------------------------------------------------------------------------
	//Métodos
	//--------------------------------------------------------------------------

		//Get
	
    /**
     * Retorna la posición en X del nodo<br>
     * <b>post: </b>Se retornó la posición del nodo en el eje X. Número mayor a cero<br>
     * @return Posición en X del nodo
     */
	public int getPosX()
	{
		return posX;
	}

	/**
     * Retorna la posición en Y del nodo<br>
     * <b>post: </b>Se retornó la posición del nodo en el eje Y. Número mayor a cero<br>
     * @return Posición en Y del nodo
     */
	public int getPosY()
	{
		return posY;
	}
	
	/**
     * Retorna la el valor del atributo enable: True si se es posible pasar por el nodo, <br>
     * False de lo contrario<br>
     * <b>post: </b>Se retornó el valor del atributo enable<br>
     * @return Atributo enable
     */
	public boolean getEnable()
	{
		return enable;
	}
	
		//Set
	
	/**
     * Establece el valor de la posición en X como el número ingresado por parámetro <br>
     * @param pX Posición en X del nodo <br>
     * <b>post: </b>Se cambió la posición en X por pX<br>
     */
	
	public void setPosX(int pX)
	{
		posX=pX;
	}

	/**
     * Establece el valor de la posición en Y como el número ingresado por parámetro <br>
     * @param pY Posición en Y del nodo <br>
     * <b>post: </b>Se cambió la posición en Y por pY<br>
     */
	public void setPosY(int pY)
	{
		posY=pY;
	}
	
	/**
     * Establece el valor de la variable  enable como valor lógico ingresado por parámetro <br>
     * @param pEnable Nuevo valor de la variable enable. True si el nodo estará disponible, 
     * False de lo contrario. <br>
     * <b>post: </b>Se cambió la disponibilidad del nodo<br>
     */
	public void setEnable(boolean pEnable)
	{
		enable=pEnable;
	}
}
