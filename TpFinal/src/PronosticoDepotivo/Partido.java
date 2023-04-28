package PronosticoDepotivo;

public class Partido {
	
	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEquipo1;
	private int golesEquipo2;
	private int nro;
	
	public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2, int nro) {
		this.equipo1=equipo1;
		this.equipo2=equipo2;
		this.golesEquipo1=golesEquipo1;
		this.golesEquipo2=golesEquipo2;
		this.nro=nro;
	}
	
	public ResultadoEnum resultado(Equipo equipo) {
		if(equipo==equipo1) {
			return resultadoEquipo1(golesEquipo1,golesEquipo2);
		}
		else {
			return resultadoEquipo1(golesEquipo2,golesEquipo1);
		}
	}
	
	
	private ResultadoEnum resultadoEquipo1(int golesEquipo1, int golesEquipo2) {
		if(golesEquipo1>golesEquipo2) {
			return ResultadoEnum.GANADOR;
		}
		else {
			if(golesEquipo1==golesEquipo2) {
				return ResultadoEnum.EMPATE;
			}
			else {
				return ResultadoEnum.PERDEDOR;
			}
		}
	}

	public boolean estaEquipo(Equipo equipo) {
		if (equipo1==equipo || equipo2==equipo) return true;
		else return false;
	}

}
