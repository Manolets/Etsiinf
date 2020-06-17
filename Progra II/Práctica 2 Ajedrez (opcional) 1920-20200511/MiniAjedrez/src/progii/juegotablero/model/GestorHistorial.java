package progii.juegotablero.model;

import anotacion.Programacion2;
import progii.juegotablero.exceptions.MovimientoException;
import stacks.exceptions.EmptyStackException;
import stacks.Stack;

@Programacion2(nombreAutor1 = "Manuel", 
	apellidoAutor1 = "López-Cerón Corredor", 
	emailUPMAutor1 = "manuel.lopez-ceron.corredor@alumnos.upm.es", 
	nombreAutor2 = "", 
	apellidoAutor2 = "", 
	emailUPMAutor2 = ""
)

/**
 * Clase que gestiona el historial de movimientos de la partida
 * 
 *
 */
public class GestorHistorial {

	/**
	 * Pila con los movimientos a deshacer
	 */
	Stack<Movimiento> pilaDeshacer;

	/**
	 * Pila con los movimientos a rehacer
	 */
	Stack<Movimiento> pilaRehacer;

	/**
	 * Crea e inicializa las pilas del gestor del historial
	 */
	public GestorHistorial() {
		pilaDeshacer = new Stack<>();
		pilaRehacer = new Stack<>();
	}

	/**
	 * Guarda un nuevo movimientos en el historial
	 * 
	 * @param movimiento Movimiento a guardar
	 */
	public void guardarMovimiento(Movimiento movimiento) {
		if (!pilaRehacer.isEmpty()) 
			pilaRehacer = new Stack<>();
		
		pilaDeshacer.push(movimiento);

	}

	/**
	 * Devuelve el último movimiento realizado y lo elimina de la pila de deshacer
	 * 
	 * @return El movimiento a deshacer
	 * @throws MovimientoException En caso de que no haya movimientos que deshacer
	 */
	public Movimiento deshacer() throws MovimientoException {
		if (pilaDeshacer.isEmpty())
			throw new MovimientoException("No has hecho ningun movimiento todavia");
		Movimiento move = null;
		try {
			move = pilaDeshacer.pop();
		} catch (EmptyStackException e) {
			e.getStackTrace();
		}
		pilaRehacer.push(move);
		return move; 
	}
	
	/**
	 * Devuelve el último movimiento deshecho y lo elimina de la pila de rehacer
	 * @return El movimiento a rehacer
	 * @throws MovimientoException En caso de que no haya movimientos que rehacer
	 */
	public Movimiento rehacer () throws MovimientoException {
		if (pilaRehacer.isEmpty())
			throw new MovimientoException("No has deshecho ningun movimiento todavia");
		Movimiento move = null;
		try {
			move = pilaRehacer.pop();
		} catch (EmptyStackException e) {
			e.getStackTrace();
		}
		pilaDeshacer.push(move);
		return move; 
	}
	
}
