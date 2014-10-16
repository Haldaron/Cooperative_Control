	/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * $Id$ 
	 * Universidad de los Andes (Bogot� - Colombia)
	 * Departamento de Ingenier�a de Sistemas y Computaci�n 
	 * Licenciado bajo el esquema Academic Free License version 2.1 
	 *
	 * Proyecto Cupi2 
	 * Ejercicio: n6_buscaminas 
	 * Autor: Mario S�nchez - 15/07/2005 
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 */

	package interfaz;

	import java.awt.Insets;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JPanel;

	/**
	 * Es el panel donde se muestran los botones para jugar y los botones con las opciones de extensi�n.
	 */
	public class PanelBotones extends JPanel implements ActionListener
	{

	    // -----------------------------------------------------------------
	    // Constantes
	    // -----------------------------------------------------------------


	    private static final String BOTON_INICIAR = "Iniciar";

	    private static final String BOTON_STEP = "Step";

	    private static final String BOTON_INGRESAR= "ingresar";

	    // -----------------------------------------------------------------
	    // Atributos
	    // -----------------------------------------------------------------

	    /**
	     * Es una referencia a la clase principal de la interfaz
	     */
	    private Interfaz ventanaPrincipal;

	    // -----------------------------------------------------------------
	    // Atributos de Interfaz
	    // -----------------------------------------------------------------


	    /**
	     * Es el bot�n para (re)iniciar el campo minado
	     */
	    private JButton botonIniciar;
	    private JButton botonIngresar;
	    private JButton botonStep;



	    // -----------------------------------------------------------------
	    // Constructores
	    // -----------------------------------------------------------------

	    /**
	     * Construye el panel con la referencia a la InterfazBuscaminas.
	     * @param ib Es una referencia a la clase principal de la interfaz. ib!=null.
	     */
	    public PanelBotones( Interfaz ib )
	    {
	        ventanaPrincipal = ib;

	        // inicializa el botonIniciar con la imagen y los valores predeterminados
	        botonIniciar = new JButton("Iniciar");

	        botonIniciar.setMargin( new Insets( 1, 1, 1, 1 ) );
	        botonIniciar.setActionCommand( BOTON_INICIAR );
	        botonIniciar.setToolTipText( "Iniciar" );
	        botonIniciar.addActionListener( this );
	        add( botonIniciar );
	        
	     // inicializa el botonIniciar con la imagen y los valores predeterminados
	        botonStep = new JButton("Step");
	        botonStep.setMargin( new Insets( 1, 1, 1, 1 ) );
	        botonStep.setActionCommand( BOTON_STEP );
	        botonStep.setToolTipText( "mover los autos" );
	        botonStep.addActionListener( this );
	        add( botonStep );
	        
	     // inicializa el botonIniciar con la imagen y los valores predeterminados
	        botonIngresar = new JButton("Ingresar Posiciones");

	        botonIngresar.setMargin( new Insets( 1, 1, 1, 1 ) );
	        botonIngresar.setActionCommand( BOTON_INGRESAR );
	        botonIngresar.setToolTipText( "Ingresar" );
	        botonIngresar.addActionListener( this );
	        add( botonIngresar );
	    }

	    // -----------------------------------------------------------------
	    // M�todos
	    // -----------------------------------------------------------------

	    /**
	     * Este m�todo se ejecuta cuando se hace click sobre alguno de los botones
	     * @param evento - El evento del click sobre uno de los botones
	     */
	    public void actionPerformed( ActionEvent evento )
	    {
	        String comando = evento.getActionCommand( );

	        if( BOTON_INICIAR.equals( comando ) )
	        {
	            ventanaPrincipal.reiniciar( );
	        }
	        else if( BOTON_STEP.equals( comando ) )
	        {
	            ventanaPrincipal.avanzar();
	        }
	        else if( BOTON_INGRESAR.equals( comando ) )
	        {
	            ventanaPrincipal.ingresarPosiciones();
	        }
	       
	    }
	}

