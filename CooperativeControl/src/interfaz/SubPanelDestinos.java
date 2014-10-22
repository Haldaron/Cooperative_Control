package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class SubPanelDestinos extends JPanel {

	private JLabel		lblDestinoC1;
	private JLabel		lblDestinoC2;
	private JLabel		lblDestinoC3;


	private JLabel 	txtDestino1;
	private JLabel 	txtDestino2;
	private JLabel 	txtDestino3;



	private JLabel		lblDestino;
	private JLabel 		emptyC;

	private JLabel[]txtDestinos;    



	public SubPanelDestinos()
	{

		//Set Auxiliar Panels And Layouts
		setLayout(new BorderLayout());

		setLayout(new GridLayout(4,2));
		setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "Destinos" ) ) );


		//Instanciar Labels y TextFields del panel
		lblDestino= new JLabel("<html><font color='red'>Destino</font></html>");
		emptyC= new JLabel("");


		lblDestinoC1= new JLabel("C 1");
		lblDestinoC2= new JLabel("C 2");
		lblDestinoC3= new JLabel("C 3");


		txtDestinos= new JLabel[Interfaz.NUM_DESTINOS];

		//Set the Default Destinos and Destinos initial positions 
		txtDestino1 = new JLabel();
		txtDestino2 = new JLabel();
		txtDestino3 = new JLabel();


		//Añadir JTextFields asociados a los DestinoCs al arreglo destinado para contenerlos
		txtDestinos[0]=txtDestino1;
		txtDestinos[1]=txtDestino2;
		txtDestinos[2]=txtDestino3;
		
		setDefault();


		add(emptyC);
		add(lblDestino);

		add(lblDestinoC1);
		add(txtDestino1);

		add(lblDestinoC2);
		add(txtDestino2);

		add(lblDestinoC3);
		add(txtDestino3);

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



	public void setDefault() {
		JLabel actual=null;

		for(int j =0; j<Interfaz.NUM_DESTINOS;j++)
		{
			actual=txtDestinos[j];
			actual.setText("NA");
		}
	}





}
