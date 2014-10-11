package interfaz;

public class PanelBotones {
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

	package uniandes.cupi2.buscaminas.interfaz;

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

	    private static final String BOTON_MODO_MARCAR = "Marcar";

	    private static final String BOTON_MODO_DESMARCAR = "Desmarcar";

	    private static final String BOTON_MODO_DESTAPAR = "Destapar";

	    private static final String BOTON_INICIAR = "Iniciar";

	    private static final String OPCION_1 = "OPCION_1";

	    private static final String OPCION_2 = "OPCION_2";

	    // -----------------------------------------------------------------
	    // Atributos
	    // -----------------------------------------------------------------

	    /**
	     * Es una referencia a la clase principal de la interfaz
	     */
	    private InterfazBuscaminas ventanaPrincipal;

	    // -----------------------------------------------------------------
	    // Atributos de Interfaz
	    // -----------------------------------------------------------------

	    /**
	     * Es el bot�n para cambiar al modo marcar
	     */
	    private JButton botonMarcar;

	    /**
	     * Es el bot�n para cambiar al modo desmarcar
	     */
	    private JButton botonDesMarcar;

	    /**
	     * Es el bot�n para cambiar al modo destapar
	     */
	    private JButton botonDestapar;

	    /**
	     * Es el bot�n para (re)iniciar el campo minado
	     */
	    private JButton botonIniciar;

	    /**
	     * Es el bot�n para realizar la opci�n 1
	     */
	    private JButton opcion1;

	    /**
	     * Es el bot�n para realizar la opci�n 2
	     */
	    private JButton opcion2;

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
	        botonIniciar = new JButton( );

	        botonIniciar.setIcon( new ImageIcon( "./data/iniciar.jpg" ) );
	        botonIniciar.setMargin( new Insets( 1, 1, 1, 1 ) );
	        botonIniciar.setActionCommand( BOTON_INICIAR );
	        botonIniciar.setToolTipText( "Iniciar" );
	        botonIniciar.addActionListener( this );
	        add( botonIniciar );
 
	        // inicializa el botonDestapar con la imagen y los valores predeterminados
	        botonDestapar = new JButton( );
	        botonDestapar.setIcon( new ImageIcon( "./data/destapar.jpg" ) );
	        botonDestapar.setMargin( new Insets( 1, 1, 1, 1 ) );
	        botonDestapar.setToolTipText( "Destapar" );
	        botonDestapar.setActionCommand( BOTON_MODO_DESTAPAR );
	        botonDestapar.addActionListener( this );
	        add( botonDestapar );

	        // inicializa el boton de la opci�n 1
	        opcion1 = new JButton( "Opci�n 1" );
	        opcion1.setToolTipText( "Opci�n 1" );
	        opcion1.setActionCommand( OPCION_1 );
	        opcion1.addActionListener( this );
	        add( opcion1 );

	        // inicializa el boton de la opci�n 2
	        opcion2 = new JButton( "Opci�n 2" );
	        opcion2.setToolTipText( "Opcion 2" );
	        opcion2.setActionCommand( OPCION_2 );
	        opcion2.addActionListener( this );
	        add( opcion2 );
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
	        else if( BOTON_MODO_DESMARCAR.equals( comando ) )
	        {
	            ventanaPrincipal.cambiarModo( InterfazBuscaminas.MODO_DESMARCAR );
	        }
	        else if( BOTON_MODO_MARCAR.equals( comando ) )
	        {
	            ventanaPrincipal.cambiarModo( InterfazBuscaminas.MODO_MARCAR );
	        }
	        else if( BOTON_MODO_DESTAPAR.equals( comando ) )
	        {
	            ventanaPrincipal.cambiarModo( InterfazBuscaminas.MODO_DESTAPAR );
	        }
	        else if( OPCION_1.equals( comando ) )
	        {
	            ventanaPrincipal.reqFuncOpcion1( );
	        }
	        else if( OPCION_2.equals( comando ) )
	        {
	            ventanaPrincipal.reqFuncOpcion2( );
	        }
	    }
	}

}
