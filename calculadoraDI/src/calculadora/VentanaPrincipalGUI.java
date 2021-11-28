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
	
	// Creamos un patrón para el formato decimal de los números, de manera que salgan 4 decimales. El resto de cifras decimales se redondearán hacia arriba
	DecimalFormat formato = new DecimalFormat("#.####");
	
	public VentanaPrincipalGUI ventana;
	
	public VentanaPrincipalGUI() {
		//salir de la aplicación
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//damos el tamaño a la ventana
		setSize(500, 500);
		//coloca la pantalla en el centro
		setLocationRelativeTo(null);
		//desactivamos el organizador
		setLayout(null);
		//método para inicializar los componentes 
		inicializarComponentes();
		//el usuario no la puede redimensionar
		setResizable(false);
		//escribimos el texto que va a aparecer en nuestra calculadora de título
		setTitle("                CALCULADORA DI.");
		setIconImage(Toolkit.getDefaultToolkit().getImage("calcu.png"));
		
		//esta instrucción tiene que ir la última para evitar que de problemas
		setVisible(true);
		
	}
	
	private void inicializarComponentes() {
		
		
		//le damos un color de fondo
		getContentPane().setBackground(new Color(0,3,2 ));
		
		//Lo que hay que hacer es crearlas, ubicarlas y añadirlas a la ventana
		
		//creamos la etiqueta 
		etiqueta = new JLabel("Número 1 :");
		
		etiqueta.setBounds(250,100,100,40);
		etiqueta.setFont(new Font ("Dialog", Font.BOLD, 16));
		etiqueta.setForeground(new Color(196, 231, 229 ));
		
		
		//importante añadirla porque sino no aparecerá
		add(etiqueta);
		
		// El componente cajaTexto se corresponde con el primer número de entrada
		
		//creamos la caja de texto
		cajaTexto = new JTextField();
		cajaTexto.setBounds(350,100,100,40);
		
		cajaTexto.requestFocus();
		//Le quitamos el borde
		cajaTexto.setBorder(null);
		cajaTexto.setFont(new Font("Arial",Font.BOLD, 18));
		cajaTexto.setForeground(new Color(2,2,2 ));
		add(cajaTexto);
		
		etiqueta2 = new JLabel("Número 2:");
		etiqueta2.setFont(new Font ("Dialog", Font.BOLD, 16));
		etiqueta2.setBounds(250,200,100,40);
		etiqueta2.setForeground(new Color(196, 231, 229 ));
		
				
		add(etiqueta2);
				
		// El componente cajaTexto se corresponde con el segundo número de entrada
		
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
		//método al que se le pasan las coordenadas y el ancho y el alto
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
				
				//en esta variable metemos la suma de lo que pasen en las cajas de texto y lo sacamos en el resultado
				Double suma = Double.parseDouble(cajaTexto.getText())+ Double.parseDouble(cajaTexto2.getText());
				etiqueta3.setText("Resultado : "+ formato.format(suma));
				
			}
			
			
		});
		
		
		boton2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Double resta = Double.parseDouble(cajaTexto.getText()) - Double.parseDouble(cajaTexto2.getText());
				etiqueta3.setText("Resultado : "+ formato.format(resta));
				
			}
			
			
		});
		
		
		
		boton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Double multiplicacion = Double.parseDouble(cajaTexto.getText()) * Double.parseDouble(cajaTexto2.getText());
				etiqueta3.setText("Resultado : "+ formato.format(multiplicacion));				
			}
		});

			

		boton4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Double division = Double.parseDouble(cajaTexto.getText()) / Integer.parseInt(cajaTexto2.getText());
				etiqueta3.setText("Resultado : "+ formato.format(division));
				
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
				setTitle(boton6.getText());
				// Cuando se hace click en el botón de raíz cuadrada, se crea un objeto de tipo
				// ventanaLogin, por lo que esta se creará. Se le pasan los valores de la caja de texto del número1
				// y de la etiqueta del resultado, para que puedan intercambiarse los valores entre las dos ventanas
				// La operación de raíz cúbica se realizará en la otra ventana con los valores que le llegen a trvés de estos parámetros
				// Y la ventana principal recibirá el resultado desde la ventana de login, una vez haya hecho la operación
				VentanaLogin ventanaLogin = new VentanaLogin(cajaTexto, etiqueta3);
			}		
		});
		
	
	}
	
}
