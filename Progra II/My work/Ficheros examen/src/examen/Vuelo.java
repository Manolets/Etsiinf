package examen;

import examen.datosVuelo.*;
import list.ArrayList;
import list.IList;

public class Vuelo {
    String nVuelo;
    String origen;
    String destino;
    Avion aeronave;
    IList<Pasajero> pasajeros;

    // POST: Crea un objeto con nVuelo, "id", origen, "co", destino, "cd", aeronave, "aa" y una colección de pasajeros vacía.

    public Vuelo (String id, String co, String cd, Avion aa) {
        nVuelo = id;
        origen = co;
        destino = cd;
        aeronave = aa;
        pasajeros = new ArrayList<>();
    }

    //     Redactar el método getPasajero con arreglo a la siguiente cabecera:

    //  POST: resultado es el pasajero con número de documento de
    //        identidad "ident", del objeto.
    //        Si no se encuentra, resultado es null.
    public Pasajero getPasajero (String ident){
        Pasajero resultado = null;
        int i = 0;
        while ( i < pasajeros.size()) {
            if (pasajeros.get(i).getIdent().equals(ident))
                resultado = pasajeros.get(i);
            i++;
        }
        return resultado;
    }
}