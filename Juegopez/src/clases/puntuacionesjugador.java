package clases;

public class puntuacionesjugador {

	public String Nombre_jugador;
	public int edad;
	public String getNombre_jugador() {
		return Nombre_jugador;
	}

	public void setNombre_jugador(String nombre_jugador) {
		Nombre_jugador = nombre_jugador;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int puntos;
	
	public puntuacionesjugador() {}

	public puntuacionesjugador(String nombre_jugador, int edad, int puntos) {
		
		Nombre_jugador = nombre_jugador;
		this.edad = edad;
		this.puntos = puntos;
	}
	public String tocsv() {
		return   Nombre_jugador + ","  + edad +"," + puntos+"\n";
	}

	@Override
	public String toString() {
		return "puntuacionesjugador [Nombre_jugador=" + Nombre_jugador + ", edad=" + edad + ", puntos=" + puntos + "]";
	}
	
	
	
	
}
