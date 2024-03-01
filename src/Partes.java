import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;
import java.util.ArrayList;

/*
 *  --  Java Doc --
 */

/** 
 * @version 6.0
 * @author Profesor
 * @Descripcion Dar de alta con estados o fases y foco
 */

/*
 *  -- Fin de JavaDoc --
 */

public class Partes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField txtNIF;
	private JTextField Obra;
	private JLabel lblFecha;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	
	//Datos de la aplicación
    public Cliente c;
    private JTextField textField;
    
    // Fases del programa 
    
    private boolean faseNif=false;
    private boolean faseNifEmpleado=false;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Mensaje.verMensaje(" ¡Bienvenido! Vamos a crear un parte de trabajo");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Partes frame = new Partes();
					frame.setVisible(true);
					Mensaje.verMensaje("Inserte su NIF en el campo del Cliente");
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public Partes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 675, 600);
		contentPane = new JPanel();
		contentPane.setAlignmentY(0.1f);
		contentPane.setAlignmentX(0.1f);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Alta Parte");
		btnNewButton.setBounds(500, 520, 90, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Cliente:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtNIF = new JTextField();
		txtNIF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				FicheroCliente fc=new FicheroCliente();
				
				Cliente c=new Cliente(txtNIF.getText(),"","","");
				
				List <Cliente> lc=new ArrayList<>();
				lc=FicheroCliente.lclientes;
				
				if (Cliente.clienteExiste(txtNIF.getText(),lc)) {
					verMensaje("Ok, el cliente existe");
				} else {
				    VentanaCliente vc=new VentanaCliente();
				    vc.setNIF(txtNIF.getText());
				    vc.txtNIF.setEnabled(false);
				    vc.setVisible(true);
				    txtNIF.setEnabled(false);			 
				}
				
			}
		});
		txtNIF.setBounds(86, 5, 300, 20);
		contentPane.add(txtNIF);
		txtNIF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Obra:");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		Obra = new JTextField();
		Obra.setColumns(10);
		Obra.setBounds(86, 33, 300, 20);
		contentPane.add(Obra);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(430, 11, 46, 14);
		contentPane.add(lblFecha);
		
		lblNewLabel_2 = new JLabel("Empleado:");
		lblNewLabel_2.setBounds(10, 67, 64, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(86, 61, 300, 20);
		contentPane.add(textField_1);
		
		JDateChooser dateFecha = new JDateChooser();
		dateFecha.setBounds(475, 5, 152, 20);
		contentPane.add(dateFecha);
		
		JLabel lblNewLabel_2_1 = new JLabel("Materiales:");
		lblNewLabel_2_1.setBounds(10, 107, 64, 14);
		contentPane.add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(86, 104, 300, 90);
		contentPane.add(textField);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(10, 520, 90, 30);
		contentPane.add(btnLimpiar);
	}
	
	public static String pedirCliente() {
		String s = JOptionPane.showInputDialog("Introduce el cliente:");
		verMensaje("Si el cliente existe paso al siguiente campo\n"+
		           "si no existe hago que salte panel de alta cliente");
		     
		return s;
	}
	
	static public void verMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
