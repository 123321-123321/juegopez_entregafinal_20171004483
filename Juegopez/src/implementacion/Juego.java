package implementacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import clases.Enemigos;

import clases.Item;
import clases.JugadorAnimado;
import clases.Padre;
import clases.Tile;
import clases.puntuacionesjugador;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Juego extends Application{
	private Scene escena;
	private Group root;
	private Canvas canvas;
	private GraphicsContext graficos;
	private int puntuacion = 0;
	//private Jugador jugador;
	private JugadorAnimado jugadorAnimado;
	public static boolean derecha=false;
	public static boolean izquierda=false;
	public static boolean arriba=false;
	public static boolean abajo=false;
	public static HashMap<String, Image> imagenes; //Shift+Ctrl+O
	public  static boolean parar=true;
	

	public void guardarRegistroArchivo() {
		
		
		puntuacionesjugador p= new puntuacionesjugador(JOptionPane.showInputDialog("ingrese su nombre"),Integer.parseInt(JOptionPane.showInputDialog("ingrese su edad")),Padre.puntuacion);
		try {
			BufferedWriter archivo = new BufferedWriter(new FileWriter("usuarios.csv",true));
			archivo.write(p.tocsv());
			archivo.flush();
			archivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null,"puntuacion realizada:"+Padre.puntuacion);
		System.exit(0);
	}
	
	public void leerInformacionArchivo(){
		
		try {
			String union="";
			BufferedReader flujo = new BufferedReader(new FileReader("usuarios.csv"));
			String linea="";
			while ((linea = flujo.readLine())!=null) {
				
				String partes[] = linea.split(",");
				
				 union=union+partes[0]+":"+partes[2]+"\n";
					
			
					
				
			}
			JOptionPane.showMessageDialog(null,"puntuaciones:"+union);	
			flujo.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	//private ArrayList<Image> imagenes;
	private ArrayList<Item> items;
	private ArrayList<Tile> tiles;
	//nuevo
	private ArrayList<Enemigos> enemix;
	//nuevo
	private int[][] mapa = {
			{1,5,9,0,0,0,0,0},
			{2,6,10,0,0,0,0,0},
			{3,7,11,0,0,0,0,0},
			{4,8,12,0,0,0,0,0},
			{1,5,9,0,0,0,0,0},
			{2,6,10,0,0,0,0,0},
			{3,7,11,0,0,0,0,0},
			{4,8,12,0,0,0,0,0},
			{1,5,9,0,0,0,0,0},
			{2,6,10,0,0,0,0,0},
			{3,7,11,0,0,0,0,0},
			{4,8,12,0,0,0,0,0},
			{1,5,9,0,0,0,0,0},
			{2,6,10,0,0,0,0,0},
			{3,7,11,0,0,0,0,0},
			{4,8,12,0,0,0,0,0},
			{1,5,9,0,0,0,0,0},
			{2,6,10,0,0,0,0,0},
			{3,7,11,0,0,0,0,0},
			{4,8,12,0,0,0,0,0},
			{1,5,9,0,0,0,0,0},
			{2,6,10,0,0,0,0,0},
			{3,7,11,0,0,0,0,0},
			{4,8,12,0,0,0,0,0},
			{1,5,9,0,0,0,0,0},
			{2,6,10,0,0,0,0,0},
			{3,7,11,0,0,0,0,0},
			{4,8,12,0,0,0,0,0},
			{1,5,9,0,0,0,0,0},
			{2,6,10,0,0,0,0,0},
			{3,7,11,0,0,0,0,0},
			{4,8,12,0,0,0,0,0},
			{1,5,9,0,0,0,0,0},
			{2,6,10,0,0,0,0,0},
			{3,7,11,0,0,0,0,0},
			{4,8,12,0,0,0,0,0},
			{1,5,9,0,0,0,0,0},
			{2,6,10,0,0,0,0,0},
			{3,7,11,0,0,0,0,0},
			{4,8,12,0,0,0,0,0},
			{1,5,9,0,0,0,0,0},
			{2,6,10,0,0,0,0,0},
			{3,7,11,0,0,0,0,0},
			{4,8,12,0,0,0,0,0},
			{1,5,9,0,0,0,0,0},
			{2,6,10,0,0,0,0,0},
			{3,7,11,0,0,0,0,0},
			{4,8,12,0,0,0,0,0},
			{1,5,9,0,0,0,0,0},
			{2,6,10,0,0,0,0,0},
			{3,7,11,0,0,0,0,0},
			{4,8,12,0,0,0,0,0},
			{1,5,9,0,0,0,0,0},
			{2,6,10,0,0,0,0,0},
			{3,7,11,0,0,0,0,0},
			{4,8,12,0,0,0,0,0},
			{1,5,9,0,0,0,0,0},
			{2,6,10,0,0,0,0,0},
			{3,7,11,0,0,0,0,0},
			{4,8,12,0,0,0,0,0},
			{1,5,9,0,0,0,0,0},
			{2,6,10,0,0,0,0,0},
			{3,7,11,0,0,0,0,0},
			{4,8,12,0,0,0,0,0},
			{1,5,9,0,0,0,0,0},
			{2,6,10,0,0,0,0,0},
			{3,7,11,0,0,0,0,0},
			{4,8,12,0,0,0,0,0},
			{1,5,9,0,0,0,0,0},
			{2,6,10,0,0,0,0,0},
			{3,7,11,0,0,0,0,0},
			{4,8,12,0,0,0,0,0},
			{1,5,9,0,0,0,0,0},
			{2,6,10,0,0,0,0,0},
			{3,7,11,0,0,0,0,0},
			{4,8,12,0,0,0,0,0},
			
	};
	
//nuevo
	private int[][] mapaenemigo = {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{2,2,2,0,0,0,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,3,0,0,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{1,1,0,0,2,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,0,0,2,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{1,1,0,0,0,0,0},
			{0,0,0,0,0,2,2},
			{1,0,0,0,2,0,0},
			{0,0,0,0,0,0,0},
			{3,3,3,3,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{2,2,2,0,0,0,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,3,0,0,2,2},
			{0,0,0,0,0,0,0},
			{0,0,2,0,0,0,0},
			{1,1,0,0,3,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,0,0,2,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{1,1,0,0,0,0,0},
			{0,0,0,0,0,2,2},
			{1,0,0,0,2,0,0},
			{0,0,0,0,0,0,0},
			{1,1,1,1,1,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{2,2,2,0,0,0,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,3,0,0,2,2},
			{0,0,0,0,0,0,0},
			{0,0,2,0,0,0,0},
			{1,1,0,0,3,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,0,0,2,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{1,1,0,0,0,0,0},
			{0,0,0,0,0,2,2},
			{1,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,3,3,3,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{2,2,2,0,0,0,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,3,0,0,2,2},
			{0,0,0,0,0,0,0},
			{0,0,2,0,0,0,0},
			{1,1,0,0,3,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,0,0,2,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{1,1,0,0,0,0,0},
			{0,0,0,0,0,2,2},
			{1,0,0,0,2,0,0},
			{0,0,0,0,0,0,0},
			{1,3,1,3,3,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{2,2,2,0,0,0,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,3,0,0,2,2},
			{0,0,0,0,0,0,0},
			{0,0,2,0,0,0,0},
			{1,1,0,0,3,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,0,0,2,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{1,1,0,0,0,0,0},
			{0,0,0,0,0,2,2},
			{1,0,0,0,2,0,0},
			{0,0,0,0,0,0,0},
			{1,1,1,1,1,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{2,2,2,0,0,0,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,3,0,0,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{1,1,0,0,2,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,0,0,2,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{1,1,0,0,0,0,0},
			{0,0,0,0,0,2,2},
			{1,0,0,0,2,0,0},
			{0,0,0,0,0,0,0},
			{3,3,3,3,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{2,2,2,0,0,0,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,3,0,0,2,2},
			{0,0,0,0,0,0,0},
			{0,0,2,0,0,0,0},
			{1,1,0,0,3,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,0,0,2,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{1,1,0,0,0,0,0},
			{0,0,0,0,0,2,2},
			{1,0,0,0,2,0,0},
			{0,0,0,0,0,0,0},
			{1,1,1,1,1,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{2,2,2,0,0,0,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,3,0,0,2,2},
			{0,0,0,0,0,0,0},
			{0,0,2,0,0,0,0},
			{1,1,0,0,3,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,0,0,2,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{1,1,0,0,0,0,0},
			{0,0,0,0,0,2,2},
			{1,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,3,3,3,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{2,2,2,0,0,0,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,3,0,0,2,2},
			{0,0,0,0,0,0,0},
			{0,0,2,0,0,0,0},
			{1,1,0,0,3,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,0,0,2,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{1,1,0,0,0,0,0},
			{0,0,0,0,0,2,2},
			{1,0,0,0,2,0,0},
			{0,0,0,0,0,0,0},
			{1,3,1,3,3,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{2,2,2,0,0,0,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,3,0,0,2,2},
			{0,0,0,0,0,0,0},
			{0,0,2,0,0,0,0},
			{1,1,0,0,3,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,0,0,2,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{1,1,0,0,0,0,0},
			{0,0,0,0,0,2,2},
			{1,0,0,0,2,0,0},
			{0,0,0,0,0,0,0},
			{1,1,1,1,1,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{2,2,2,0,0,0,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,3,0,0,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{1,1,0,0,2,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,0,0,2,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{1,1,0,0,0,0,0},
			{0,0,0,0,0,2,2},
			{1,0,0,0,2,0,0},
			{0,0,0,0,0,0,0},
			{3,3,3,3,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{2,2,2,0,0,0,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,3,0,0,2,2},
			{0,0,0,0,0,0,0},
			{0,0,2,0,0,0,0},
			{1,1,0,0,3,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,0,0,2,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{1,1,0,0,0,0,0},
			{0,0,0,0,0,2,2},
			{1,0,0,0,2,0,0},
			{0,0,0,0,0,0,0},
			{1,1,1,1,1,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{2,2,2,0,0,0,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,3,0,0,2,2},
			{0,0,0,0,0,0,0},
			{0,0,2,0,0,0,0},
			{1,1,0,0,3,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{3,3,0,0,2,2,2},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{1,1,0,0,0,0,0},
			{0,0,0,0,0,2,2},
			{1,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
		
		
			
			
		};
	//nuevo
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ventana) throws Exception {
		inicializarComponentes();
		graficos = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		ventana.setScene(escena);
		ventana.setTitle("ES PA FUERA QUE VAS JOH");
		gestionarEventos();
		ventana.setResizable(false);
		ventana.show();
		cicloJuego();		
	}
	
	public void inicializarComponentes() {
		
		jugadorAnimado = new JugadorAnimado(50,200,"carro",1, "descanso");
		root = new Group();
		escena = new Scene(root,1000,600);
		canvas  = new Canvas(1200,600);
		imagenes = new HashMap<String,Image>();
	
		
		cargarImagenes();
		
		cargarTiles();
		cargaritems();
		cargarenemigos();
		leerInformacionArchivo();
	}
	
	public void cargarImagenes() {
	
		
		imagenes.put("tilemap", new Image("tilemapagua.jpg"));
		imagenes.put("carro", new Image("polopez.png"));
		imagenes.put("item", new Image("monedasitems4.png"));
		//imagenes.put("fondo1", new Image("fondo3.jpg"));
		imagenes.put("enemigos", new Image("pecesmalos.png"));
	}
	
 	 public void pintar() {
		graficos.setFill(Color.GREEN);
		graficos.fillRect(0, 0, 1200, 600);
		graficos.setFill(Color.WHITE);
		graficos.fillText("Puntuacion: " + puntuacion, 0, 0);
		
		
		
		for (int i=0;i<tiles.size();i++)
			tiles.get(i).pintar(graficos);
		
		for (int i=0;i<items.size();i++)
			items.get(i).pintar(graficos);
		//nuevo
		for (int i=0;i<enemix.size();i++)
			enemix.get(i).pintar(graficos);
		//nuevo
		
	jugadorAnimado.pintar(graficos);
		
	
		
	}
	
	public void cargarTiles() {
		tiles = new ArrayList<Tile>();
		for(int i=0; i<mapa.length; i++) {
			for(int j=0; j<mapa[i].length; j++) {
				if (mapa[i][j]!=0)
					tiles.add(new Tile(mapa[i][j],i*249, j*200, "tilemap",0));
			}
		}
		
		
		
	
	}
	

	public void cargaritems() {
		
		
		items =new ArrayList<Item>();
		items.add( new Item(4000,200,0,0,"item"));
		items.add( new Item(1000,400,0,0,"item"));
		items.add( new Item(2000,350,0,0,"item"));
		items.add( new Item(3000,300,0,0,"item"));
		items.add( new Item(4000,300,0,0,"item"));
		items.add( new Item(5000,300,0,0,"item"));
		items.add( new Item(6000,250,0,0,"item"));
		items.add( new Item(8500,300,0,0,"item"));
	}
	
	
	//nuevo
	public void cargarenemigos() {
		enemix = new ArrayList<Enemigos>();
		
		
		
	
		for(int i=0; i<mapaenemigo.length; i++) {
			for(int j=0; j<mapaenemigo[i].length; j++) {
				if (mapaenemigo[i][j]!=0)
					enemix.add(new Enemigos(mapaenemigo[i][j], i*152, j*88, "enemigos",0));
			}
		}
	
	}
	//nuevo
	
	public void gestionarEventos() {
		//Evento cuando se presiona una tecla
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evento) {
					//Aqui tengo que poner el codigo para identificar cuando se presiono una tecla
					switch (evento.getCode().toString()) {
						case "RIGHT": //derecha
							derecha=true;
							jugadorAnimado.setVelocidad(3);
							break;
						case "LEFT": //derecha
							
							izquierda=true;
							jugadorAnimado.setVelocidad(3);
						break;
						case "UP":
							arriba=true;
							jugadorAnimado.setVelocidad(3);
							break;
						case "DOWN":
							abajo=true;
							jugadorAnimado.setVelocidad(3);
							break;
						case "SPACE":
							jugadorAnimado.setVelocidad(10);
							
							break;
					}
			}			
		});
		
		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent evento) {
				//Aqui tengo que poner el codigo para identificar cuando se soltó una tecla
				switch (evento.getCode().toString()) {
				case "RIGHT": //derecha
					derecha=false;
					break;
				case "LEFT": //derecha
					izquierda=false;
				break;
				case "UP":
					arriba=false;
					break;
				case "DOWN":
					abajo=false;
					break;
				case "SPACE":
					jugadorAnimado.setVelocidad(1);
				
					break;
			}
				
			}
			
		});
		
	}
	
	public void cicloJuego() {
		
		long tiempoInicial = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {
			
			
			
			//Esta rutina simula un ciclo de 60FPS
			@Override
			public void handle(long tiempoActualNanoSegundos) {
				double t = (tiempoActualNanoSegundos - tiempoInicial) / 1000000000.0;
			
				if(parar==true) {
					
				pintar();
				actualizar(t);
				
				}else {
					
					 guardarRegistroArchivo();
				}
			}
			
		};
		animationTimer.start(); //Inicia el ciclo
	}
	
	public void actualizar(double t) {
		jugadorAnimado.mover();
		jugadorAnimado.actualizarAnimacion(t);
		
		for(int i=0;i<items.size();i++)
		jugadorAnimado.verificarColisiones(items.get(i));
		//nuevo
		for(int i=0;i<enemix.size();i++)
			jugadorAnimado.verificarColisiones(enemix.get(i));
		//nuevo
		
	}

}