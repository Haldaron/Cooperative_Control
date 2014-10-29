package interfaz;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import mundo.Carro;
import mundo.Huerto;
import mundo.Nodo;
	
	

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
	    private SubPanelCarros pCarros;
	    
	    


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
	        setLayout(new GridLayout(1,2) );
	        pHuertos= new SubPanelHuertos();
	        
	        
	        add(pHuertos);
	        
	        pCarros= new SubPanelCarros();
	        
	        
	        add(pCarros);
	        
	    	
	        //Instanciar Labels y TextFields del panel
	        
	    }

	    public void setDefault(){
			
			pHuertos.setDefault();
			pCarros.setDefault();
			
	    }
	    
		/**
		 * Método que interpone como no editable los campos de texto del panel de infomación.
		 */

		public void iniciar(String[] huertos) {
			
			pCarros.iniciar(huertos);
			
			pHuertos.iniciar();
				
		}
		
		public int[][] darCarrosIniciales() 
		{

			return pCarros.darCarrosIniciales();
		}
		
		public int [][] darHuertosIniciales(){
		
			return pHuertos.darHuertosIniciales();
			
		}

		
		public void inicializarObservables(ArrayList<Carro> carros, ArrayList<Nodo> huertos)
		{
			
			
			pCarros.inicializarObservables(carros);
			
			ArrayList<Huerto> huertosV= new ArrayList<Huerto>();
			
			Huerto h=null;
			for(Nodo n : huertos){
				if(!huertosV.contains(n))
				{
					h=n.getHuerto();
					if(h!=null)
					{
					huertosV.add(n.getHuerto());
					}else{
						System.out.println("Uno de los nodos en el arreglo de huertos de la Malla\nno posee un objeto de la clase huerto");
					}
				}
			}
			
			pHuertos.inicializarObservables(huertosV);
			
		}

		public Observer getPanelCarros() {
			// TODO Auto-generated method stub
			return pCarros;
		}

		public Observer getPanelHuertos() {
			// TODO Auto-generated method stub
			return pHuertos;
		}

	}

