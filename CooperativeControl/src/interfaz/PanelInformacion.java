package interfaz;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
	
	

	/**
	 * Es el panel donde se muestran los botones para jugar y los botones con las opciones de extensi�n.
	 */
	@SuppressWarnings("serial")
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

	    // -----------------------------------------------------------------
	    // Atributos de Interfaz
	    // -----------------------------------------------------------------


	    private SubPanelHuertos pHuertos;
	    private SubPanelDestinos pDestinos;
	    
	    private JLabel		lblCarro1;

	    private JTextField 	txtCarro1X;
	    private JTextField 	txtCarro1Y;
	    
	    private JLabel		lblCarro2;
	    private JTextField 	txtCarro2X;
	    private JTextField 	txtCarro2Y;
	    
	    private JLabel		lblCarro3;
	    private JTextField 	txtCarro3X;
	    private JTextField 	txtCarro3Y;
	    
	    private JLabel		lblXC;
	    private JLabel		lblYC;
	    private JLabel 		emptyC;
	    
	    private JTextField[][] txtCars;


	    // -----------------------------------------------------------------
	    // Constructores
	    // -----------------------------------------------------------------

	    /**
	     * Construye el panel con la referencia a la InterfazBuscaminas.
	     * @param ib Es una referencia a la clase principal de la interfaz. ib!=null.
	     */
	    public PanelInformacion()
	    {
	    	
	    	//Set Auxiliar Panels And Layouts
	        setLayout(new GridLayout(1,3));
	        
	        JPanel pCarros= new JPanel();
	        pCarros.setLayout(new GridLayout(4,3));
	        pCarros.setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "Carros" ) ) );


	        pHuertos= new SubPanelHuertos();
	        pDestinos= new SubPanelDestinos();
	    	
	        //Instanciar Labels y TextFields del panel
	        lblXC= new JLabel("X");
	        lblYC= new JLabel("Y");
	        emptyC= new JLabel("");
	        
	        
	        lblCarro1= new JLabel("C 1");
	        lblCarro2= new JLabel("C 2");
	        lblCarro3= new JLabel("C 3");

	       
	        txtCars= new JTextField[Interfaz.NUM_COORD][Interfaz.NUM_CARS];
	        
	        //Set the Default Crops and Cars initial positions 
	    	txtCarro1X = new JTextField();
	        txtCarro1Y = new JTextField();

	        txtCarro2X = new JTextField();
	        txtCarro2Y = new JTextField();

	        txtCarro3X = new JTextField();
	        txtCarro3Y = new JTextField();

	        
	        //Añadir JTextFields asociados a los carros al arreglo destinado para contenerlos
	        txtCars[0][0]=txtCarro1X;
	        txtCars[1][0]=txtCarro1Y;
	        txtCars[0][1]=txtCarro2X;
	        txtCars[1][1]=txtCarro2Y;
	        txtCars[0][2]=txtCarro3X;
	        txtCars[1][2]=txtCarro3Y;
	        
	        setDefault();

	        pCarros.add(emptyC);
	        pCarros.add(lblXC);
	        pCarros.add(lblYC);
	        
	        pCarros.add(lblCarro1);
	        pCarros.add(txtCarro1X);
	        pCarros.add(txtCarro1Y);
	        
	        pCarros.add(lblCarro2);
	        pCarros.add(txtCarro2X);
	        pCarros.add(txtCarro2Y);
	        
	        pCarros.add(lblCarro3);
	        pCarros.add(txtCarro3X);
	        pCarros.add(txtCarro3Y);
	        
	        
	        add(pCarros);
	        add(pHuertos);
	        add(pDestinos);
	        
	    }

	    public void setDefault(){
	    	JTextField actual=null;
			for(int i=0; i <Interfaz.NUM_COORD;i++)
			{
				for(int j =0; j<Interfaz.NUM_CARS;j++)
				{
					actual=txtCars[i][j];
					actual.setText(String.valueOf(Interfaz.CARROS_INICIALES[j][i]));
					actual.setEditable(true);					
				}
			}
			
			pHuertos.setDefault();
			pDestinos.setDefault();
			
	    }
	    
		/**
		 * Método que interpone como no editable los campos de texto del panel de infomación.
		 */

		public void iniciar() {
	    	JTextField actual=null;
	    	
			for(int i=0; i <Interfaz.NUM_COORD;i++)
			{
				for(int j =0; j<Interfaz.NUM_CARS;j++)
				{
					actual=txtCars[i][j];
					actual.setEditable(false);
					
				}
			}
			pHuertos.iniciar();
			String[] huertos= new String[3];
			huertos[0]="Huerto1";
			huertos[1]="Huerto2";
			huertos[2]="Huerto3";
			pDestinos.setDestinos(huertos);
			
		}
		
		public int[][] darCarrosIniciales() 
		{
			int[][] rta= new int[Interfaz.NUM_COORD][Interfaz.NUM_CARS];
			for(int i=0; i <Interfaz.NUM_COORD;i++)
			{
				for(int j =0; j<Interfaz.NUM_CARS;j++)
				{
					rta[i][j]=Integer.parseInt(txtCars[i][j].getText());
				}
			}
			return rta;
		}
		
		public int [][] darHuertosIniciales(){
		
			return pHuertos.darHuertosIniciales();
			
		}

	}

