// Desarrollador: Sergio Jim�nez R.
package es.edoras.warbot;

public class Persona {
	
	// ATRIBUTOS
	private String nombre;
	private int asesinatos;
	private boolean vivo;
	
	// CONSTRUCTOR
	public Persona(String nombre) {
		this.nombre = nombre;
		this.asesinatos = 0;
		this.vivo = true;
	}
	
	// FUNCI�N OPCIONAL: INCREMENTAR ASESINATOS
	// Utilizar el n�mero de asesinatos supone un sistema de porcentajes con la suma de asesinatos y Math.random. (0,1).
	public void incrementarAsesinato() {
		this.asesinatos += 1;
	}
	
	// GETTERS
	public String getNombre() {
		return this.nombre;
	}
	public int getAsesinatos() {
		return this.asesinatos;
	}
	public boolean getVivo() {
		return this.vivo;
	}
	
	// SETTERS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setAsesinatos(int asesinatos) {
		this.asesinatos = asesinatos;
	}
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	
}
