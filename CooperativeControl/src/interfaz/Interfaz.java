
	package interfaz;

	import java.awt.BorderLayout;
import java.io.File;

	import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mundo.Malla;
import mundo.TamanosInvalidosInicializacionException;

	/**
	 * Esta es la clase principal de la interfaz del buscaminas
	 */
	public class Interfaz extends JFrame
	{

	    // -----------------------------------------------------------------
	    // Atributos
	    // -----------------------------------------------------------------


	    /**
	     * Es el campo minado sobre el que se est� jugando.
	     */
	    private Malla malla;

	    /**
	     * Es el panel donde se muestran los botones para controlar el juego
	     */
	    private PanelBotones panelBotones;
	    
	    private PanelInformacion panelInformacion;


	    // -----------------------------------------------------------------
	    // Constructores
	    // -----------------------------------------------------------------

	    /**
	     * Construye la interfaz de la aplicaci�n.
	     */
	    public Interfaz( )
	    {
	    	
	    	int[][] carrosIniciales={{0,0},{0,1},{0,2}};
	    	Double[] angulosIniciales={0.0,0.0,0.0};
	    	int[][] huertosIniciales={{5,7},{3,3},{1,9}};
	        try
	        {
	            malla = new Malla(carrosIniciales,angulosIniciales , huertosIniciales);	
	        }
	        catch(Exception e)
	        {}
	        setTitle( "VARA" );
	        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	        setResizable( false );
	        setSize( 400, 170 );

	        panelBotones = new PanelBotones(this );
	        panelInformacion= new PanelInformacion(this);
	        
	        
	        getContentPane( ).add( panelBotones, BorderLayout.NORTH );
	        getContentPane( ).add( panelInformacion, BorderLayout.SOUTH );
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
	    private void actualizar( )
	    {
	    	panelInformacion.actualizar();
	    }

	    /**
	     * Inicia un nuevo juego de buscaminas. El estado inicial del juego es: <br>
	     * Todas las casillas est�n tapadas y sin marcas. <br>
	     * Las minas se distribuyeron de manera aleatoria. <br>
	     * El tiempo de inicio del juego se inicializa en cero. <br>
	     * El modo de juego es destapar.
	     */
	    public void reiniciar( )
	    {
//	        campoMinado.inicializarJuego( );
//	        modoActual = MODO_DESTAPAR;
//	        panelBuscaminas.actualizar( campoMinado );
//	        panelBuscaminas.actualizar( campoMinado );
//
//	        int numeroMinas = campoMinado.darNumeroMinas( );
//	        int tiempo = campoMinado.darTiempoTotal( );
//	        panelBarraEstado.actualizarMinas( numeroMinas );
//	        panelBarraEstado.actualizarTiempo( tiempo );
//	        panelBarraEstado.actualizarModo( "Destapar" );   

	    }



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

		public void avanzar() {
			// TODO Auto-generated method stub
			
		}

		public void ingresarPosiciones() {
			// TODO Auto-generated method stub
			
		}


		public void cambiarPosiciones() {
			// TODO Auto-generated method stub
			
		}
	}

