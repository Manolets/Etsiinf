package progii.juegotablero.model.ajedrez.piezas;

import anotacion.Programacion2;
import list.ArrayList;
import list.IList;
import progii.juegotablero.model.Casilla;
import progii.juegotablero.model.Jugador;
import progii.juegotablero.model.ajedrez.PiezaAjedrez;
import progii.juegotablero.model.ajedrez.TipoPiezaAjedrez;

@Programacion2(nombreAutor1 = "Manuel", 
	apellidoAutor1 = "López-Cerón Corredor", 
	emailUPMAutor1 = "manuel.lopez-ceron.corredor@alumnos.upm.es", 
	nombreAutor2 = "", 
	apellidoAutor2 = "", 
	emailUPMAutor2 = ""
)

public class Peon extends PiezaAjedrez {
    
    public Peon(Jugador jugador, int fila, char columna){
        super(jugador, TipoPiezaAjedrez.PEON, fila, columna);
    }

    @Override
    public IList<Casilla> movimientosValidos() {
        IList<Casilla> resultado = new ArrayList<>();
        int dir = getJugador().getNombre().equals("BLANCO")? - 1: 1;
        // En frente
        if (queHay(getFila() + dir, getColumna()) == null)
            casillaVisitable(resultado, getFila() + dir, getColumna());
        // Diagonal izq
        if (queHay(getFila() + dir, getColumna() + dir) != null)
            casillaVisitable(resultado, getFila() + dir, getColumna() + dir);
        // Diahonal drch
        if (queHay(getFila() + dir, getColumna() - dir) != null)
            casillaVisitable(resultado, getFila() + dir, getColumna() - dir);
        // Inicial (doble)
        if ((getFila() == 1 || getFila() == 6) && queHay(getFila() + dir, getColumna()) == null)
            casillaVisitable(resultado, getFila() + 2 * dir, getColumna());
        return resultado;
    }
}