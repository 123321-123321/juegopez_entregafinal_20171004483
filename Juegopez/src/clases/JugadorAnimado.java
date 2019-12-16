package clases;

import java.util.HashMap;

import javax.swing.JOptionPane;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class JugadorAnimado extends Padre{
	
	private HashMap<String, Animacion> animaciones;
	public JugadorAnimado(int x, int y, String indiceImagen, int velocidad, String animacionActual) {
		super(x,y,indiceImagen,velocidad,animacionActual);
		
		inicializarAnimaciones();
	}
	

	//Obtener las coordenas del fragmento de la imagen a pintar
	public void actualizarAnimacion(double t) {
		Rectangle coordenadasActuales = this.animaciones.get(animacionActual).calcularFrame(t);
		super.xImagen = (int)coordenadasActuales.getX();
		super.yImagen = (int)coordenadasActuales.getY();
		super.anchoImagen = (int)coordenadasActuales.getWidth();
		super.altoImagen = (int)coordenadasActuales.getHeight();
	}
	
	public void mover(){
		
		
		if (Juego.derecha) {
		if(super.x<890)
			super.x+=velocidad;
		
		
		}
		
		if (Juego.izquierda) {
			if(super.x>0)
			super.x-=velocidad;
		}
		
		if (Juego.arriba) {
			if(super.y>-10)
			super.y-=velocidad;
			
		}
		
		if (Juego.abajo) {
		if(super.y<530)
			super.y+=velocidad;
			
		}
	}
	
	public void pintar(GraphicsContext graficos) {
		
		super.pintar(graficos);

	}
	
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(super.x, super.y,super.anchoImagen, super.altoImagen);
	}
	
	public void inicializarAnimaciones() {
			animaciones = new HashMap<String, Animacion>();
	
			
			Rectangle coordenadasDescanso[] = {
					new Rectangle(48, 281, 92,68),
					new Rectangle(146,269, 101,86),
					new Rectangle(252,281, 102,66),
					new Rectangle(354,280, 101,75)
			};
			Animacion animacionDescanso = new Animacion("descanso",coordenadasDescanso,0.2);
			animaciones.put("descanso",animacionDescanso);
	}
	
	public void verificarColisiones(Item item) {
		if (this.obtenerRectangulo().intersects(item.obtenerRectangulo().getBoundsInLocal())) {
				System.out.println("Estan colisionando");
				if (!item.isCapturado())
					super.puntuacion++;
				item.setCapturado(true);				
		}
	}
		
		
	public void verificarColisiones(Enemigos enemigo) {
		if (this.obtenerRectangulo().intersects(enemigo.obtenerRectangulo().getBoundsInLocal())) {
		Juego.parar=false;
			System.out.println("estan colisionando");
		
				//if (!enemigo.isCapturado())
	   
					// 	enemigo.setCapturado(true);				
		}
		
	}					
			
		
		
		
		
	}
	
