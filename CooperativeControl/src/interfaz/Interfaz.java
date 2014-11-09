
package interfaz;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mundo.Malla;
import mundo.TamanosInvalidosInicializacionException;

/**
 * Esta es la clase principal de la interfaz del buscaminas
 */
@SuppressWarnings("serial")
public class Interfaz extends JFrame
{

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	public final static int[] CAR1={0,0};
	public final static int[] CAR2={0,1};
	public final static int[] CAR3={0,2};

	public final static int[][] CARROS_INICIALES={CAR1,CAR2,CAR3};


	public final static int[] HUERTO1={5,7};
	public final static int[] HUERTO2={6,7};
	public final static int[] HUERTO3={1,9};
	public final static int[] HUERTO4={1,8};

	public final static int[][] HUERTOS_INICIALES={HUERTO1,HUERTO2,HUERTO3,HUERTO4};

	public final static int NUM_HUERTOS=4;
	public final static int NUM_COORD=2;
	public final static int NUM_CARS=3;
	public static final int NUM_DESTINOS =3 ;


	/**
	 * Es el campo minado sobre el que se est� jugando.
	 */
	private Malla malla;

	/**
	 * Es el panel donde se muestran los botones para controlar el juego
	 */
	private PanelBotones panelBotones;

	private PanelInformacion panelInformacion;

	private PanelVisualizacion panelVisualizacion;


	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye la interfaz de la aplicaci�n.
	 */
	public Interfaz( )
	{
		malla=null;

		setTitle( "VARA" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setResizable( true );
		setSize( 600, 600);

		panelBotones = new PanelBotones(this );
		panelInformacion= new PanelInformacion();
		panelVisualizacion= new PanelVisualizacion(Malla.N);

		getContentPane( ).add( panelBotones, BorderLayout.SOUTH );
		getContentPane( ).add( panelInformacion, BorderLayout.NORTH );
		getContentPane( ).add( panelVisualizacion, BorderLayout.CENTER );


		setLocationRelativeTo(null);
	}
	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------


	/**
	 * Destapa una posici�n.<br>
	 * Si la casilla no esta tapada o el juego ya se termin� se informa al usuario
	 * @param x Coordenada x de la posici�n que se va a destapar
	 * @param y Coordenada y de la posici�n que se va a destapar
	 */

	/**
	 * Actualiza el panel del buscaminas y la barra de estado
	 */
	public Malla darMalla()
	{
		return malla;
	}

	/**
	 * Inicia un nuevo juego de buscaminas. El estado inicial del juego es: <br>
	 * Todas las casillas est�n tapadas y sin marcas. <br>
	 * Las minas se distribuyeron de manera aleatoria. <br>
	 * El tiempo de inicio del juego se inicializa en cero. <br>
	 * El modo de juego es destapar.
	 */


	// -----------------------------------------------------------------
	// Ejecuci�n
	// -----------------------------------------------------------------

	/**
	 * Ejecuta la aplicaci�n
	 * @param args Los par�metros para ejecutar la aplicaci�n. No se requiere ninguno.
	 */
	public static void main( String[] args )
	{
		Interfaz ib = new Interfaz( );
		ib.setVisible( true );
	}

	public void avanzar()
	{

		if(malla!=null){
			//				malla.avanzar();
			malla.iniciarMovimiento();


		}
		else{
			JOptionPane.showMessageDialog(this, "El mundo aun no ha sido inicializado\nIngrese valores iniciales validos y oprima iniciar", "Error"
					, JOptionPane.ERROR_MESSAGE);
		}
	}

	public void editar( )
	{
		panelInformacion.setDefault();
		malla=null;
	}

	public void iniciar(){


		Double[] angulosIniciales={0.0,0.0,0.0};
		try{
			int huertosIniciales[][]= panelInformacion.darHuertosIniciales();

			int carrosIniciales[][]=panelInformacion.darCarrosIniciales();

			try
			{
				malla = new Malla(carrosIniciales,angulosIniciales , huertosIniciales,panelVisualizacion,panelInformacion.getPanelCarros(),panelInformacion.getPanelHuertos());
				panelVisualizacion.inicializarObservables(malla.getCarros(),malla.getHuertos());
				panelInformacion.inicializarObservables(malla.getCarros(),malla.getHuertos());
				malla.addObserver();
				panelInformacion.iniciar(malla.darObjetivos());

			}
			catch(TamanosInvalidosInicializacionException e)
			{
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error de Inicialización", JOptionPane.ERROR_MESSAGE);

			}

		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Ingrese Valores de posición ij contiguos para componentes\nde un mismo huerto"
					, "Alerta Iniciales Huertos", JOptionPane.ERROR_MESSAGE);
		}


	}


}

