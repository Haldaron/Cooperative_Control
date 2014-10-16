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
	import mundo.*;
	import java.awt.GridLayout;
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
	    
	    private JLabel		lblCarro1;
	    private JTextField 	txtCarro1X;
	    private JTextField 	txtCarro1Y;
	    
	    private JLabel		lblCarro2;
	    private JTextField 	txtCarro2X;
	    private JTextField 	txtCarro2Y;
	    
	    private JLabel		lblCarro3;
	    private JTextField 	txtCarro3X;
	    private JTextField 	txtCarro3Y;
	    
	    private JLabel		lblDestino;
	    private JLabel		lblX;
	    private JLabel		lblY;
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
	    public PanelInformacion( Interfaz ib )
	    {
	        ventanaPrincipal = ib;
	        setLayout(new GridLayout(5,4));

	        //Inicializando labels
	        
	        lblDestino = new JLabel("Destino");
	        lblX= new JLabel("X");
	        lblY= new JLabel("Y");
	        
	        lblCarro1= new JLabel("Carro 1");
	        lblCarro2= new JLabel("Carro 2");
	        lblCarro3= new JLabel("Carro 3");
	        
	        //Inicializando textos
	        
	        txtCarro1X = new JTextField();
	        txtCarro2X = new JTextField();
	        txtCarro3X = new JTextField();
	        txtCarro1X.setEditable(false);
	        txtCarro2X.setEditable(false);
	        txtCarro3X.setEditable(false);
	        
	        
	        txtCarro1Y = new JTextField();
	        txtCarro2Y = new JTextField();
	        txtCarro3Y = new JTextField();
	        txtCarro1Y.setEditable(false);
	        txtCarro2Y.setEditable(false);
	        txtCarro3Y.setEditable(false);
	        
	        txtCarro1Destino = new JTextField();
	        txtCarro2Destino = new JTextField();
	        txtCarro3Destino = new JTextField();
	        txtCarro1Destino.setEditable(false);
	        txtCarro2Destino.setEditable(false);
	        txtCarro3Destino.setEditable(false);
	        
	        //add to Layout
	        
	        add(new JLabel(""));
	        add(lblX);
	        add(lblY);
	        add(lblDestino);
	        
	        add(lblCarro1);
	        add(txtCarro1X);
	        add(txtCarro1Y);
	        add(txtCarro1Destino);
	        
	        add(lblCarro2);
	        add(txtCarro2X);
	        add(txtCarro2Y);
	        add(txtCarro2Destino);
	        
	        add(lblCarro3);
	        add(txtCarro3X);
	        add(txtCarro3Y);
	        add(txtCarro3Destino);
	    }



		public void actualizar() {
			
			 txtCarro1X.setText();
		     txtCarro2X.setText(false);
		     txtCarro3X.setText(false);
		}
	}

