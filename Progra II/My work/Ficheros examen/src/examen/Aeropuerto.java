/**
 * Aeropuerto
 */
package examen;

import list.ArrayList;
import list.IList;
import queues.CircularQueue;

public class Aeropuerto {
    // Total puertas embarque
    static final int CAPACIDAD_TERMINAL = 40;
    static final int CAPACIDAD_PISTA = 4;// Total aviones en cada pista
    String nombre;
    CircularQueue<String>[] pistas;  // Solo códigos de vuelo (VAR)
    IList<Aerolinea> compañias;      // Con los vuelos
    String[] terminal;               // Solo códigos de vuelo (FIJO)
    
    //POST: Crea un objeto con el nombre "nomb", tantas pistas vacías como diga "nPistas", un terminal vacío y las compañías vacías.

    public Aeropuerto(String nomb, int nPistas){
        this.nombre = nomb;
        for (int i = nPistas; i < pistas.length; i++) {
            pistas[i] = new CircularQueue<String>();
        }

        compañias = new ArrayList<>();

        terminal = new String[CAPACIDAD_TERMINAL];
    }



    // PRE: Al menos hay una pista en el objeto.
    // POST: resultado es el identificador (una posicion en pistas)
    // de la pista menos ocupada del objeto. Si todas tienen la misma   ocupación, devolverá la primera.

    public int  pistaMenosOcupada (){
        int pista = 0;
        for (int i = 0; i < pistas.length; i++) {
            if (sizeCola(i) < sizeCola(pista)) {
                pista = i;
            }
        }
        return 0;
    }

    // Se puede suponer que existe la función privada:

    // POST: resultado es el número de vuelos en espera en la pista "i"
    private int sizeCola (int i){
        return i;
    }

}