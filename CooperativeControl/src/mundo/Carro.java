package mundo;

import java.util.ArrayList;
import java.util.Observable;


public class Carro extends Observable{

	private final static int CAPACIDAD=9;
	private final static int MOVING_TIME=1000;
	private final static int HARVEST_TIME=3000;

	private int codigo;
	private int posX;
	private int posY;
	private Camino caminoEnSeguimiento;
	private Camino[] posiblesCaminos;
	private double angulo;
	private double velocidad;
	private int carga;
	private boolean cargado;
	private ManejadorCarro manejadorCarro; 
	public boolean allowRun;



	public Carro(int cod, int posXinicial, int posYinicial, double angInicial){
		codigo=cod;
		posX=posXinicial;
		posY=posYinicial;
		caminoEnSeguimiento =null;
		posiblesCaminos=new Camino[4];
		angulo=angInicial;
		velocidad=0;
		carga=0;
		manejadorCarro=null;
		allowRun=false;
	}

	public void avanzarEnCamino(){

		if(caminoEnSeguimiento!=null)
		{
			Nodo firstNode=caminoEnSeguimiento.darPrimerNodo();

			if(firstNode!=null)
			{
				if(firstNode.getPosX()==posX && firstNode.getPosY()==posY)
				{
					caminoEnSeguimiento.eliminarPrimerNodoSecuencia();
					avanzarEnCamino();
				}else
				{
					actualizarPosicion(firstNode.getPosX(), firstNode.getPosY(), 0.0);
					caminoEnSeguimiento.eliminarPrimerNodoSecuencia();
				}
			}else
			{
				caminoEnSeguimiento.eliminarPrimerNodoSecuencia();
				System.out.println("No hay elementos bien dispuestos en la secuencia del camino a seguir");
			}

		}

	}


	public void actualizarPosicion(int x, int y , double angulo){


		setAngulo(angulo);
		setPosX(x);
		setPosY(y);
		setChanged();
		notifyObservers(codigo);

	}	

	///Getters And Setters

	/**
	 * @param i Posición del arreglo en el cual se insertará el Camino c
	 * @param c Camino a insertar en la posición i del arrglo.
	 */
	public void setCaminoI(int i , Camino c){
		posiblesCaminos[i]=c;
	}

	public boolean getCargado()
	{
		return cargado;
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * @return the camiloEnSeguimiento
	 */
	public Camino getCaminoEnSeguimiento() {
		return caminoEnSeguimiento;
	}

	/**
	 * @param camiloEnSeguimiento the camiloEnSeguimiento to set
	 */
	public void setCaminoEnSeguimiento(Camino caminoEnSeguimiento) {
		this.caminoEnSeguimiento = caminoEnSeguimiento;
	}

	/**
	 * @return the posiblesCaminos
	 */
	public Camino[] getPosiblesCaminos() {
		return posiblesCaminos;
	}

	/**
	 * @param posiblesCaminos the posiblesCaminos to set
	 */
	public void setPosiblesCaminos(Camino[] posiblesCaminos) {
		this.posiblesCaminos = posiblesCaminos;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}
	/**
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}
	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}
	/**
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}
	/**
	 * @return the angulo
	 */
	public double getAngulo() {
		return angulo;
	}
	/**
	 * @param angulo the angulo to set
	 */
	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}
	/**
	 * @return the velocidad
	 */
	public double getVelocidad() {
		return velocidad;
	}
	/**
	 * @param velocidad the velocidad to set
	 */
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	/**
	 * @return the carga
	 */
	public int getCarga() {
		return carga;
	}
	/**
	 * @param carga the carga to set
	 */
	public void setCarga(int carga) {
		if(!cargado)
		{
			this.carga = carga;
			if (carga==CAPACIDAD)
			{
				cargado=true;
			}
		}

	}
	
	public void iniciarMovimiento(){
		allowRun=true;
		manejadorCarro=new ManejadorCarro(this, MOVING_TIME, HARVEST_TIME);
	}
	
	public void detenerMovimiento(){
		allowRun=false;
	}




}
