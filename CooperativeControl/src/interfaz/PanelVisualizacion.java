package interfaz;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import mundo.Carro;

public class PanelVisualizacion extends JPanel implements Observer {
	
		private ArrayList<Carro> carros;
		
	    private JLabel		lblCarro1;

	    private JLabel 	txtCarro1X;
	    private JLabel 	txtCarro1Y;
	    
	    private JLabel		lblCarro2;
	    private JLabel 	txtCarro2X;
	    private JLabel 	txtCarro2Y;
	    
	    private JLabel		lblCarro3;
	    private JLabel 	txtCarro3X;
	    private JLabel 	txtCarro3Y;
	    
	    private JLabel		lblXC;
	    private JLabel		lblYC;
	    private JLabel 		emptyC;
	    
	    private JLabel[][] txtCars;
	    
	    
	    
	    public PanelVisualizacion(){


	        setLayout(new GridLayout(4,3));
	        setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "Visualizacion" ) ) );
	        
	        
	    	
	        
	        //Instanciar Labels y TextFields del panel
	        lblXC= new JLabel("X");
	        lblYC= new JLabel("Y");
	        emptyC= new JLabel("");
	        
	        
	        lblCarro1= new JLabel("C 1");
	        lblCarro2= new JLabel("C 2");
	        lblCarro3= new JLabel("C 3");

	       
	        txtCars= new JLabel[Interfaz.NUM_COORD][Interfaz.NUM_CARS];
	        
	        //Set the Default Crops and Cars initial positions 
	    	txtCarro1X = new JLabel();
	        txtCarro1Y = new JLabel();

	        txtCarro2X = new JLabel();
	        txtCarro2Y = new JLabel();

	        txtCarro3X = new JLabel();
	        txtCarro3Y = new JLabel();

	        //Añadir JLabels asociados a los carros al arreglo destinado para contenerlos
	        txtCars[0][0]=txtCarro1X;
	        txtCars[1][0]=txtCarro1Y;
	        txtCars[0][1]=txtCarro2X;
	        txtCars[1][1]=txtCarro2Y;
	        txtCars[0][2]=txtCarro3X;
	        txtCars[1][2]=txtCarro3Y;
	        
	        setDefault();

	        add(emptyC);
	        add(lblXC);
	        add(lblYC);
	        
	        add(lblCarro1);
	        add(txtCarro1X);
	        add(txtCarro1Y);
	        
	        add(lblCarro2);
	        add(txtCarro2X);
	        add(txtCarro2Y);
	        
	        add(lblCarro3);
	        add(txtCarro3X);
	        add(txtCarro3Y);
	    	
	    	
	    }
	    
	    
	    public void setDefault(){
	    	JLabel actual=null;
			for(int i=0; i <Interfaz.NUM_COORD;i++)
			{
				for(int j =0; j<Interfaz.NUM_CARS;j++)
				{
					actual=txtCars[i][j];
					actual.setText(String.valueOf(-1));
				}
			}
			
			
	    }



		@Override
		public void update(Observable obs, Object arg) {
			if(carros.contains(obs)){
				int codCar= (Integer)arg;
				Carro c=(Carro)obs;
				txtCars[0][codCar-1].setText(String.valueOf(c.getPosX()));
				txtCars[1][codCar-1].setText(String.valueOf(c.getPosY()));
			
			}
		}


		public void inicializarObservables(ArrayList<Carro> carros) {
			this.carros=carros;
		}




}
