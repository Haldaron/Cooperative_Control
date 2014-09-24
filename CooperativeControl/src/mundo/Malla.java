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
	private static final int CROP3=3;
	private static final int CROP4=4;

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
	private ArrayList<Huerto> huertos;

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
		huertos = new ArrayList<Huerto>();
		malla= new Nodo[N][N];

			inicializarCarros(inicialesCarros, angulosCarros);
			inicializarHuertos(inicialesHuertos);
			inicializarMalla();
		
			crearGrafo();
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
		Huerto huerto0=huertos.get(0);
		Huerto huerto1=huertos.get(1);
		Huerto huerto2=huertos.get(2);

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
	
	public void crearGrafo(){
		
		rGrafo=new Grafo(malla);
	}
	
	public void asignarCaminosaCarro(Carro c){
		int source= c.getPosY()*N+c.getPosX();
		FindPath fp= new  FindPath(rGrafo, source);
		for(int i =0; i<huertos.size(); i++){
			int goal= huertos.get(i).getPosY()*N+c.getPosX();
			Camino nC= new Camino(c.getCodigo());
			
		}
	}
	
	
	public ArrayList<Nodo> hallarCamino(Carro c,FindPath fP, int Goal){;
		ArrayList<Nodo> secuencia= new ArrayList<Nodo>();
		Iterator<Integer> iterador= fP.caminoA(Goal).iterator();
		while(iterador.hasNext()){
			int actual= iterador.next();
			int j= actual%N;
			int i = (actual-j)*N;
			secuencia.add(malla[i][j]);
		}
		return secuencia;
		
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

