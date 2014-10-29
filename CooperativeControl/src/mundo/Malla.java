package mundo;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class Malla  {
	//--------------------------------------------------------------------------
	//Constantes
	//--------------------------------------------------------------------------

	public static final int N=10;

	public final static int CROP_NUMBER=2;

	private final static int CAR1 = 1;
	private final static int CAR2 = 2;
	private final static int CAR3 = 3;

	private final static int[] CARCODES={CAR1,CAR2,CAR3};

	private final static String DEST1="H1";
	private final static String DEST2="H2";
	private final static String DEST3="Bodega"; 
	private final static String[] DESTINOS={DEST1,DEST2,DEST3};

	private final static int HARVEST_TIME=30;
	public final static int FRUIT_NUMBER=9;




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

	private ArrayList<Nodo> destinos;

	// TO-DO: Vector con las metas que pueden cambiar de manera dinámica

	private Grafo rGrafo;

	private Observer panelVisualizacion;
	private Observer panelCarros;
	private Observer panelHuertos;






	//--------------------------------------------------------------------------
	//Constructor
	//--------------------------------------------------------------------------

	/**
	 * Inicializador de la malla. <br>
	 * <b>post:</b> Inicializados los atributos de la clase <br>
	 * @param observer 
	 * @param pX Posición en X del huerto <br>
	 * @param pY Posición en Y del huerto <br>
	 * @param pY Posición en Y del huerto <br>
	 */

	public Malla(int[][] inicialesCarros, Double[] angulosCarros, int[][] inicialesHuertos, Observer panObserver, Observer panCarros, Observer panHuertos) throws TamanosInvalidosInicializacionException
	{
		carros = new ArrayList<Carro>();
		huertos = new ArrayList<Nodo>();
		malla= new Nodo[N][N];
		panelVisualizacion=panObserver;
		panelCarros=panCarros;
		panelHuertos=panHuertos;
		destinos=huertos;
		inicializarHuertos(inicialesHuertos);
		inicializarMalla();
		crearGrafo(malla);
		inicializarCarros(inicialesCarros, angulosCarros);

		asignarRutas();
		optimizarCaminos();
		int i =0;
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
	 * @throws TamanosInvalidosInicializacionException 
	 */
	public void inicializarHuertos(int[][] iniciales) throws TamanosInvalidosInicializacionException
	{
		Huerto hAsignar=null;
		Nodo enCreacion=null;

		if(iniciales[0].length==CROP_NUMBER*Huerto.NODOS_POR_HUERTO
				&& iniciales[1].length==CROP_NUMBER*Huerto.NODOS_POR_HUERTO )
		{
			for(int i =0; i<CROP_NUMBER*Huerto.NODOS_POR_HUERTO;i++)
			{
				if(i%Huerto.NODOS_POR_HUERTO==0){
					hAsignar=new Huerto(i/2,HARVEST_TIME, FRUIT_NUMBER);
				}
				enCreacion=new Nodo(iniciales[0][i],iniciales[1][i]);
				enCreacion.asignarCultivo(hAsignar);
				huertos.add(enCreacion);
			}		
		}else
		{
			throw new TamanosInvalidosInicializacionException();
		}
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
			Nodo aInitialNode;
			for(int i =0; i<CARCODES.length;i++)
			{
				aInitialNode=malla[inicialesC[1][i]][inicialesC[0][i]];
				carros.add( new Carro(CARCODES[i], aInitialNode, angulos[i]));
			}		
		}else
		{
			throw new TamanosInvalidosInicializacionException();
		}
	}

	public void inicializarMalla()
	{
		Nodo huerto0= huertos.get(0);
		Nodo huerto1= huertos.get(1);
		Nodo huerto2= huertos.get(2);
		Nodo huerto3= huertos.get(3);

		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				boolean h0 = (huerto0.getPosX()==j && huerto0.getPosY()==i);
				boolean h1 = (huerto1.getPosX()==j && huerto1.getPosY()==i);
				boolean h2 = (huerto2.getPosX()==j && huerto2.getPosY()==i);
				boolean h3 = (huerto3.getPosX()==j && huerto3.getPosY()==i);
				if(h0)
					malla[i][j] =huerto0 ;
				else if(h1)
					malla[i][j]=huerto1;
				else if(h2)
					malla[i][j]=huerto2;
				else if(h3)
					malla[i][j]=huerto3;
				else
					malla[i][j]= new Nodo(j,i);
			}
		}
	}

	public void asignarRutas(){
		for (Carro car :carros) 
		{
			asignarPosiblesCaminos(car);

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
	public Camino construirCamino(FindPath fp, int codObjetivo)
	{
		Camino cRta=null;

		if(fp.hayCamino(codObjetivo)){

			Iterable<Integer> stackCamino= fp.caminoA(codObjetivo);
			Iterator<Integer> it= stackCamino.iterator();

			cRta= new Camino(codObjetivo);

			int x=0;
			int y=0;
			int sig=0;
			Nodo aIngresar=null;
			while(it.hasNext())
			{
				sig=it.next();
				x=sig%N;
				y=(sig-x)/N;
				aIngresar=malla[y][x];
				cRta.anadirNodoAlInicio(aIngresar);

			}

		}else{
			System.out.println("No hay Camino al objetivo con cod:"+codObjetivo);
		}
		return cRta;
	}

	/**
	 * Asigna los posibles caminos a cada uno de los nodos objetivo(objs) al carro c paasado por parámetro
	 * @param c Carro c al cual se le calcularán los posibles caminos.
	 * @param objs ArrayList de objetivos con los nodos posibles a los cuales se puede dirigir el carro c
	 */
	public void asignarPosiblesCaminos(Carro c){
		FindPath fpActual= bfsCarroi(c);
		int i; 
		Nodo n;
		Camino currentPath;
		for(i=0; i<destinos.size(); i++)
		{
			n=destinos.get(i);
			currentPath=construirCamino(fpActual, n.getPosY()*N+n.getPosX());
			currentPath.finish(c);
			c.setCaminoI(i,currentPath);
		}
	}

	public void optimizarCaminos()

	{

		OptimizacionCaminos oc =new OptimizacionCaminos(carros);	
		ArrayList<Camino> caminosOptimizados=oc.darConjuntoCaminosOptimizado();

		for(int i=0;i<carros.size();i++)
		{
			carros.get(i).setCaminoEnSeguimiento(caminosOptimizados.get(i));
		}

	}


	/**
	 * @return the carros
	 */
	public ArrayList<Carro> getCarros() {
		return carros;
	}


	/**
	 * @return the huertos
	 */
	public ArrayList<Nodo> getHuertos() {
		return huertos;

	}

	public void addObserver() {
		for(Carro c: carros)
		{
			c.addObserver(panelVisualizacion);
			c.addObserver(panelCarros);
		}

		ArrayList<Huerto> huertosV=new ArrayList<Huerto>();
		Huerto h=null;

		for(Nodo n: huertos)
		{
			h=n.getHuerto();
			if(h!=null){
				if(!huertosV.contains(h))
				{
					huertosV.add(h);
					h.addObserver(panelHuertos);
				}
			}else{
				System.out.println("Uno de los nodos en el arreglo de huertos de la Malla\nno posee un objeto de la clase huerto");
			}

		}
	}


	public void avanzar() {
		for(Carro c: carros){
			c.avanzarEnCamino();
		}

	}


	public String[] darObjetivos() {
		int carNum=carros.size();
		int i,j;
		String[] rta= new String[carNum];
		Carro c;

		for(i=0; i< carNum; i++)
		{
			c=carros.get(i);
			j=c.getCaminoEnSeguimiento().getDestino().getCodigo();
			rta[i]=DESTINOS[j];
		}
		return rta;
	}


	public void iniciarMovimiento() {
		for (Carro c : carros) {
			c.iniciarMovimiento();
		}
	}



}

