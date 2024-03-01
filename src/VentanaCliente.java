

import java.awt.EventQueue;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class VentanaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtNIF;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCliente frame = new VentanaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaCliente() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Mensaje.verMensaje("Valor "+txtNIF.getText()+"- Cerrando");
			}
		});
		setBounds(100, 100, 315, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNIF = new JTextField();
		txtNIF.setBounds(88, 21, 158, 20);
		contentPane.add(txtNIF);
		txtNIF.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(88, 52, 158, 20);
		contentPane.add(txtNombre);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(88, 85, 158, 20);
		contentPane.add(txtCorreo);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(88, 116, 158, 20);
		contentPane.add(txtTelefono);
		
		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Cargo la lista de clientes
				FicheroCliente f=new FicheroCliente();	
				List <Cliente> listaClientes=new ArrayList<>();
				listaClientes=FicheroCliente.lclientes;
				//Cargo el cliente nuevo
				Cliente nuevoCliente=new Cliente(txtNIF.getText(),txtNombre.getText(),
						                         txtCorreo.getText(),txtTelefono.getText());
				//Grabo el nuevo cliente
				listaClientes.add(nuevoCliente);	
				f.crearFichero(listaClientes);
				Mensaje.verMensaje(txtNIF.getText());
			}
		});
		btnNewButton.setBounds(123, 147, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblnif = new JLabel("NIF");
		lblnif.setBounds(10, 24, 46, 14);
		contentPane.add(lblnif);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 55, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(10, 88, 46, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblTelfono = new JLabel("Teléfono");
		lblTelfono.setBounds(10, 119, 46, 14);
		contentPane.add(lblTelfono);
	}
	
	public void setNIF(String idNIF) {
		txtNIF.setText(idNIF);
	}
	
	public String getNif() {
		return this.txtNIF.getText();
	}
	public String getNombre() {
		return this.txtNombre.getText();
	}
	public String getEmail() {
		return this.txtCorreo.getText();
	}
	public String getTelefono() {
		return this.txtNIF.getText();
	}
}
