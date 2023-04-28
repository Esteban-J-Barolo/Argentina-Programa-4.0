-- CREATE DATABASE pronostico_deportivo;

drop table pronostico_deportivo.pronostico cascade;
drop table pronostico_deportivo.partido cascade;
drop table pronostico_deportivo.equipo cascade;

CREATE TABLE pronostico_deportivo.Partido(
nro int PRIMARY KEY,
equipo1 varchar(30),
equipo2 varchar(30),
goles_equipo1 int,
goles_equipo2 int
);
CREATE TABLE pronostico_deportivo.Pronostico(
partido integer,
equipo varchar(30),
resultado varchar(10) CHECK(resultado='GANADOR' OR resultado='EMPATE' OR resultado='PERDEDOR'),
persona varchar(30),
ronda varchar(30),
CONSTRAINT fk_partido FOREIGN KEY (partido) REFERENCES pronostico_deportivo.Partido(nro),
PRIMARY KEY (partido, PERSONA)
);