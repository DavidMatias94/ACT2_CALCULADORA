package calculadora;

import java.awt.event.ActionEvent;

//import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Toolkit;

//import javafx.scene.image.Image;

import java.awt.Color;
import java.awt.Font;

public class VentanaPrincipalGUI extends JFrame {
	
	//creamos los botones, las etiquetas y las cajas de texto
	
	private JTextField cajaTexto, cajaTexto2;
	
	private JButton boton1, boton2, boton3,boton4, boton5, boton6;
	
	private JLabel etiqueta, etiqueta2, etiqueta3,etiqueta4, etiqueta5;
	
	// Creamos un patr?n para el formato decimal de los n?meros, de manera que salgan 4 decimales. El resto de cifras decimales se redondear?n hacia arriba
	DecimalFormat formato = new DecimalFormat("#.####");
	
	public VentanaPrincipalGUI ventana;
	
	public VentanaPrincipalGUI() {
		//salir de la aplicaci?n
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//damos el tama?o a la ventana
		setSize(500, 500);
		//coloca la pantalla en el centro
		setLocationRelativeTo(null);
		//desactivamos el organizador
		setLayout(null);
		//m?todo para inicializar los componentes 
		inicializarComponentes();
		//el usuario no la puede redimensionar
		setResizable(false);
		//escribimos el texto que va a aparecer en nuestra calculadora de t?tulo
		setTitle("                CALCULADORA DI.");
		setIconImage(Toolkit.getDefaultToolkit().getImage("calcu.png"));
		
		//esta instrucci?n tiene que ir la ?ltima para evitar que de problemas
		setVisible(true);
		
	}
	
	private void inicializarComponentes() {
		
		
		//le damos un color de fondo
		getContentPane().setBackground(new Color(0,3,2 ));
		
		//Lo que hay que hacer es crearlas, ubicarlas y a?adirlas a la ventana
		
		//creamos la etiqueta 
		etiqueta = new JLabel("N?mero 1 :");
		
		etiqueta.setBounds(250,100,100,40);
		etiqueta.setFont(new Font ("Dialog", Font.BOLD, 16));
		etiqueta.setForeground(new Color(196, 231, 229 ));
		
		
		//importante a?adirla porque sino no aparecer?
		add(etiqueta);
		
		// El componente cajaTexto se corresponde con el primer n?mero de entrada
		
		//creamos la caja de texto
		cajaTexto = new JTextField();
		cajaTexto.setBounds(350,100,100,40);
		
		cajaTexto.requestFocus();
		//Le quitamos el borde
		cajaTexto.setBorder(null);
		cajaTexto.setFont(new Font("Arial",Font.BOLD, 18));
		cajaTexto.setForeground(new Color(2,2,2 ));
		add(cajaTexto);
		
		etiqueta2 = new JLabel("N?mero 2:");
		etiqueta2.setFont(new Font ("Dialog", Font.BOLD, 16));
		etiqueta2.setBounds(250,200,100,40);
		etiqueta2.setForeground(new Color(196, 231, 229 ));
		
				
		add(etiqueta2);
				
		// El componente cajaTexto se corresponde con el segundo n?mero de entrada
		
		cajaTexto2 = new JTextField();
		cajaTexto2.setBounds(350,200,100,40);
		cajaTexto2.setBorder(null);
		cajaTexto2.setFont(new Font("Arial",Font.BOLD, 18));
		
		
				
		add(cajaTexto2);
		
		
		etiqueta3 = new JLabel("Resultado : ");
		etiqueta3.setBounds(30,400,200,60);
		etiqueta3.setFont(new Font ("Dialog", Font.BOLD,18 ));
		etiqueta3.setForeground(new Color(196, 231, 229));	
		add(etiqueta3);
		
		
		etiqueta4 = new JLabel(new ImageIcon("avengers.jfif"));
		etiqueta4.setBounds(335,300,150,150);
		add(etiqueta4);
		
	
		boton1 = new JButton("1");
		//m?todo al que se le pasan las coordenadas y el ancho y el alto
		boton1.setBounds(20, 50, 106, 95);
		boton1.setText("Sumar");
		
		boton2 = new JButton("2");
		boton2.setBounds(130, 50, 106, 95);
		boton2.setText("Restar");
		
		boton3 = new JButton("3");
		boton3.setBounds(20, 150, 106, 95);
		boton3.setText("Multiplicar");
		
		boton4 = new JButton("4");
		boton4.setBounds(130, 150, 106, 95);
		boton4.setText("Dividir");
		
		boton5 = new JButton("5");
		boton5.setBounds(20, 250, 106, 95);
		boton5.setText("Raiz 2");
		
		boton6 = new JButton("6");
		boton6.setBounds(130, 250, 106, 95);
		boton6.setText("Raiz 3");
		
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
		add(boton5);
		add(boton6);
		
	
		//le damos funcionalidad a los botones
		
		
		boton1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				 boolean response= true ;
				    
				    try {
				    	
				    	//si la caja de texto viene vac?a haremos una excepci?n para avisar de que tienen que introducir un n?mero
				        if (cajaTexto.getText().equals("")) {
				        	
				            response = false;
				            etiqueta3.setText("Introduzca N?");
				            
				        }else if  (cajaTexto2.getText().equals("")) {
				        	
				        	response = false;
				        	etiqueta3.setText("Introduzca N?");
				        }else {
				        	
				        	Double suma =  (Double.parseDouble(cajaTexto.getText()))+ (Double.parseDouble(cajaTexto2.getText()));
							etiqueta3.setText("Resultado : "+ suma);
							response = true;
				        }
				    }
				    catch (Exception e1) {
				    	
				    	etiqueta3.setText("Introduzca N?");
				    }
				  
				
			}
			
			
		});
		
		
		boton2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean response= true ;

				try {
					if (cajaTexto.getText().equals("")) {
						response = false;
						
						etiqueta3.setText("Introduzca N?");
						
					}else if  (cajaTexto2.getText().equals("")) {

						response = false;
						etiqueta3.setText("Introduzca N?");

					}else {

						Double resta = (Double.parseDouble(cajaTexto.getText())) - (Double.parseDouble(cajaTexto2.getText()));
						etiqueta3.setText("Resultado : "+ resta);

						response = true;
					}
				}
				catch (Exception e1) {
					
					etiqueta3.setText("Introduzca N?");

				}
			  
			}
			
			
		});
		
		
		
		boton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean response= true ;

				try {
					if (cajaTexto.getText().equals("")) {
						response = false;
						etiqueta3.setText("Introduzca N?");
						
					}else if  (cajaTexto2.getText().equals("")) {

						response = false;
						etiqueta3.setText("Introduzca N?");

					}else {

						Double multiplicacion = Double.parseDouble(cajaTexto.getText()) * Double.parseDouble(cajaTexto2.getText());
						etiqueta3.setText("Resultado : "+ formato.format(multiplicacion));	

						response = true;
					}
				}
				catch (Exception e1) {
					
					etiqueta3.setText("Introduzca N?");

				}
				
				
							
			}
		});

			

		
		
		
		
		
		boton4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				boolean response= true ;

				try {
					if (cajaTexto.getText().equals("")) {
						response = false;
						etiqueta3.setText("Introduzca N?");
						
					}else if  (cajaTexto2.getText().equals("")) {

						response = false;
						etiqueta3.setText("Introduzca N?");

					}else {

						Double division = Double.parseDouble(cajaTexto.getText()) / Integer.parseInt(cajaTexto2.getText());
						etiqueta3.setText("Resultado : "+ formato.format(division));

						response = true;
					}
				}
				catch (Exception e1) {
					
					etiqueta3.setText("Introduzca N?");

				}
			
			}
			
			
		});
		

		
		
		
		boton5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(boton5, "Funcionalidad no disponible");
				
			}
			
			
		});
		

		boton6.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				boolean response= true ;

				try {
					if (cajaTexto.getText().equals("")) {
						response = false;
						
						etiqueta3.setText("Introduzca N?");
						
					}else if  (cajaTexto2.getText().equals("")) {

						response = false;
						etiqueta3.setText("Introduzca N?");

					}else {

						setTitle(boton6.getText());
						// Cuando se hace click en el bot?n de ra?z cuadrada, se crea un objeto de tipo
						// ventanaLogin, por lo que esta se crear?. Se le pasan los valores de la caja de texto del n?mero1
						// y de la etiqueta del resultado, para que puedan intercambiarse los valores entre las dos ventanas
						// La operaci?n de ra?z c?bica se realizar? en la otra ventana con los valores que le llegen a trv?s de estos par?metros
						// Y la ventana principal recibir? el resultado desde la ventana de login, una vez haya hecho la operaci?n
						VentanaLogin ventanaLogin = new VentanaLogin(cajaTexto, etiqueta3);

						response = true;
					}
				}
				catch (Exception e1) {
					
					etiqueta3.setText("Introduzca N?");

				}
				
				
			}		
		});
		
	
	}
	
}
