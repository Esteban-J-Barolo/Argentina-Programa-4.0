package PronosticoDepotivo;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
	
	private String nro;
	private List<Pronostico> pronosticos;
	
	public Ronda(String nro) {
		this.nro=nro;
		this.pronosticos = new ArrayList<Pronostico>();
	}
	
	public void agregarPronostico(Pronostico pronostico) {
		this.pronosticos.add(pronostico);
	}
	
	public int puntos(Persona persona, int suma) {
		int pts=0;
		for(Pronostico pronostico : pronosticos) {
			pts += pronostico.puntos( persona, suma);
		}
		return pts;
	}
	
	public ArrayList<Persona> getParticipantes() {
		ArrayList<Persona> personas = new ArrayList<Persona>();
		for(Pronostico pronostico : pronosticos)
			if ( !personas.contains(pronostico.getPersona()) ) personas.add(pronostico.getPersona());
		return personas;
	}
	
	public String getNro() {
		return nro;
	}

}
