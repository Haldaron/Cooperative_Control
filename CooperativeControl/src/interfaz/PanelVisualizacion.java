package interfaz;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Ellipse2D;
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
import mundo.Huerto;
import mundo.Nodo;

public class PanelVisualizacion extends JPanel implements Observer {
	

		public final static Color[] COLOR_CARROS={Color.RED, new Color(0,150,0),Color.BLUE};
		public final static Color COLOR_MALLA=Color.BLACK;
	
	
		private ArrayList<Carro> carros;
		private ArrayList<Nodo> huertos;
		
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
	    
	  
	    
	    
	    private PanelMapa panelMapa;
	    private JPanel panelDatos;
	    
	    
	    public PanelVisualizacion(int pN){


	        setLayout(new GridLayout(1,2));
	        setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5 , 5), new TitledBorder( "Visualizacion" ) ) );
	        
	        //Inicializar paneles internos
	        panelMapa=new PanelMapa(null,null,pN);
	        panelMapa.setVisible(true);
	        panelMapa.setSize(100,100);
	        

	        panelDatos=new JPanel();
	        panelDatos.setLayout(new GridLayout(4,3));

	        
	        add(panelDatos);
	    	add(panelMapa);
	        
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

	        panelDatos.add(emptyC);
	        panelDatos.add(lblXC);
	        panelDatos.add(lblYC);
	        
	        panelDatos.add(lblCarro1);
	        panelDatos.add(txtCarro1X);
	        panelDatos.add(txtCarro1Y);
	        
	        panelDatos.add(lblCarro2);
	        panelDatos.add(txtCarro2X);
	        panelDatos.add(txtCarro2Y);
	        
	        panelDatos.add(lblCarro3);
	        panelDatos.add(txtCarro3X);
	        panelDatos.add(txtCarro3Y);
	    }
	    
	    
	    public void setDefault()
	    {
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
	    
	    public void setValues(int[][] carPos)
	    {
	    	JLabel actual=null;

			for(int i=0; i <Interfaz.NUM_COORD;i++)
			{
				for(int j =0; j<Interfaz.NUM_CARS;j++)
				{
					actual=txtCars[i][j];
					actual.setText(String.valueOf(carPos[i][j]));
				}
			}
	    	
	    }



		@Override
		public void update(Observable obs, Object arg) {
			if(carros.contains(obs)){
				int[] received= (int[]) arg;
				int state= received[0];
				int codCar= received[1];
				Carro c=(Carro)obs;
				txtCars[0][codCar-1].setText(String.valueOf(c.getPosX()));
				txtCars[1][codCar-1].setText(String.valueOf(c.getPosY()));
				panelMapa.repaint();
			}
		}

		public void inicializarObservables(ArrayList<Carro> carros,ArrayList<Nodo> huertos) {
			this.carros=carros;
			this.huertos=huertos;
			panelMapa.inicializarInformacion(carros,huertos);
			
		}
}
