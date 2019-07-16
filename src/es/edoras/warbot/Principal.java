// Desarrollador: Sergio Jim�nez R.
package es.edoras.warbot;

import java.io.*;

public class Principal implements Ajustes {
	
	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File("Tweets.txt"));
		
		Comunidad c = new Comunidad();
		rellenarComunidad(c);
		
		pw.println("¡Que comience la guerra!");
		pw.println("Participantes: "+c.listadoVivos());
		
		for(int i = 0; i < nombres.length && nombres.length - c.getnMuertos() > 1; i++) {
			pw.println(c.matar(c.getVPersonas()[c.encontrarVivo()], c.getVPersonas()[c.encontrarVivo()]));
			if(i < nombres.length - 2) {
				pw.println("Vivos: "+c.listadoVivos());
			} else {
				pw.println("GANADOR: "+c.listadoVivos());
			}
		}
		if(SuicidiosActivados) {
			pw.println("Se ha/n producido "+c.getSuicidios()+" suicidio/s.");
		}
		pw.println("Fin.");
		pw.close();
	}
	
	public static void rellenarComunidad(Comunidad c) throws FileNotFoundException {
		for(int i = 0; i < nombres.length; i++)
			c.addPersona(new Persona(nombres[i]));
	}
	

}
