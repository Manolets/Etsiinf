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

public class Alfil extends PiezaAjedrez {
    /**
	 * Crea un alfil pertenenciente a jugador en la posición (x,y) del tablero
	 * @param jugador El jugador al que pertenece la pieza
	 * @param fila Fila que ocupa 
	 * @param columna Columna que ocupa
	 */
    public Alfil(Jugador jugador, int fila, char columna){
        super(jugador, TipoPiezaAjedrez.ALFIL, fila, columna);
    }

    @Override
    public IList<Casilla> movimientosValidos() {
        IList<Casilla> resultado = new ArrayList<>();
        // Diagonal abajo derecha
        casillasVisitables(resultado, 1, 1);
        // Diagonal arriba derecha
        casillasVisitables(resultado, -1, 1);
        // Diagonal abajo izquierda
        casillasVisitables(resultado, 1, -1);
        // Diagonal arriba izquierda
        casillasVisitables(resultado, -1, -1);
        return resultado;
    }
}