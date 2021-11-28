package calculadora;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			VentanaLogin dialog = new VentanaLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	/**
	 * Create the dialog.
	 */
	
	private JLabel icono, etiqueta;
	private JPasswordField contraseña;
	private JButton botonOk, botonCancel;
	
	private JTextField numero1;
	private JLabel pantallaResultado;
	
	NumberFormat numFormat = NumberFormat.getInstance();
	
	public VentanaLogin(JTextField num1, JLabel result) {
		this.numero1 = num1;
		this.pantallaResultado = result;
		
		setSize(350, 200);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		//contentPanel.setLayout(new FlowLayout());
		//contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		// getContentPane().add(contentPanel, BorderLayout.CENTER);
		/*{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		} */ 
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Para que no nos organice la posición de los componentes por defecto
		setLayout(null);
		setTitle("Introduzca su contraseña");
		// Llamamos al método que inicializa los componentes:
		inicializarComponentes();
		
		setVisible(true);
	}
	
	private void inicializarComponentes () {
		getContentPane().setBackground(new Color(115, 157, 188));
		
		// Creamos el icono, le asignamos la imagen png que deseamos 
		icono = new JLabel(new ImageIcon("account-key-blanco.png"));
		// Lo ubicamos dentro de la pantalla
		icono.setBounds(50, 20, 40, 40);
		add(icono);
		
		// Creamos la etiqueta, la ubicamos y le cambiamos la fuente
		etiqueta = new JLabel("Contraseña:");
		etiqueta.setBounds(110, 30, 100, 25);
		etiqueta.setFont(new Font("Dialog", Font.BOLD, 15));
		add(etiqueta);
		
		contraseña = new JPasswordField();
		contraseña.setBounds(110, 60, 170, 25);
		contraseña.setForeground(new Color(63, 98, 123));
		add(contraseña);
		
		botonOk = new JButton("OK");
		botonOk.setBounds(120, 100, 55, 30);
		add(botonOk);
		botonOk.setFont(new Font("Dialog", Font.BOLD, 11));
		// Establecemos color de la letra del botón
		botonOk.setForeground(new Color(98, 130, 152));
		// Establecemos color de fondo del botón
		botonOk.setBackground(new Color(217, 225, 231));
		botonOk.setBorder(null);
		
		// Creamos el botón de cancelar y le damos sus propiedades
		botonCancel = new JButton("Cancelar");
		botonCancel.setBounds(180, 100, 90, 30);
		add(botonCancel);
		botonCancel.setFont(new Font("Dialog", Font.BOLD, 11));
		botonCancel.setForeground(new Color(98, 130, 152));
		botonCancel.setBackground(new Color(217, 225, 231));
		botonCancel.setBorder(null);
		
		botonOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Guardamos en un String el valor de la contraseña introducida
				String contrasena = String.copyValueOf(contraseña.getPassword());
				
				// Establecemos que la contraseña correcta sea avengers. En caso de serlo, se dará paso a la operación
				if(contrasena.equals("avengers")) {
					
					// Esta ventana será la que realice la operación con el número que le ha llegado por pantalla desde la ventana principal
					// Convertimos a Double el valor en string de la caja de texto del número
					double numero = Double.parseDouble(numero1.getText());
					// Calculamos la raíz cuadrada
					double raízCuadrada = Math.cbrt(numero);
					
					// Asignamos a la JLabel que contendrá el resultado del valor de la operación, que saldrá en la etiqueta de la VentanaPrincipal
					pantallaResultado.setText("Resultado: " + numFormat.format(raízCuadrada));
					
					
					// Hacemos que la ventana desaparezca (se cierra) para dar paso a la operación de la calculadora
					dispose();

				} else {
					setTitle("Contraseña incorrecta, vuelva a introducirla:");
					etiqueta.setText("Contraseña incorrecta");
					contraseña.setText("");
					contraseña.requestFocus();
					
				}
				
			}
		});
		
		botonCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contraseña.setText("");
				contraseña.requestFocus();
			}
		});;
		
		
		
	}
	

}
