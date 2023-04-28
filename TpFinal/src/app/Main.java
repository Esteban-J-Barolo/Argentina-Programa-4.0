package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import ExtraerDatos.Archivo;
import ExtraerDatos.BaseDeDatos;
import PronosticoDepotivo.Equipo;
import PronosticoDepotivo.Partido;
import PronosticoDepotivo.Persona;
import PronosticoDepotivo.Pronostico;
import PronosticoDepotivo.ResultadoEnum;
import PronosticoDepotivo.Ronda;

public class Main {
	
	private static Map<String,Equipo> equiposMap = new HashMap<String,Equipo>();
	private static Map<Integer,Partido> partidosMap = new HashMap<Integer,Partido>();
	private static HashSet<String> nombresEquipos = new HashSet<String>();
	private static Map<String,ArrayList<Pronostico>> pronosticosMap = new HashMap<String,ArrayList<Pronostico>>();
	private static Map<String,Persona> personasMap = new HashMap<String,Persona>();
	private static Map<String,Ronda> rondaMap = new HashMap<String,Ronda>();

	public static void main(String[] args) {
		
		cargarPartidosArchivo(Archivo.sacarDatos("C:\\Users\\Esteban\\Desktop\\Arg Prog\\TpFinal\\partidos.txt"));
		cargarPronosticosArchivo(Archivo.sacarDatos("C:\\Users\\Esteban\\Desktop\\Arg Prog\\TpFinal\\pronosticos.txt"));
		
		cargarPartidosBD();
		cargarPronosticosBD();
		
		cargarRondas();
		
		mostrarPuntaje();

		System.out.println("Fin");
		
		
	}
	
	private static void cargarPartidosArchivo(ArrayList<String[]> lineas) {
		for (String[] fila : lineas) {
			nombresEquipos.add(fila[1]);
			nombresEquipos.add(fila[4]);
		}
		for(String equipo : nombresEquipos) equiposMap.put(equipo,new Equipo(equipo));
		for (String[] fila : lineas) {
			rondaMap.put(fila[5], new Ronda(fila[5]));
			partidosMap.put( Integer.parseInt(fila[6]),new Partido(	equiposMap.get(fila[1]),
																	equiposMap.get(fila[4]),
																	Integer.parseInt(fila[2]), 
																	Integer.parseInt(fila[3]),
																	fila[6])
						);
		}
	}
	
	private static void cargarPronosticosArchivo(ArrayList<String[]> lineas) {
		HashSet<String> rondasSet = new HashSet<String>();
		HashSet<String> personaSet = new HashSet<String>();
		for (String[] fila : lineas) rondasSet.add(fila[8]);
		for (String[] fila : lineas) personaSet.add(fila[6]);
		for (String pers : personaSet) personasMap.put(pers, new Persona(pers));
		
		for (String rond : rondasSet) {
			pronosticosMap.put(rond, new ArrayList<Pronostico>());
			for (String[] fila : lineas) {
				if(rond.contentEquals(fila[8])) {
					pronosticosMap.get(rond).add( new Pronostico(	partidosMap.get(Integer.parseInt(fila[7])),
														equiposMap.get(fila[1]),
														resultado(fila[2],fila[3],fila[4]),
														personasMap.get(fila[6])
													)
									);
				}
			}
		}
	}
	private static ResultadoEnum resultado(String pos1,String pos2, String pos3) { //resultado equipo 1
		if(pos1.contentEquals("x")) {
			return ResultadoEnum.GANADOR;
		}
		else {
			if(pos2.contentEquals("x")) {
				return ResultadoEnum.EMPATE;
			}
			else {
				return ResultadoEnum.PERDEDOR;
			}
		}
	}
	
	private static void cargarPartidosBD() {
		BaseDeDatos bd = new BaseDeDatos();
		bd.registrar();
		bd.conectar();
		
		String consulta = "SELECT equipo1 FROM pronostico_deportivo.Partido \r\n"
						+ "UNION\r\n"
						+ "SELECT equipo2 FROM pronostico_deportivo.Partido;";
		
		ResultSet resp = bd.consultar(consulta);
		try {
			
			while(resp.next()) {
				equiposMap.put(resp.getString(1).replace(" ", ""), new Equipo(resp.getString(1)));
			}
			
			consulta = "SELECT * FROM pronostico_deportivo.Partido;";
			resp = bd.consultar(consulta);
			
			while(resp.next()) {
				partidosMap.put( Integer.parseInt(resp.getString(1)), new Partido(	equiposMap.get(resp.getString(2).replace(" ", "")),
																					equiposMap.get(resp.getString(3).replace(" ", "")),
																					resp.getInt(4),
																					resp.getInt(5),
																					resp.getString(1)
																				)
								);
			}
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta de partidos a la BD");
		}
		bd.desconectar();
	}
	
	private static void cargarPronosticosBD() {
		BaseDeDatos bd = new BaseDeDatos();
		bd.registrar();
		bd.conectar();
		
		String consulta = "SELECT * FROM pronostico_deportivo.Pronostico;";
		
		ResultSet resp = bd.consultar(consulta);
		
		try {
			
			while(resp.next()) {
				
				if ( ! pronosticosMap.containsKey(resp.getString(5)) )
					pronosticosMap.put(resp.getString(5), new ArrayList<Pronostico>());
				if ( ! rondaMap.containsKey(resp.getString(5)) ) 
					rondaMap.put( resp.getString(5), new Ronda(resp.getString(5)) );
				if ( ! personasMap.containsKey(resp.getString(4)) ) 
					personasMap.put( resp.getString(4), new Persona(resp.getString(4)) );
				
				pronosticosMap.get(resp.getString(5)).add(new Pronostico(	partidosMap.get(resp.getInt(1)),
																			equiposMap.get(resp.getString(2).replace(" ", "")),
																			ResultadoEnum.valueOf(resp.getString(3)),
																			personasMap.get(resp.getString(4))
																		)
														);
			}
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta de pronosticos a la BD");
		}
		bd.desconectar();
	}
	
	private static void cargarRondas() {
		for (String ronda : rondaMap.keySet()) {
			for(Pronostico pr : pronosticosMap.get(ronda) ) {
				rondaMap.get(ronda).agregarPronostico(pr);
			}
		}
	}
	
	private static void mostrarPuntaje() {
		
		for (String ronda : rondaMap.keySet()) {
			List<Integer> puntos = new ArrayList<Integer>();
			List<String> nombres = new ArrayList<String>();
			for (Persona persona : rondaMap.get(ronda).getParticipantes() ) {
				puntos.add(rondaMap.get(ronda).puntos(persona,1));
				nombres.add(persona.getNombre());
			}
			System.out.println("Ronda N°: "+ronda);
			
			int[] puntosArr = new int[puntos.size()];
			String[] nombresArr = new String[nombres.size()];
			for (int i = 0; i < puntos.size(); i++) puntosArr[i]=puntos.get(i);
			for (int i = 0; i < nombres.size(); i++) nombresArr[i]=nombres.get(i);
			
			ordenar(puntosArr,nombresArr);
			
			for (int i=0;i<puntosArr.length;i++) {
				System.out.println(nombresArr[i]+" puntos: "+puntosArr[i]);
			}
		}
	}
	
	private static void ordenar(int[] pts, String[] nombres) {
		for (int i=0;i<pts.length;i++) {
			for (int j=0;j<pts.length-i-1;j++) {
				if( pts[j] < pts[j+1] ) {
					int temp = pts[j+1];
					pts[j+1] = pts[j];
					pts[j] = temp;
					String tempS = nombres[j+1];
					nombres[j+1] = nombres[j];
					nombres[j] = tempS;
				}
			}
			
		}
	}

}
