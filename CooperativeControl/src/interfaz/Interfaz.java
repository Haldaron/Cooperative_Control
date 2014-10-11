
	/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * $Id$ 
	 * Universidad de los Andes (Bogot� - Colombia)
	 * Departamento de Ingenier�a de Sistemas y Computaci�n 
	 * Licenciado bajo el esquema Academic Free License version 2.1 
	 *
	 * Proyecto Cupi2 
	 * Ejercicio: n6_buscaminas 
	 * Autor Inicial: Mario S�nchez - 15/07/2005
	 * Autor: Milena Vela - 21/03/2006
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 */

	package interfaz;

	import java.awt.BorderLayout;
	import java.io.File;

	import javax.swing.JFrame;
	import javax.swing.JOptionPane;

	import mundo.Malla;

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


	    // -----------------------------------------------------------------
	    // Constructores
	    // -----------------------------------------------------------------

	    /**
	     * Construye la interfaz de la aplicaci�n.
	     */
	    public InterfazBuscaminas( )
	    {
	        try
	        {
	            malla = new Malla();
	        }
	
	        setTitle( "VARA" );
	        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	        setSize( 400, 400 );
	        setResizable( false );

	        panelBotones = new PanelBotones(this );

	        setSize( 400, 400 );
	        getContentPane( ).add( panelBotones, BorderLayout.NORTH );
	    }
	    // -----------------------------------------------------------------
	    // M�todos
	    // -----------------------------------------------------------------

	    /**
	     * Cambia el modo actual
	     * @param modo El nuevo modo de juego. modo pertenece a {MODO_DESMARCAR, MODO_MARCAR, MODO_DESTAPAR}
	     */
	    public void cambiarModo( int modo )
	    {
	        modoActual = modo;
	    }

	  
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
	        panelBuscaminas.actualizar( campoMinado );
	        int numeroMinas = campoMinado.darNumeroMinasRestantes( );
	        int tiempo = campoMinado.darTiempoTotal( );
	       
	        panelBarraEstado.actualizarMinas( numeroMinas );
	        panelBarraEstado.actualizarTiempo( tiempo );

	        switch( modoActual )
	        {
	            case MODO_MARCAR:
	                panelBarraEstado.actualizarModo( "Marcar" );
	                break;
	            case MODO_DESMARCAR:
	                panelBarraEstado.actualizarModo( "Desmarcar" );
	                break;
	            case MODO_DESTAPAR:
	                panelBarraEstado.actualizarModo( "Destapar" );
	                break;
	        }
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
	        campoMinado.inicializarJuego( );
	        modoActual = MODO_DESTAPAR;
	        panelBuscaminas.actualizar( campoMinado );
	        panelBuscaminas.actualizar( campoMinado );

	        int numeroMinas = campoMinado.darNumeroMinas( );
	        int tiempo = campoMinado.darTiempoTotal( );
	        panelBarraEstado.actualizarMinas( numeroMinas );
	        panelBarraEstado.actualizarTiempo( tiempo );
	        panelBarraEstado.actualizarModo( "Destapar" );   

	    }

	    // -----------------------------------------------------------------
	    // Puntos de Extensi�n
	    // -----------------------------------------------------------------

	    /**
	     * M�todo para la extensi�n 1
	     */
	    public void reqFuncOpcion1( )
	    {
	        String resultado = campoMinado.metodo1( );
	        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	    }

	    /**
	     * M�todo para la extensi�n 2
	     */
	    public void reqFuncOpcion2( )
	    {
	        String resultado = campoMinado.metodo2( );
	        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
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
	        InterfazBuscaminas ib = new InterfazBuscaminas( );
	        ib.setVisible( true );
	    }
	}

}
