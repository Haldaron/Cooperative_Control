package mundo;

import java.util.ArrayList;
import java.util.Iterator;

public class Malla {
	//--------------------------------------------------------------------------
	//Constantes
	//--------------------------------------------------------------------------

	public static final int N=10;

	public final static int CAR1 = 1;
	public final static int CAR2 = 2;
	public final static int CAR3 = 3;

	public final static int[] CARCODES={CAR1,CAR2,CAR3};

	private static final int CROP1 = 1;
	private static final int CROP2= 2;
	private static final int CROP3 = 3;
	private static final int CROP4= 4;

	public final static int[] CROPCODES={CROP1, CROP2,CROP3,CROP4};

	//--------------------------------------------------------------------------
	//Atributos
	//--------------------------------------------------------------------------


	/**
	 * TMalla de nodos sobre la que se calcularán los caminos a seguir por cada vehículo.<br>
	 */
	private Nodo[][] malla;

	/**
	 * Vector en el que se encuentran los carros que componen el sistema de recolección<br> 
	 */
	private ArrayList<Carro> carros;

	/**
	 * Vector con los huertos presentes en el terreno.<br>
	 */
	private ArrayList<Nodo> huertos;

	// TO-DO: Vector con las metas que pueden cambiar de manera dinámica

	private Grafo rGrafo;



	//--------------------------------------------------------------------------
	//Constructor
	//--------------------------------------------------------------------------

	/**
	 * Inicializador de la malla. <br>
	 * <b>post:</b> Inicializados los atributos de la clase <br>
	 * @param pX Posición en X del huerto <br>
	 * @param pY Posición en Y del huerto <br>
	 * @param pY Posición en Y del huerto <br>
	 */

	public Malla(int[][] inicialesCarros, Double[] angulosCarros, int[][] inicialesHuertos, int pY, int pTiempoRecoleccion, int pNumFrutos, int pCodigo) throws TamanosInvalidosInicializacionException
	{
		carros = new ArrayList<Carro>();
		huertos = new ArrayList<Nodo>();
		malla= new Nodo[N][N];

		inicializarCarros(inicialesCarros, angulosCarros);
		inicializarHuertos(inicialesHuertos);
		inicializarMalla();

		crearGrafo(malla);


	}


	//--------------------------------------------------------------------------
	//Métodos
	//--------------------------------------------------------------------------

	//Inicializadores

	/**
	 * Retorna el tiempo de recoleccion de los fruto en el huerto<br>
	 * <b>post: </b>se retornó el tiempo de recoleccion del los frutos del huerto. 
	 * Número mayor a cero<br>
	 * @return tiempo de recoleccion de los frutos.
	 */
	public void inicializarHuertos(int[][] iniciales)
	{
		huertos.set(0, new Huerto(iniciales[0][0],iniciales[0][1],iniciales[0][2],iniciales[0][3],CROPCODES[0]));
		huertos.set(0, new Huerto(iniciales[1][0],iniciales[1][1],iniciales[1][2],iniciales[1][3],CROPCODES[1]));
		huertos.set(0, new Huerto(iniciales[2][0],iniciales[2][1],iniciales[2][2],iniciales[2][3],CROPCODES[2]));
	}

	public void crearGrafo(Nodo[][] grid){

		rGrafo= new Grafo(grid);

	}

	public void inicializarCarros(int[][] inicialesC, Double[] angulos) throws TamanosInvalidosInicializacionException
	{	
		if(inicialesC[0].length==CARCODES.length 
				&& inicialesC[1].length==CARCODES.length 
				&& angulos.length==CARCODES.length)
		{
			for(int i =0; i<CARCODES.length;i++){
				carros.set(i, new Carro(CARCODES[i], inicialesC[0][i],inicialesC[1][i], angulos[i]));
			}		
		}else{
			throw new TamanosInvalidosInicializacionException();
		}
	}

	public void inicializarMalla()
	{
		Huerto huerto0=(Huerto) huertos.get(0);
		Huerto huerto1=(Huerto) huertos.get(1);
		Huerto huerto2=(Huerto) huertos.get(2);

		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				boolean h0 = (huerto0.getPosX()==j && huerto0.getPosY()==i);
				boolean h1 = (huerto1.getPosX()==j && huerto1.getPosY()==i);
				boolean h2 = (huerto2.getPosX()==j && huerto2.getPosY()==i);

				if(h0)
					malla[i][j] =huerto0 ;

				else if(h1)
					malla[i][j]=huerto1;

				else if(h2)
					malla[i][j]=huerto2;

				else
					malla[i][j]= new Nodo(j,i);
			}
		}
	}

	public void inicializarRutas(){
		for (Carro car :carros) 
		{
			asignarPosiblesCaminos(car, huertos);
			
		}
	}
	

	//Métodos de cálculo y optimización de caminos.	

	/**
	 * Calcula y retorna el bfs en una clase FindPath para el carro pasado por parámetro
	 * @param c
	 */
	public FindPath bfsCarroi(Carro c)
	{
		return new FindPath(rGrafo, c.getPosY()*N+c.getPosX());

	}

	/**
	 * Construye un camino para un Carro con buscador FindPath fp , y un nodo objetivo con código asociado codObjetivo pasado por
	 * parámetro.
	 * @param stackCamino LIFO en eal que se encuentran almacenados las posiciones consecutivas de los nodos de un camino 
	 * @param codObjetivo Codigo del nodo al cual se dirige el carro
	 * @return
	 */
	public Camino construirCamino(FindPath fp, int codObjetivo){
		Iterable<Integer> stackCamino= fp.caminoA(codObjetivo);
		Iterator<Integer> it= stackCamino.iterator();
		Camino cRta= new Camino(codObjetivo);

		int x=0;
		int y=0;
		int sig=0;
		Nodo aIngresar=null;
		while(it.hasNext())
		{
			sig=it.next();
			x=sig%N;
			y=(sig-x)/N;
			aIngresar=malla[x][y];
			cRta.anadirNodoAlfinal(aIngresar);

		}

		return cRta;
	}

	/**
	 * Asigna los posibles caminos a cada uno de los nodos objetivo(objs) al carro c paasado por parámetro
	 * @param c Carro c al cual se le calcularán los posibles caminos.
	 * @param objs ArrayList de objetivos con los nodos posibles a los cuales se puede dirigir el carro c
	 */
	public void asignarPosiblesCaminos(Carro c,ArrayList<Nodo> objs){
		FindPath fpActual= bfsCarroi(c);
		for(Nodo n : objs)
		{
			construirCamino(fpActual, n.getPosY()*N+n.getPosX());
		}
	}

	public void optimizarCaminos()

	{
		OptimizacionCaminos oc =new OptimizacionCaminos(carros.get(0).posiblesCaminos,carros.get(1).posiblesCaminos,carros.get(2).posiblesCaminos);	

		Integer[]	caminosAAsignar=oc.getIndexHuertosFinales();
		carros.get(0).setCaminoEnSeguimiento(carros.get(0).getPosiblesCaminos()[caminosAAsignar[0]]);
		carros.get(1).setCaminoEnSeguimiento(carros.get(1).getPosiblesCaminos()[caminosAAsignar[1]]);
		carros.get(2).setCaminoEnSeguimiento(carros.get(2).getPosiblesCaminos()[caminosAAsignar[2]]);
	}

}

