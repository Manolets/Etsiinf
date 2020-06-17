package gestionpedidos;

import gestionpedidos.excepciones.PedidoSinTransporteAsignado;
import gestionpedidos.mapa.Mapa;
import gestionpedidos.mapa.PosicionXY;
import gestionpedidos.pedido.Pedido;
import gestionpedidos.transportes.Transporte;
import anotacion.Programacion2;
@Programacion2 (
	nombreAutor1 = "Manuel",
	apellidoAutor1 = "López-Cerón Corredor",
	emailUPMAutor1 = "manuel.lopez-ceron.corredor@alumnos.upm.es",
	nombreAutor2 = "",
	apellidoAutor2 = "", 
	emailUPMAutor2 = ""
)

public class GestionReparto {
	// C�DIGO DE APOYO
	private GestionRepartoLocal[] gestoresLocales;
	private Mapa mapa;
	private int xMax;
	private int yMax;
	
	//C�DIGO DE APOYO
	public Mapa getMapa() {
		return mapa;
	}

	// C�DIGO DE APOYO
	public String getEstadoGestorLocal(int i){
		return this.gestoresLocales[i].getDisponibles() + this.gestoresLocales[i].getEsperando();
	}

	// C�DIGO DE APOYO
	public String getEstadoGestorLocalNum(int i){
		return this.gestoresLocales[i].getCodMotosDisponibles().size() + ";" +
				this.gestoresLocales[i].getCodFurgoDisponibles().size() + ";" +
				this.gestoresLocales[i].getCodEsperandoMoto().size() + ";" +
				this.gestoresLocales[i].getCodEsperandoFurgo().size() ;
	}

	/**
	 * Crea el objeto de GestionReparto a partir de un 
	 * @param mapa
	 * Este será el padre de los cuatro gestores locales
	 */
	public GestionReparto(Mapa mapa){
		this.mapa = mapa;
		this.xMax = mapa.getMaxCoordX();
		this.yMax = mapa.getMaxCoordY();
		gestoresLocales = new GestionRepartoLocal[4];
		for (int i = 0; i < gestoresLocales.length; i++) {
			gestoresLocales[i] = new GestionRepartoLocal();
		}
	}
	
	/**
	 * Añade el parámetro de 
	 * @param transporte : Transporte
	 * al gestorLocal que le toque según su posición
	 */
	public void addTransporteLocalidad(Transporte transporte) {
		gestoresLocales[seleccionarLocalidad(mapa.getPosicion(transporte.getCodigo()))].add(transporte);
	}
	
	/**
	 * A partie de una 
	 * @param pos : PosicionXY 
	 * @return la zona : int que le corresponde a dicha posición en el mapa
	 */
	private int seleccionarLocalidad(PosicionXY pos){
		int zona = 3;

		zona = pos.getX() <= xMax/2 && pos.getY() <= yMax/2?0:zona;
		zona = pos.getX() > xMax/2 && pos.getY() <= yMax/2?1:zona;
		zona = pos.getX() <= xMax/2 && pos.getY() > yMax/2?2:zona;

		return zona;
	}

	/**
	 * Manda el 
	 * @param pedido : Pedido
	 * al gestor local que le toca para que sea asignado a su transporte correspondiente
	 */
	public void asignarPedido(Pedido pedido) {
		gestoresLocales[seleccionarLocalidad(mapa.getPosicion(pedido.getRestaurante().getCodigo()))].asignarPedido(pedido);
	}

	/**
	 * Notifica que el 
	 * @param pedido : Pedido
	 * ha sido entregado al correspondiente gestorLocal
	 * @throws PedidoSinTransporteAsignado
	 */
	public void notificarEntregaPedido(Pedido pedido) throws PedidoSinTransporteAsignado{
		gestoresLocales[seleccionarLocalidad(mapa.getPosicion(pedido.getRestaurante().getCodigo()))].notificarEntregaPedido(pedido);
	}

}
