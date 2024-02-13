CREATE TABLE "equipos" (
  "equipo_id" integer PRIMARY KEY,
  "nombre" varchar,
  "pais" varchar
);

CREATE TABLE "grupos" (
  "grupo_id" integer PRIMARY KEY,
  "nombre_grupo" varchar
);

CREATE TABLE "partidos" (
  "partidos_id" integer PRIMARY KEY,
  "equipo_local" integer,
  "equipo_visitante" integer,
  "grupo_id" integer,
  "fase" integer
);

CREATE TABLE "fase" (
  "fase_id" integer PRIMARY KEY,
  "nombre_fase" integer
);

CREATE TABLE "resultados" (
  "juego_id" integer PRIMARY KEY,
  "partido" integer,
  "gol_local" integer,
  "gol_visitante" integer
);

ALTER TABLE "partidos" ADD FOREIGN KEY ("equipo_local") REFERENCES "equipos" ("equipo_id");

ALTER TABLE "partidos" ADD FOREIGN KEY ("equipo_visitante") REFERENCES "equipos" ("equipo_id");

ALTER TABLE "partidos" ADD FOREIGN KEY ("grupo_id") REFERENCES "grupos" ("grupo_id");

ALTER TABLE "partidos" ADD FOREIGN KEY ("fase") REFERENCES "fase" ("fase_id");

ALTER TABLE "resultados" ADD FOREIGN KEY ("partido") REFERENCES "partidos" ("partidos_id");
