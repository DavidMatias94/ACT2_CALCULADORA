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
	private JPasswordField contrase�a;
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
		// Para que no nos organice la posici�n de los componentes por defecto
		setLayout(null);
		setTitle("Introduzca su contrase�a");
		// Llamamos al m�todo que inicializa los componentes:
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
		etiqueta = new JLabel("Contrase�a:");
		etiqueta.setBounds(110, 30, 100, 25);
		etiqueta.setFont(new Font("Dialog", Font.BOLD, 15));
		add(etiqueta);
		
		contrase�a = new JPasswordField();
		contrase�a.setBounds(110, 60, 170, 25);
		contrase�a.setForeground(new Color(63, 98, 123));
		add(contrase�a);
		
		botonOk = new JButton("OK");
		botonOk.setBounds(120, 100, 55, 30);
		add(botonOk);
		botonOk.setFont(new Font("Dialog", Font.BOLD, 11));
		// Establecemos color de la letra del bot�n
		botonOk.setForeground(new Color(98, 130, 152));
		// Establecemos color de fondo del bot�n
		botonOk.setBackground(new Color(217, 225, 231));
		botonOk.setBorder(null);
		
		// Creamos el bot�n de cancelar y le damos sus propiedades
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
				//Guardamos en un String el valor de la contrase�a introducida
				String contrasena = String.copyValueOf(contrase�a.getPassword());
				
				// Establecemos que la contrase�a correcta sea avengers. En caso de serlo, se dar� paso a la operaci�n
				if(contrasena.equals("avengers")) {
					
					// Esta ventana ser� la que realice la operaci�n con el n�mero que le ha llegado por pantalla desde la ventana principal
					// Convertimos a Double el valor en string de la caja de texto del n�mero
					double numero = Double.parseDouble(numero1.getText());
					// Calculamos la ra�z cuadrada
					double ra�zCuadrada = Math.cbrt(numero);
					
					// Asignamos a la JLabel que contendr� el resultado del valor de la operaci�n, que saldr� en la etiqueta de la VentanaPrincipal
					pantallaResultado.setText("Resultado: " + numFormat.format(ra�zCuadrada));
					
					
					// Hacemos que la ventana desaparezca (se cierra) para dar paso a la operaci�n de la calculadora
					dispose();

				} else {
					setTitle("Contrase�a incorrecta, vuelva a introducirla:");
					etiqueta.setText("Contrase�a incorrecta");
					contrase�a.setText("");
					contrase�a.requestFocus();
					
				}
				
			}
		});
		
		botonCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contrase�a.setText("");
				contrase�a.requestFocus();
			}
		});;
		
		
		
	}
	

}
