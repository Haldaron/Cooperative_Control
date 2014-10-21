package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SubPanelHuertos extends JPanel 
{



	private JLabel		lblXH;
	private JLabel		lblYH;
	private JLabel 		emptyH;

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


	private JTextField[][] txtCrops;    

	public SubPanelHuertos()
	{
		//Instanciar ventana principal con el parámetro ib

		//Set Auxiliar Panels And Layouts
		setLayout(new BorderLayout());

		setLayout(new GridLayout(5,3));
		setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "Huertos" ) ) );


		//Instanciar Labels y TextFields del panel
		lblXH= new JLabel("X");
		lblYH= new JLabel("Y");
		emptyH= new JLabel("");

		lblHuerto1 = new JLabel("H 1");
		lblHuerto2 = new JLabel("H 2");
		lblHuerto3 = new JLabel("H 3");
		lblHuerto4 = new JLabel("H 4");

		txtCrops=new JTextField[Interfaz.NUM_COORD][Interfaz.NUM_HUERTOS];

		//Set the Default Crops initial positions 
		txtHuerto1X = new JTextField();
		txtHuerto1Y = new JTextField();

		txtHuerto2X = new JTextField();
		txtHuerto2Y = new JTextField();

		txtHuerto3X = new JTextField();
		txtHuerto3Y = new JTextField();

		txtHuerto4X = new JTextField();
		txtHuerto4Y = new JTextField();


		//Añadir JTextFields asociados a los huertos al arreglo destinado para contenerlos

		txtCrops[0][0]=txtHuerto1X;
		txtCrops[1][0]=txtHuerto1Y;
		txtCrops[0][1]=txtHuerto2X;
		txtCrops[1][1]=txtHuerto2Y;
		txtCrops[0][2]=txtHuerto3X;
		txtCrops[1][2]=txtHuerto3Y;
		txtCrops[0][3]=txtHuerto4X;
		txtCrops[1][3]=txtHuerto4Y;

		setDefault();

		add(emptyH);
		add(lblXH);
		add(lblYH);

		add(lblHuerto1);
		add(txtHuerto1X);
		add(txtHuerto1Y);

		add(lblHuerto2);
		add(txtHuerto2X);
		add(txtHuerto2Y);

		add(lblHuerto3);
		add(txtHuerto3X);
		add(txtHuerto3Y);

		add(lblHuerto4);
		add(txtHuerto4X);
		add(txtHuerto4Y);

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

}
