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

public class Caballo extends PiezaAjedrez {
    
	/**
	 * Crea un caballo pertenenciente a jugador en la posición (x,y) del tablero
	 * @param jugador El jugador al que pertenece la pieza
	 * @param fila Fila que ocupa 
	 * @param columna Columna que ocupa
	 */
    public Caballo(Jugador jugador, int fila, char columna) {
        super(jugador, TipoPiezaAjedrez.PEON, fila, columna);
    }

    @Override
    public IList<Casilla> movimientosValidos(){
        IList<Casilla> resultado = new ArrayList<>();
        int fila = super.getFila();
        int columna = super.getColumna();
        // Derecha :
            // Abajo
        casillaVisitable(resultado, fila + 1, columna + 2);
        casillaVisitable(resultado, fila + 2, columna + 1);
            // Arriba
        casillaVisitable(resultado, fila - 1, columna + 2);
        casillaVisitable(resultado, fila - 2, columna + 1);
        // Iquierda
            // Abajo
        casillaVisitable(resultado, fila + 1, columna - 2);
        casillaVisitable(resultado, fila + 2, columna - 1);
            // Arriba
        casillaVisitable(resultado, fila - 1, columna - 2);
        casillaVisitable(resultado, fila - 2, columna - 1);
        return resultado;
    }
}