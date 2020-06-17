package examen;

import list.IList;

public class Aerolinea {
    String nombre;
    String alcance;    // códigos de aeropuertos (entre blancos)
    IList<Vuelo> vuelos;
    static final int AVIONES = 10;

    public Aerolinea(){

    }

    // POST: Elimina el vuelo "v" del objeto.
    public void cancelarVuelo (Vuelo v) {
        vuelos.remove(v);
    }
}