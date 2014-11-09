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
		
	    
	  
	    
	    
	    private PanelMapa panelMapa;
	    
	    
	    public PanelVisualizacion(int pN){


	        setLayout(new GridLayout(1,2));
	        setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5 , 5), new TitledBorder( "Visualizacion" ) ) );
	        
	        //Inicializar paneles internos
	        panelMapa=new PanelMapa(null,null,pN);
	        panelMapa.setVisible(true);
	        panelMapa.setSize(100,100);
	        
	    	add(panelMapa);


	    }
	    
	    




		@Override
		public void update(Observable obs, Object arg) {
			if(carros.contains(obs)){
				panelMapa.repaint();
			}
		}

		public void inicializarObservables(ArrayList<Carro> carros,ArrayList<Nodo> huertos) {
			this.carros=carros;
			this.huertos=huertos;
			panelMapa.inicializarInformacion(carros,huertos);
			
		}
}
