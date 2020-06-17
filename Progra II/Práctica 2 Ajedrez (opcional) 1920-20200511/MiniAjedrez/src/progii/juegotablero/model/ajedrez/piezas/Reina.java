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

public class Reina extends PiezaAjedrez {
    
    public Reina(Jugador jugador, int fila, char columna){
        super(jugador, TipoPiezaAjedrez.REINA, fila, columna);
    }

    @Override
    public IList<Casilla> movimientosValidos(){
        IList<Casilla> resultado = new ArrayList<>();

        // Verticales
        casillasVisitables(resultado, -1, 0);
        casillasVisitables(resultado, 0, -1);
        casillasVisitables(resultado, 1, 0);
        casillasVisitables(resultado, 0, 1);
        // Diagonales
        casillasVisitables(resultado, 1, 1);
        casillasVisitables(resultado, -1, -1);
        casillasVisitables(resultado, 1, -1);
        casillasVisitables(resultado, -1, 1);

        return resultado;
    }
}