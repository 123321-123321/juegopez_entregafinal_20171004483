package clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;

public class Tile extends Padre {
	
	
	public Tile(int x, int y, int anchoImagen, int altoImagen, int xImagen, int yImagen, String indiceImagen,
			
		int velocidad) {
		super( x,  y,  anchoImagen,  altoImagen,  xImagen,  yImagen, indiceImagen,
				
				 velocidad);
		
		
	}
	
	public Tile(int tipoTile,int x, int y, String indiceImagen, int velocidad){
		super(x,y);
		super.x = x;
		super.y = y;
		super.indiceImagen = indiceImagen;
		super.velocidad = velocidad;
		//this.invertir = invertir;
		switch(tipoTile){
			case 1:
				super.altoImagen = 200;
				super.anchoImagen = 249;
				super.xImagen = 0;
				super.yImagen = 0;
			break;
			case 2:
				super.altoImagen = 200;
				super.anchoImagen = 249;
				super.xImagen = 249;
				super.yImagen = 0;
			break;
			case 3:
				super.altoImagen = 200;
				super.anchoImagen = 249;
				super.xImagen =498;
				super.yImagen = 0;
			break;
			case 4:
				super.altoImagen = 200;
				super.anchoImagen = 249;
				super.xImagen =747;
				super.yImagen = 0;
			break;
			case 5:
				super.altoImagen = 200;
				super.anchoImagen = 249;
				super.xImagen =0;
				super.yImagen = 200;
			break;
			case 6:
				super.altoImagen = 200;
				super.anchoImagen = 249;
				super.xImagen = 249;
				super.yImagen = 200;
			break;
			case 7:
				super.altoImagen = 200;
				super.anchoImagen = 249;
				super.xImagen =498;
				super.yImagen = 200;
			break;
			case 8:
				super.altoImagen = 200;
				super.anchoImagen = 249;
				super.xImagen =747;
				super.yImagen = 200;
			break;
			case 9:
				super.altoImagen = 200;
				super.anchoImagen = 249;
				super.xImagen =0;
				super.yImagen = 400;
			break;
			case 10:
				super.altoImagen = 200;
				super.anchoImagen = 249;
				super.xImagen = 249;
				super.yImagen = 400;
			break;
			case 11:
				super.altoImagen = 200;
				super.anchoImagen = 249;
				super.xImagen =498;
				super.yImagen = 400;
			break;
			case 12:
				super.altoImagen = 200;
				super.anchoImagen = 249;
				super.xImagen =747;
				super.yImagen = 400;
		
		
		}
	}
	
	public void pintar(GraphicsContext graficos) {
		super.pintar1(graficos);
			
	
		
	}
	
}

