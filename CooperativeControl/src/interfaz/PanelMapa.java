package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
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

public class PanelMapa extends JPanel  {
	

		public final static Color[] COLOR_CARROS={Color.RED, new Color(0,150,0),Color.BLUE};
		public final static Color COLOR_MALLA=Color.BLACK;
		public final static Color COLOR_HUERTO=new Color(150,100,50);
		public final static Color COLOR_BASE=new Color(150,100,50);
	
	
		private ArrayList<Carro> carros;
		private ArrayList<Nodo> huertos;
		
		private int limitante;
			    
	    private int n;
	    
	    
	    public PanelMapa(ArrayList<Carro> pCarros,ArrayList<Nodo> pHuertos,int pN){


	        setLayout(new GridLayout(4,3));
	       
	        n=pN;
	        carros=pCarros;
	        huertos=pHuertos;	    	
	    	
	    }
	    
	    
	    public void setDefault()
	    {
	    	JLabel actual=null;
			for(int i=0; i <Interfaz.NUM_COORD;i++)
			{
				for(int j =0; j<Interfaz.NUM_CARS;j++){

					actual.setText(String.valueOf(-1));
				}
			}
	    }	    






		public void inicializarInformacion(ArrayList<Carro> carros, ArrayList<Nodo> huertos) {
			this.carros=carros;
			this.huertos=huertos;
			paintComponent(this.getGraphics());
		}
		
		//------------------------------------------------------------------------
		//Métodos para la visualización de la malla
		//------------------------------------------------------------------------

		
		public void paintComponent(Graphics g )
		{
			super.paintComponent(g);
			
			Graphics2D g2= (Graphics2D)g;
			
			limitante=(this.getHeight()>this.getWidth())? this.getWidth():this.getHeight();
			
			
			pintarMalla(g2);
			pintarHuertos(g2);
			pintarCarros(g2);

			pintarBase(g2);
			
		}
			
		
		private void pintarBase(Graphics2D g2) {
			// TODO Auto-generated method stub
			
			Dimension dim = this.getSize();
			int separacion= limitante/(n+1);
			int inicialX = (dim.width-limitante)/2+separacion;
			int inicialY = (dim.height-limitante)/2+separacion;
			int lado=separacion;
			
			g2.setColor(COLOR_HUERTO);
			
			Rectangle2D.Double rec = new Rectangle2D.Double(inicialX-lado/2,inicialY-lado/2,lado,lado);
			g2.fill(rec);
			
			g2.setColor(COLOR_MALLA);
			g2.draw(rec);
			
		}


		private void pintarHuertos(Graphics2D g2) {
			// TODO Auto-generated method stub
			Dimension dim = this.getSize();
			int separacion= limitante/(n+1);
			int inicialX = (dim.width-limitante)/2+separacion;
			int inicialY = (dim.height-limitante)/2+separacion;
			int radio=separacion/3;
			
			if(huertos!=null)
			{
					for(int i=0;i<huertos.size();i++)
				{
					int x = huertos.get(i).getPosX()*(separacion)+inicialX-radio; 
					int y = huertos.get(i).getPosY()*(separacion)+inicialY-radio;
					
					g2.setColor(COLOR_HUERTO);
					
					Rectangle2D.Double rec = new Rectangle2D.Double(x,y,2*radio,2*radio);
					g2.fill(rec);
					
					g2.setColor(COLOR_MALLA);
					g2.draw(rec);
				}
			}
			
		}


		private void pintarCarros(Graphics2D g2) {
			// TODO Auto-generated method stub
			Dimension dim = this.getSize();
			int separacion= limitante/(n+1);
			int inicialX = (dim.width-limitante)/2+separacion;
			int inicialY = (dim.height-limitante)/2+separacion;
			int radio=separacion/3;
			
			if(carros!=null)
			{
					for(int i=0;i<3;i++)
				{
					int x = carros.get(i).getPosX()*(separacion)+inicialX-radio; 
					int y = carros.get(i).getPosY()*(separacion)+inicialY-radio;
					
					g2.setColor(COLOR_CARROS[i]);
					
					Ellipse2D.Double cir = new Ellipse2D.Double(x,y,2*radio,2*radio);
					g2.fill(cir);
					
					g2.setColor(COLOR_MALLA);
					g2.draw(cir);
				}
			}
			
		}


		public void pintarMalla(Graphics2D g2)
		{
			Dimension dim = this.getSize();
			int separacion= limitante/(n+1);
			int inicialX = (dim.width-limitante)/2+separacion;
			int inicialY = (dim.height-limitante)/2+separacion;
			
			g2.setColor(COLOR_MALLA);
					
			for(int i=0; i < n;i++)
			{
							
				//Dibujando lineas verticales
				g2.drawLine(inicialX+separacion*i, inicialY, inicialX+separacion*i, inicialY +(n-1)*separacion);
				
				//Dibujando lineas horizontales
				g2.drawLine(inicialX, inicialY + separacion*i, inicialX+(n-1)*separacion, inicialY+separacion*i);
			}
		
		}
		




}
