package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class DialogoIngresar extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Referencia a la ventana principal de la interfaz.
     */
    private Interfaz principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel donde se indican los datos de la estación.
     */
    private JLabel		lblCarro1;
    private JTextField 	txtCarro1X;
    private JTextField 	txtCarro1Y;
    
    private JLabel		lblCarro2;
    private JTextField 	txtCarro2X;
    private JTextField 	txtCarro2Y;
    
    private JLabel		lblCarro3;
    private JTextField 	txtCarro3X;
    private JTextField 	txtCarro3Y;
    
    private JLabel		lblX;
    private JLabel		lblY;
    
    private JButton 	btnAceptar;
    private	JButton		btnCancelar;		

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo e inicializa sus componentes.
     * @param ventanaPrincipal Es una referencia a la ventana principal de la interfaz. ventanaPrincipal!=null.
     * @param pLinea Línea a la cual pertenecerá la estación.
     */
    public DialogoIngresar( Interfaz ib)
    {
    	principal = ib;
        setLayout(new GridLayout(5,3));

        //Inicializando labels
        
        lblDestino = new JLabel("Destino");
        lblX= new JLabel("X");
        lblY= new JLabel("Y");
        
        lblCarro1= new JLabel("Carro 1");
        lblCarro2= new JLabel("Carro 2");
        lblCarro3= new JLabel("Carro 3");
        
        //Inicializando textos
        
        txtCarro1X = new JTextField();
        txtCarro2X = new JTextField();
        txtCarro3X = new JTextField();
        
        txtCarro1Y = new JTextField();
        txtCarro2Y = new JTextField();
        txtCarro3Y = new JTextField();
        
        //Botones
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        btnAceptar.setActionCommand("ACEPTAR");
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        btnCancelar.setActionCommand("CANCELAR");
        
        
        //add to Layout
        
        add(new JLabel(""));
        add(lblX);
        add(lblY);
        
        add(lblCarro1);
        add(txtCarro1X);
        add(txtCarro1Y);
        
        add(lblCarro2);
        add(txtCarro2X);
        add(txtCarro2Y);
        
        add(lblCarro3);
        add(txtCarro3X);
        add(txtCarro3Y);
        
        add(btnAceptar);
        add(btnCancelar);
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Agrega una estación a una línea de metro.
     * @param pNombre El nombre de la estación. pNombre != null.
     * @param pZona País donde se encuentra la estación. pZona != null.
     * @param pTiempo Tiempo que se toma en llegar de la estación anterior a la nueva estación. pTiempo>=0.
     * @param pCoordX La coordenada x de la estación. 0<pCoordX<1.
     * @param pCoordY La coordenada y de la estación. 0<pCoordY<1.
     */
    public void agregarEstacion( String pNombre, String pZona, int pTiempo, double pCoordX, double pCoordY )
    {
    	
    }

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ACEPTAR"))
		{
						
		}
		else if(e.getActionCommand().equals("CANCELAR"))
		{
			String carro1X=txtCarro1X.getText();
			String carro2X=txtCarro2X.getText();
			String carro3X=txtCarro3X.getText();
			
			String carro1Y=txtCarro1Y.getText();
			String carro2Y=txtCarro2Y.getText();
			String carro3Y=txtCarro3Y.getText();
			
			principal.cambiarPosiciones();
			dispose();
		}
	}


}
