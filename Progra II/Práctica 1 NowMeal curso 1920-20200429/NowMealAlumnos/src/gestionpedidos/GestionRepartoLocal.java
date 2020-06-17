package gestionpedidos;

import gestionpedidos.excepciones.PedidoSinTransporteAsignado;
import gestionpedidos.pedido.Pedido;
import gestionpedidos.transportes.Furgoneta;
import gestionpedidos.transportes.Moto;
import gestionpedidos.transportes.Transporte;
import list.ArrayList;
import list.IList;
import queues.IQueue;
import queues.exceptions.EmptyQueueException;
import queues.CircularQueue;
import anotacion.Programacion2;
@Programacion2 (
	nombreAutor1 = "Manuel",
	apellidoAutor1 = "López-Cerón Corredor",
	emailUPMAutor1 = "manuel.lopez-ceron.corredor@alumnos.upm.es",
	nombreAutor2 = "",
	apellidoAutor2 = "", 
	emailUPMAutor2 = ""
)

public class GestionRepartoLocal {
	// C�DIGO DE APOYO
	private IList<Moto> motosDisponibles;
	private IList<Furgoneta> furgonetasDisponibles;

	private IQueue<Pedido> pedidosEsperandoMoto;
	private IQueue<Pedido> pedidosEsperandoFurgoneta;

	// C�DIGO DE APOYO
	public String getDisponibles() {
		return "Motos Disponibles:"
				+ GestionRepartoLocalFuncionesAuxiliares
						.myArrayListToString(GestionRepartoLocalFuncionesAuxiliares.getCodList(motosDisponibles))
				+ System.lineSeparator() + "Furgonetas Disponibles:"
				+ GestionRepartoLocalFuncionesAuxiliares
						.myArrayListToString(GestionRepartoLocalFuncionesAuxiliares.getCodList(furgonetasDisponibles))
				+ System.lineSeparator();

	}

	// C�DIGO DE APOYO
	public String getEsperando() {
		return "Pedidos esperando moto:"
				+ GestionRepartoLocalFuncionesAuxiliares.myArrayListToString(
						GestionRepartoLocalFuncionesAuxiliares.getClienteRestauranteList(pedidosEsperandoMoto))
				+ System.lineSeparator() + "Pedidos esperando furgoneta:"
				+ GestionRepartoLocalFuncionesAuxiliares.myArrayListToString(
						GestionRepartoLocalFuncionesAuxiliares.getClienteRestauranteList(pedidosEsperandoFurgoneta))
				+ System.lineSeparator();
	}

	// C�DIGO DE APOYO
	public IList<String> getCodMotosDisponibles() {
		return GestionRepartoLocalFuncionesAuxiliares.getCodList(motosDisponibles);
	}

	// C�DIGO DE APOYO
	public IList<String> getCodFurgoDisponibles() {
		return GestionRepartoLocalFuncionesAuxiliares.getCodList(furgonetasDisponibles);

	}

	// C�DIGO DE APOYO
	public IList<String[]> getCodEsperandoMoto() {
		return GestionRepartoLocalFuncionesAuxiliares.getClienteRestauranteList(pedidosEsperandoMoto);
	}

	public IList<String[]> getCodEsperandoFurgo() {
		return GestionRepartoLocalFuncionesAuxiliares.getClienteRestauranteList(pedidosEsperandoFurgoneta);
	}

	private static final double PESO_MAX_MOTO = 20;

	// C�DIGO DE APOYO
	public GestionRepartoLocal() {

		this.motosDisponibles = new ArrayList<>();
		this.furgonetasDisponibles = new ArrayList<>();

		this.pedidosEsperandoFurgoneta = new CircularQueue<>();
		this.pedidosEsperandoMoto = new CircularQueue<>();
	}

	/**
	 * @return pedido si hay algun pedido esperando a moto 
	 */
	public Pedido getEsperandp() throws EmptyQueueException {
		return pedidosEsperandoMoto.peek();
	}

	/**
	 * Añade el parámetro
	 * @param transporte : Transporte 
	 * a la lista correspondiente (motos o furgos)Disponibles
	 */
	public void add(Transporte transporte) {
		if (transporte instanceof Moto){
			Moto moto = new Moto(transporte.getCodigo(), transporte.getMapa());
			motosDisponibles.add(motosDisponibles.size(), moto);
		} else {
			furgonetasDisponibles.add(furgonetasDisponibles.size(), (Furgoneta) transporte);
		}
	}

	/**
	 * A partir de
	 * @param pedido : Pedido
	 * se le asigna un transporte dependiendo de sus características, si no hay transportes disponibles
	 * mete el pedido a la cola de pedidosEsperando(Moto o Furgo) correspondiente
	 */

	public void asignarPedido(Pedido pedido) {
		IList<?> temp = motosDisponibles;
		IQueue<Pedido> tempPedido = pedidosEsperandoMoto;
		boolean bool = true;
		int size = motosDisponibles.size();
		if (pedido.getPeso() > PESO_MAX_MOTO){
			temp = furgonetasDisponibles;
			tempPedido = pedidosEsperandoFurgoneta;
			bool = false;
			size = furgonetasDisponibles.size();
		}
		if (size == 0) {
			tempPedido.add(pedido);
		} else {
			Transporte transporte = (Transporte) temp.get(0);
			for (int i = 0; i < size; i++) {
				transporte = (pedido.coste(transporte) > pedido.coste((Transporte) temp.get(i)))?(Transporte) temp.get(i):transporte;
			}
			pedido.setTransporte(transporte);
			if (bool) {
				motosDisponibles.remove((Moto) transporte);
			} else {
				furgonetasDisponibles.remove((Furgoneta) transporte);
			}
		}
	}


	// PRE: el pedido tiene asignado un transporte
	/**
	 * Notifica la entrega de
	 * @param pedido : Pedido
	 * le retira el transporte y lo añade a la lista de transportesDisponibles segun lo que sea
	 * y si hay algun pedido esperando a ese transporte le asigna el transporte recién liberado
	 * a el pedido esperando
	 * @throws PedidoSinTransporteAsignado
	 */
	public void notificarEntregaPedido(Pedido pedido) throws PedidoSinTransporteAsignado {
		Transporte transporte = pedido.getTransporte();
		if (transporte == null) 
			throw new PedidoSinTransporteAsignado("El pedido no tiene transporte");

		try {
			if (pedido.getTransporte() instanceof Moto) {
				motosDisponibles.add(motosDisponibles.size(), (Moto) transporte);
				if (!pedidosEsperandoMoto.isEmpty()) {
					Pedido pedidoAux = pedidosEsperandoMoto.poll();
					asignarPedido(pedidoAux);
				}
			} else if (pedido.getTransporte() instanceof Furgoneta){
				furgonetasDisponibles.add(furgonetasDisponibles.size(), (Furgoneta) transporte);
				if (!pedidosEsperandoFurgoneta.isEmpty()) {
					Pedido pedidoAux = pedidosEsperandoFurgoneta.poll();
					asignarPedido(pedidoAux);
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}