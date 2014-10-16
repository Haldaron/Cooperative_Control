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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

	/**
	 * Es el panel donde se muestran los botones para jugar y los botones con las opciones de extensi�n.
	 */
	public class PanelInformacion extends JPanel
	{

	    // -----------------------------------------------------------------
	    // Constantes
	    // -----------------------------------------------------------------


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
	    
	    private JLabel		lblCarro1X;
	    private JLabel		lblCarro1Y;
	    private JTextField 	txtCarro1X;
	    private JTextField 	txtCarro1Y;
	    
	    private JLabel		lblCarro2X;
	    private JLabel		lblCarro2Y;
	    private JTextField 	txtCarro2X;
	    private JTextField 	txtCarro2Y;
	    
	    private JLabel		lblCarro3X;
	    private JLabel		lblCarro3Y;
	    private JTextField 	txtCarro3X;
	    private JTextField 	txtCarro3Y;
	    
	    private JLabel		lblCarro1Destino;
	    private JLabel		lblCarro2Destino;
	    private JLabel		lblCarro3Destino;
	    private JTextField 	txtCarro1Destino;
	    private JTextField 	txtCarro2Destino;
	    private JTextField 	txtCarro3Destino;



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

	    
	    }

	    // -----------------------------------------------------------------
	    // M�todos
	    // -----------------------------------------------------------------


	}

