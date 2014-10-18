package interfaz;
import mundo.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
	
	

	/**
	 * Es el panel donde se muestran los botones para jugar y los botones con las opciones de extensi�n.
	 */
	public class PanelInformacion extends JPanel
	{

	    // -----------------------------------------------------------------
	    // Constantes
	    // -----------------------------------------------------------------
		private final static int[] CAR1={0,0};
		private final static int[] CAR2={0,1};
		private final static int[] CAR3={0,2};
		
    	private final static int[][] CARROS_INICIALES={CAR1,CAR2,CAR3};
    	
		private final static int[] HUERTO1={5,7};
		private final static int[] HUERTO2={6,7};
		private final static int[] HUERTO3={1,9};
		private final static int[] HUERTO4={1,10};
    	
    	private final static int[][] HUERTOS_INICIALEs={HUERTO1,HUERTO2,HUERTO3,HUERTO4};
    	
    	private final static int NUM_COORD=2;
    	private final static int NUM_CARS=3;
    	private final static int NUM_HUERTOS=4;

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
	     * Es el boton para (re)iniciar el campo minado
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
	    
	    private JLabel		lblX;
	    private JLabel		lblY;
	    private JLabel 		empty;
	    
	    private JLabel		lblHuerto1;
	    private JTextField 	txtHuerto1X;
	    private JTextField 	txtHuerto1Y;
	    
	    private JLabel		lblHuerto2;
	    private JTextField 	txtHuerto2X;
	    private JTextField 	txtHuerto2Y;
	    
	    private JLabel		lblHuerto3;
	    private JTextField 	txtHuerto3X;
	    private JTextField 	txtHuerto3Y;
	    
	    private JLabel		lblHuerto4;
	    private JTextField 	txtHuerto4X;
	    private JTextField 	txtHuerto4Y;
	    
	    private int[][] cars;
	    private int[][] crops;
	    
	    private JTextField[][] txtCars;
	    private JTextField[][] txtCrops;


	    // -----------------------------------------------------------------
	    // Constructores
	    // -----------------------------------------------------------------

	    /**
	     * Construye el panel con la referencia a la InterfazBuscaminas.
	     * @param ib Es una referencia a la clase principal de la interfaz. ib!=null.
	     */
	    public PanelInformacion( Interfaz ib )
	    {
	    	//Instanciar ventana principal con el parámetro ib
	    	ventanaPrincipal = ib;
	    	
	    	//Set Auxiliar Panels And Layouts
	        setLayout(new BorderLayout());
	        
	        JPanel pCarros= new JPanel();
	        pCarros.setLayout(new GridLayout(4,3));
	        pCarros.setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "Carros" ) ) );


	        JPanel pHuertos= new JPanel();
	        pHuertos.setLayout(new GridLayout(5,3));
	        pHuertos.setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "Carros" ) ) );
	    	
	    	
	        //Instanciar Labels y TextFields del panel
	        lblX= new JLabel("X");
	        lblY= new JLabel("Y");
	        empty= new JLabel("");
	        
	        lblCarro1= new JLabel("Carro 1");
	        lblCarro2= new JLabel("Carro 2");
	        lblCarro3= new JLabel("Carro 3");
	        
	        lblHuerto1 = new JLabel("Huerto 1");
	        lblHuerto2 = new JLabel("Huerto 2");
	        lblHuerto3 = new JLabel("Huerto 3");
	        lblHuerto4 = new JLabel("Huerto 4");
	       
	        txtCars= new JTextField[NUM_COORD][NUM_CARS];
	        txtCrops=new JTextField[NUM_COORD][NUM_HUERTOS];
	        
	        //Set the Default Crops and Cars initial positions 
	    	txtCarro1X = new JTextField();
	        txtCarro1Y = new JTextField();

	        txtCarro2X = new JTextField();
	        txtCarro2Y = new JTextField();

	        txtCarro3X = new JTextField();
	        txtCarro3Y = new JTextField();

	        txtHuerto1X = new JTextField();
	        txtHuerto1Y = new JTextField();
	        
	        txtHuerto2X = new JTextField();
	        txtHuerto2Y = new JTextField();
	        
	        txtHuerto3X = new JTextField();
	        txtHuerto3Y = new JTextField();
	        
	        txtHuerto4X = new JTextField();
	        txtHuerto4Y = new JTextField();
	        
	        setDefault();
	        
	        //Instatiate the arrays containing the intitial positions for cars and crops
	        cars=CARROS_INICIALES;
	        crops=HUERTOS_INICIALEs;
	        
	        
	        //Añadir JTextFields asociados a los carros al arreglo destinado para contenerlos
	        txtCars[0][0]=txtCarro1X;
	        txtCars[1][0]=txtCarro1Y;
	        txtCars[0][1]=txtCarro2X;
	        txtCars[1][1]=txtCarro2Y;
	        txtCars[0][2]=txtCarro3X;
	        txtCars[1][2]=txtCarro3Y;
	        
	        //Añadir JTextFields asociados a los huertos al arreglo destinado para contenerlos
	        
	        txtCrops[0][0]=txtHuerto1X;
	        txtCrops[1][0]=txtHuerto1Y;
	        txtCrops[0][1]=txtHuerto2X;
	        txtCrops[1][1]=txtHuerto2Y;
	        txtCrops[0][2]=txtHuerto3X;
	        txtCrops[1][2]=txtHuerto3Y;
	        txtCrops[0][3]=txtHuerto4X;
	        txtCrops[1][3]=txtHuerto4Y;

	       
	        pCarros.add(empty);
	        pCarros.add(lblX);
	        pCarros.add(lblY);
	        
	        pCarros.add(lblCarro1);
	        pCarros.add(txtCarro1X);
	        pCarros.add(txtCarro1Y);
	        
	        pCarros.add(lblCarro2);
	        pCarros.add(txtCarro2X);
	        pCarros.add(txtCarro2Y);
	        
	        pCarros.add(lblCarro3);
	        pCarros.add(txtCarro3X);
	        pCarros.add(txtCarro3Y);
	        
	        pHuertos.add(empty);
	        pHuertos.add(lblX);
	        pHuertos.add(lblY);
	        
	        pHuertos.add(lblHuerto1);
	        pHuertos.add(txtHuerto1X);
	        pHuertos.add(txtHuerto1Y);
	        
	        pHuertos.add(lblHuerto2);
	        pHuertos.add(txtHuerto2X);
	        pHuertos.add(txtHuerto2Y);
	        
	        pHuertos.add(lblHuerto3);
	        pHuertos.add(txtHuerto3X);
	        pHuertos.add(txtHuerto3Y);
	        
	        pHuertos.add(lblHuerto4);
	        pHuertos.add(txtHuerto4X);
	        pHuertos.add(txtHuerto4Y);
	        
	        add(pCarros , BorderLayout.WEST);
	        add(pHuertos, BorderLayout.EAST);
	        
	    }

	    public void setDefault(){
	    	
	    	txtCarro1X.setText(String.valueOf(CAR1[0]));
	        txtCarro1X.setEditable(true);
	        txtCarro1Y.setText(String.valueOf(CAR1[1]));
	        txtCarro1Y.setEditable(true);

	        txtCarro2X.setText(String.valueOf(CAR2[0]));
	        txtCarro2X.setEditable(true);
	        txtCarro2Y.setText(String.valueOf(CAR2[1]));
	        txtCarro2Y.setEditable(true);

	        txtCarro3X.setText(String.valueOf(CAR3[0]));
	        txtCarro3X.setEditable(true);
	        txtCarro3Y.setText(String.valueOf(CAR3[1]));
	        txtCarro3Y.setEditable(true);

	        txtHuerto1X.setText(String.valueOf(HUERTO1[0]));
	        txtHuerto1X.setEditable(true);
	        txtHuerto1Y.setText(String.valueOf(HUERTO1[1]));
	        txtHuerto1Y.setEditable(true);
	        
	        txtHuerto2X.setText(String.valueOf(HUERTO2[0]));
	        txtHuerto2X.setEditable(true);
	        txtHuerto2Y.setText(String.valueOf(HUERTO2[1]));
	        txtHuerto2Y.setEditable(true);
	        
	        txtHuerto3X.setText(String.valueOf(HUERTO3[0]));
	        txtHuerto3X.setEditable(true);
	        txtHuerto3Y.setText(String.valueOf(HUERTO3[1]));
	        txtHuerto3Y.setEditable(true);
	        
	        txtHuerto4X.setText(String.valueOf(HUERTO4[0]));
	        txtHuerto4X.setEditable(true);
	        txtHuerto4Y.setText(String.valueOf(HUERTO4[1]));
	        txtHuerto4Y.setEditable(true);

	    }
	    
		/**
		 * Método que interpone como no editable los campos de texto del panel de infomación.
		 */

		public void iniciar() {
			txtCarro1X.setEditable(false);
			txtCarro2X.setEditable(false);
			txtCarro3X.setEditable(false);
			
			txtCarro1Y.setEditable(false);
			txtCarro2Y.setEditable(false);
			txtCarro3Y.setEditable(false);
			
			txtHuerto1X.setEditable(false);
			txtHuerto2X.setEditable(false);
			txtHuerto3X.setEditable(false);
			
			txtHuerto1Y.setEditable(false);
			txtHuerto1Y.setEditable(false);
			txtHuerto1Y.setEditable(false);
		}
		
		
		
		public int[][] darCarrosIniciales() 
		{
			int[][] rta= new int[2][3];
			for(int i=0; i <NUM_COORD;i++)
			{
				for(int j =0; j<NUM_CARS;i++)
				{
					rta[i][j]=Integer.parseInt(txtCars[i][j].getText());
				}
			}
			return rta;
		}
		
		public int [][] darHuertosIniciales(){
			int[][] rta= new int[2][4];
			for(int i=0; i <NUM_COORD;i++)
			{
				for(int j =0; j<NUM_HUERTOS;i++)
				{
					rta[i][j]=Integer.parseInt(txtCrops[i][j].getText());
				}
			}
			return rta;
			
		}
		

		
		
		
	}

