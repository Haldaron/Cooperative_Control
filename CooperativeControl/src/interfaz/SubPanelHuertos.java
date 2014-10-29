package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import mundo.Huerto;
import mundo.Malla;

@SuppressWarnings("serial")
public class SubPanelHuertos extends JPanel implements Observer
{



	private JLabel		lblXH;
	private JLabel		lblYH;
	private JLabel 		emptyH;
	
	private JLabel		lblXH1;
	private JLabel		lblYH1;
	private JLabel 		emptyH1;

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

	private JLabel  Frutos1;
	private JLabel  Frutos2;

	
    private JLabel 	FrutosH1;
    private JLabel 	FrutosH2;
    
	private JTextField[][] txtCrops;  
	
	private JLabel[] Carga;
	
	private ArrayList<Huerto> huertos;

	public SubPanelHuertos()
	{
		GridLayout gL=new GridLayout(1,2);
		gL.setHgap(5);

		setLayout(gL);
		
		JPanel pAux3=new JPanel(new BorderLayout());
		
		JPanel pAux4= new JPanel(new BorderLayout());
		
		JPanel pAux1= new JPanel(new GridLayout(3,4));
		pAux3.setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5), new TitledBorder( "Huerto1" ) ) );

		JPanel pAux2= new JPanel(new GridLayout(3,3));
		pAux4.setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "Huerto2" ) ) );
		
		JPanel pAux5= new JPanel(new GridLayout(2,1));
		
		JPanel pAux6=new JPanel(new GridLayout(2,1));


		//Instanciar Labels y TextFields del panel
		lblXH= new JLabel("X");
		lblYH= new JLabel("Y");
		emptyH= new JLabel("");
		
		lblXH1= new JLabel("X");
		lblYH1= new JLabel("Y");
		emptyH1= new JLabel("");

		lblHuerto1 = new JLabel("1");
		lblHuerto2 = new JLabel("2");
		lblHuerto3 = new JLabel("1");
		lblHuerto4 = new JLabel("2");

		txtCrops=new JTextField[Interfaz.NUM_COORD][Interfaz.NUM_HUERTOS];

		//Set the Default Crops initial positions 
		txtHuerto1X = new JTextField(SwingConstants.CENTER);
		txtHuerto1Y = new JTextField(SwingConstants.CENTER);

		txtHuerto2X = new JTextField(SwingConstants.CENTER);
		txtHuerto2Y = new JTextField(SwingConstants.CENTER);

		txtHuerto3X = new JTextField(SwingConstants.CENTER);
		txtHuerto3Y = new JTextField(SwingConstants.CENTER);

		txtHuerto4X = new JTextField(SwingConstants.CENTER);
		txtHuerto4Y = new JTextField(SwingConstants.CENTER);
		
		Frutos1=new JLabel("Frutos",SwingConstants.CENTER);
		Frutos2=new JLabel("Frutos",SwingConstants.CENTER);
		FrutosH1=new JLabel(String.valueOf(Malla.FRUIT_NUMBER),SwingConstants.CENTER);
		FrutosH2=new JLabel(String.valueOf(Malla.FRUIT_NUMBER),SwingConstants.CENTER);
		
		
		huertos=new ArrayList<Huerto>();
		
		Carga=new JLabel[Malla.CROP_NUMBER];
		//Añadir JTextFields asociados a los huertos al arreglo destinado para contenerlos
		
		Carga[0]=FrutosH1;
		Carga[1]=FrutosH2;

		txtCrops[0][0]=txtHuerto1X;
		txtCrops[1][0]=txtHuerto1Y;
		txtCrops[0][1]=txtHuerto2X;
		txtCrops[1][1]=txtHuerto2Y;
		txtCrops[0][2]=txtHuerto3X;
		txtCrops[1][2]=txtHuerto3Y;
		txtCrops[0][3]=txtHuerto4X;
		txtCrops[1][3]=txtHuerto4Y;

		setDefault();

		pAux1.add(emptyH);
		pAux1.add(lblXH);
		pAux1.add(lblYH);

		pAux1.add(lblHuerto1);
		pAux1.add(txtHuerto1X);
		pAux1.add(txtHuerto1Y);

		pAux1.add(lblHuerto2);
		pAux1.add(txtHuerto2X);
		pAux1.add(txtHuerto2Y);
		
		
		pAux2.add(emptyH1);
		pAux2.add(lblXH1);
		pAux2.add(lblYH1);
		
		pAux2.add(lblHuerto3);
		pAux2.add(txtHuerto3X);
		pAux2.add(txtHuerto3Y);

		pAux2.add(lblHuerto4);
		pAux2.add(txtHuerto4X);
		pAux2.add(txtHuerto4Y);
		
		pAux5.add(Frutos1);
		pAux5.add(FrutosH1);
		
		pAux6.add(Frutos2);
		pAux6.add(FrutosH2);
		
		pAux3.add(pAux1,BorderLayout.CENTER);
		pAux3.add(pAux5,BorderLayout.EAST);
		pAux4.add(pAux2,BorderLayout.CENTER);
		pAux4.add(pAux6,BorderLayout.EAST);
		
		
		
		add(pAux3);
		add(pAux4);

	}

	public void iniciar() {
		JTextField actual=null;
		for(int i=0; i <Interfaz.NUM_COORD;i++)
		{
			for(int j =0; j<Interfaz.NUM_HUERTOS;j++)
			{
				actual=txtCrops[i][j];
				actual.setEditable(false);
			}
		}
	}

	public void setDefault(){
		JTextField actual=null;

		for(int i=0; i <Interfaz.NUM_COORD;i++)
		{
			for(int j =0; j<Interfaz.NUM_HUERTOS;j++)
			{
				actual=txtCrops[i][j];
				actual.setText(String.valueOf(Interfaz.HUERTOS_INICIALES[j][i]));
				actual.setEditable(true);
			}
		}
	}


	public int [][] darHuertosIniciales(){
		int[][] rta= new int[Interfaz.NUM_COORD][Interfaz.NUM_HUERTOS];
		for(int i=0; i <Interfaz.NUM_COORD;i++)
		{
			for(int j =0; j<Interfaz.NUM_HUERTOS;j++)
			{
				rta[i][j]=Integer.parseInt(txtCrops[i][j].getText());
			}
		}
		return rta;

	}
	
	public void inicializarObservables(ArrayList<Huerto> huertos)
	{
		this.huertos=huertos;			
	}


	@Override
	public void update(Observable o, Object arg) {
		if(huertos.contains(o)){
		try{
			Huerto h= (Huerto)o;
			int codigo=(Integer)arg;
			Carga[codigo].setText(String.valueOf(h.getNumFrutos()));
			
		}catch(ClassCastException e){
			System.out.println("Error en el cast para uno de los huertos en subpanel huertos");
		}
		}
	}
	
	

}
