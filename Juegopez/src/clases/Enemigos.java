package clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Enemigos extends Padre {
	
	
	
	private boolean capturado;
	private int invertir=1;
	
	public Enemigos(int x, int y, int anchoImagen, int altoImagen, int xImagen, int yImagen, String indiceImagen,
			int velocidad) {
		super( x,  y,  anchoImagen,  altoImagen,  xImagen,  yImagen, indiceImagen,
				
				 velocidad);
		
	}
	
	public Enemigos(int tipoTile,int x, int y,String indiceImagen, int velocidad){
		super(x,y,indiceImagen,velocidad);
		super.x = x;
		super.y = y;
		super.indiceImagen = indiceImagen;
		super.velocidad = velocidad;
		
		switch(tipoTile){
			case 1:
				super.altoImagen = 87;
				super.anchoImagen = 154;
				super.xImagen = 139;
				super.yImagen = 12;
			break;
		
			case 2:
				super.altoImagen = 46;
				super.anchoImagen = 92;
				super.xImagen = 9;
				super.yImagen = 12;
			break;
			case 3:
				super.altoImagen = 74;
				super.anchoImagen = 64;
				super.xImagen = 193;
				super.yImagen = 101;
			break;
		
		}
	}

	public void pintar(GraphicsContext graficos) {
		
		
		
		super.pintar2(graficos);
		
	}
	public Rectangle obtenerRectangulo() {
		return new Rectangle(super.x, super.y,28, 35);
	
}
	public boolean isCapturado() {
		return capturado;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
}

