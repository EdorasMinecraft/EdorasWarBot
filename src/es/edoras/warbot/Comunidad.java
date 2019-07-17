// Desarrollador: Sergio Jiménez R.
package es.edoras.warbot;

import java.io.FileNotFoundException;

public class Comunidad implements ValoresPredefinidos {
	
	private Persona[] vpersonas;
	private int nPersonas;
	private int nMuertos;
	private int suicidio;
	
	public Comunidad() throws FileNotFoundException {
		this.vpersonas = new Persona[nombres.length];
		this.nPersonas = 0;
		this.nMuertos = 0;
		this.suicidio = 0;
	}
	
	public void addPersona(Persona p) {
		if(nPersonas < vpersonas.length) {
			vpersonas[nPersonas] = p;
			nPersonas++;
		}
	}
	
	private int encontrarVivo() {
		int[] vivos = new int[vpersonas.length - nMuertos];
		for(int i = 0, pVivo = 0; i < vpersonas.length && pVivo < vivos.length; i++) {
			if(vpersonas[i].getVivo()) {
				vivos[pVivo] = i;
				pVivo++;
			}
		}
		return vivos[(int)(Math.random()*(vivos.length))];
	}
	
	public String matar(Persona pv, Persona pm) {
		
		if(SuicidiosActivados && pv == pm)
			suicidio++;
		else
			while(pv == pm)
				pm = vpersonas[encontrarVivo()];
		
		pm.setVivo(false);
		nMuertos += 1;
		pv.incrementarAsesinato();
		if(pv.getNombre() == pm.getNombre()){
			return pv.getNombre() + " vió la situación demasiado cruda y se ha suicidado.\n";
		} else {
			SendRcon.SendCommand(pv.getNombre(), pm.getNombre());
			return pv.getNombre() + " ha matado a " + pm.getNombre() + ".\n";
		}
	}
	
	public int getnMuertos() {
		return nMuertos;
	}
	
	public Persona[] getVPersonas() {
		return vpersonas;
	}
	
	public int getSuicidios() {
		return suicidio;
	}
	
	public String listadoVivos() {
		int[] vivos = new int[vpersonas.length - nMuertos];
		for(int i = 0, pVivo = 0; i < vpersonas.length && pVivo < vivos.length; i++) {
			if(vpersonas[i].getVivo()) {
				vivos[pVivo] = i;
				pVivo++;
			}
		}
		String lista = "";
		for(int i = 0; i < vivos.length; i++) {
			if(i == vivos.length-1) {
				lista += vpersonas[vivos[i]].getNombre()+".";
			} else {
				lista += vpersonas[vivos[i]].getNombre()+", ";
			}
		}
		
		return lista;
	}
	
}
