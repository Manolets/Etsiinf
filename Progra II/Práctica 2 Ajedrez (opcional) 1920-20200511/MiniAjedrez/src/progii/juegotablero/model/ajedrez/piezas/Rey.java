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

public class Rey extends PiezaAjedrez {
    
    public Rey(Jugador jugador, int fila, char columna){
        super(jugador, TipoPiezaAjedrez.REY, fila, columna);
    }

    @Override
    public IList<Casilla> movimientosValidos() {
        IList<Casilla> resultado = new ArrayList<>();

        //Verticales:
        casillaVisitable(resultado, getFila() + 1, getColumna());
        casillaVisitable(resultado, getFila() - 1, getColumna());
        casillaVisitable(resultado, getFila(), getColumna() - 1);
        casillaVisitable(resultado, getFila(), getColumna() + 1);
        //Diagonales
        casillaVisitable(resultado, getFila() - 1, getColumna() + 1);
        casillaVisitable(resultado, getFila() + 1, getColumna() - 1);
        casillaVisitable(resultado, getFila() + 1, getColumna() + 1);
        casillaVisitable(resultado, getFila() - 1, getColumna() - 1);

        return resultado;
    }
}