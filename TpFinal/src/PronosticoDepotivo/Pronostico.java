package PronosticoDepotivo;

public class Pronostico {
	
	private Partido partido;
	private Equipo equipo;
	private ResultadoEnum resultado;
	private Persona persona;
	
	public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado, Persona persona) {
		this.partido=partido;
		this.equipo=equipo;
		this.resultado=resultado;
		this.persona=persona;
	}
	
	public int puntos(Persona persona, int suma) {
		ResultadoEnum resultadoPart = partido.resultado(equipo);
		int pts=0;
		if ( resultado==resultadoPart && this.persona==persona) pts=suma;
		return pts;
	}
	
	public Persona getPersona() {
		return persona;
	}

}
