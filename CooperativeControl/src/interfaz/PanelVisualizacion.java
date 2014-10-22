package interfaz;

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

public class PanelVisualizacion extends JPanel implements Observer {
	

		public final static Color[] COLOR_CARROS={Color.RED, new Color(0,150,0),Color.BLUE};
		public final static Color COLOR_MALLA=Color.BLACK;
	
	
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
	    
	    private int n;
	    
	    
	    public PanelVisualizacion(int pN){


	        setLayout(new GridLayout(4,3));
	        setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "Visualizacion" ) ) );
	        
	        n=pN;
	    	
	        
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
				int codCar= (Integer)arg;
				Carro c=(Carro)obs;
				txtCars[0][codCar-1].setText(String.valueOf(c.getPosX()));
				txtCars[1][codCar-1].setText(String.valueOf(c.getPosY()));
				repaint();
			
			}
		}

		public void inicializarObservables(ArrayList<Carro> carros) {
			this.carros=carros;
		}
		
		//------------------------------------------------------------------------
		//Métodos para la visualización de la malla
		//------------------------------------------------------------------------

		
		public void paintComponent(Graphics g )
		{
			super.paintComponent(g);
			
			Graphics2D g2= (Graphics2D)g;
			
			pintarMalla(g2);
			pintarCarros(g2);
			pintarHuertos(g2);
			pintarBase(g2);
			
		}
			
		
		private void pintarBase(Graphics2D g2) {
			// TODO Auto-generated method stub
			
		}


		private void pintarHuertos(Graphics2D g2) {
			// TODO Auto-generated method stub
			
		}


		private void pintarCarros(Graphics2D g2) {
			// TODO Auto-generated method stub
			Dimension dim = this.getSize();
			int separacion= dim.height/(n+1);
			int inicialX = (dim.width-dim.height)/2+separacion;
			int radio=separacion/3;
			
			if(!txtCars[0][0].getText().equals("-1"))
			{
					for(int i=0;i<3;i++)
				{
					int x = carros.get(i).getPosX()*(separacion)+inicialX-radio; 
					int y = carros.get(i).getPosY()*(separacion)+separacion-radio;
					
					g2.setColor(COLOR_CARROS[i]);
					
					Ellipse2D.Double cir = new Ellipse2D.Double(x,y,2*radio,2*radio);
					g2.fill(cir);
				}
			}
			
		}


		public void pintarMalla(Graphics2D g2)
		{
			Dimension dim = this.getSize();
			int separacion= dim.height/(n+1);
			int inicialX = (dim.width-dim.height)/2+separacion;
			
			g2.setColor(COLOR_MALLA);
					
			for(int i=0; i < n;i++)
			{
							
				//Dibujando lineas verticales
				g2.drawLine(inicialX+separacion*i, separacion, inicialX+separacion*i, n*separacion);
				
				//Dibujando lineas horizontales
				g2.drawLine(inicialX, separacion*(i+1), inicialX+(n-1)*separacion, separacion*(i+1));
			}
		
		}
		




}
