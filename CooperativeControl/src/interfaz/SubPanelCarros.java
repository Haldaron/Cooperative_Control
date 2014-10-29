package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

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
import mundo.Nodo;


@SuppressWarnings("serial")
public class SubPanelCarros extends JPanel implements Observer{

	private JLabel		lblCarro1;

	private JTextField 	txtCarro1X;
	private JTextField 	txtCarro1Y;

	private JLabel		lblCarro2;
	private JTextField 	txtCarro2X;
	private JTextField 	txtCarro2Y;

	private JLabel	lblCarro3;
	private JTextField 	txtCarro3X;
	private JTextField 	txtCarro3Y;

	private JLabel	lblXC;
	private JLabel	lblYC;
	private JLabel 	emptyC;


	private JLabel	lblDestinoC1;
	private JLabel	lblDestinoC2;
	private JLabel	lblDestinoC3;

	private JLabel  Carga;

	private JLabel 	CargaC1;
	private JLabel 	CargaC2;
	private JLabel 	CargaC3;




	private JLabel		lblDestino;



	private ArrayList<Carro> carros;
	private JTextField[][] txtCars;
	private JLabel[] txtLoad;


	private JLabel[]txtDestinos;    



	public SubPanelCarros()
	{

		//Set Auxiliar Panels And Layouts
		GridLayout gL= new GridLayout(4,5);
		gL.setHgap(2);
		setLayout(gL);

		setBorder( new CompoundBorder( new EmptyBorder( 5 , 5 , 5 , 5 ), new TitledBorder( "Carros" ) ) );


		//Instanciar Labels y TextFields del panel
		emptyC= new JLabel("");
		lblXC=new JLabel("x",SwingConstants.CENTER);
		lblYC=new JLabel("y",SwingConstants.CENTER);
		lblDestino= new JLabel("Dest.",SwingConstants.CENTER);

		Carga= new JLabel("Carga",SwingConstants.CENTER);
		CargaC1=new JLabel("0",SwingConstants.CENTER);
		CargaC2=new JLabel("0",SwingConstants.CENTER);
		CargaC3=new JLabel("0",SwingConstants.CENTER);


		lblCarro1= new JLabel("Carro 1",SwingConstants.CENTER);
		lblCarro2= new JLabel("Carro 2",SwingConstants.CENTER);
		lblCarro3= new JLabel("Carro 3",SwingConstants.CENTER);

		txtCarro1X = new JTextField();
		txtCarro1Y = new JTextField();

		txtCarro2X = new JTextField();
		txtCarro2Y = new JTextField();

		txtCarro3X = new JTextField();
		txtCarro3Y = new JTextField();

		lblDestinoC1=new JLabel("NA",SwingConstants.CENTER);
		lblDestinoC2=new JLabel("NA",SwingConstants.CENTER);
		lblDestinoC3=new JLabel("NA",SwingConstants.CENTER);

		txtCarro1X.setPreferredSize(new Dimension(10, 10));



		txtDestinos= new JLabel[Interfaz.NUM_DESTINOS];
		txtLoad= new JLabel[Interfaz.NUM_CARS];
		txtCars= new JTextField[Interfaz.NUM_COORD][Interfaz.NUM_CARS];


		txtDestinos[0]=lblDestinoC1;
		txtDestinos[1]=lblDestinoC2;
		txtDestinos[2]=lblDestinoC3;
		
		txtLoad[0]=CargaC1;
		txtLoad[1]=CargaC2;
		txtLoad[2]=CargaC3;


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
		add(lblDestino);
		add(Carga);

		add(lblCarro1);
		add(txtCarro1X);
		add(txtCarro1Y);
		add(lblDestinoC1);
		add(CargaC1);

		add(lblCarro2);
		add(txtCarro2X);
		add(txtCarro2Y);
		add(lblDestinoC2);
		add(CargaC2);


		add(lblCarro3);
		add(txtCarro3X);
		add(txtCarro3Y);
		add(lblDestinoC3);
		add(CargaC3);



	}

	public void setDestinos(String[] dests){
		JLabel actual=null;
		String[] destinos=new String[3];
		if(dests==null){
			for(String s:destinos){
				s="Error";
			}
		}else{
			destinos=dests;
		}

		for(int j =0; j<Interfaz.NUM_DESTINOS;j++)
		{
			actual=txtDestinos[j];
			actual.setText(destinos[j]);
		}
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

		JLabel actual1=null;


		for(int j =0; j<Interfaz.NUM_DESTINOS;j++)
		{
			actual1=txtDestinos[j];
			actual1.setText("NA");
		}		
	}

	/**
	 * Método que interpone como no editable los campos de texto del panel de infomación.
	 */

	public void iniciar(String[] huertos) {
		JTextField actual=null;

		for(int i=0; i <Interfaz.NUM_COORD;i++)
		{
			for(int j =0; j<Interfaz.NUM_CARS;j++)
			{
				actual=txtCars[i][j];
				actual.setEditable(false);

			}
		}

		setDestinos(huertos);

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



	public void inicializarObservables(ArrayList<Carro> carros)
	{
		this.carros=carros;			
	}


	@Override
	public void update(Observable obs, Object arg) {
		if(carros.contains(obs))
		{
			try
			{
				int[] received= (int[]) arg;
				int state= received[0];
				int codCar= received[1];
				Carro c=(Carro)obs;
				if(state==Carro.MOVING){
					txtCars[0][codCar-1].setText(String.valueOf(c.getPosX()));
					txtCars[1][codCar-1].setText(String.valueOf(c.getPosY()));
				}else if(state==Carro.HARVESTING){
					txtLoad[codCar-1].setText(String.valueOf(c.getCarga()));
				}
			}catch(ClassCastException e){
				System.out.println("Error en el casting de argumento enviado por carros a subpanelCarros");
			}

		}		


	}





}
