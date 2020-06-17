package gestionpedidos.pedido;

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

public class Pedido {
	// C�DIGO DE APOYO
	private Cliente cliente;
	private PlatoComida[] comidas;
	private Restaurante restaurante;
	private double importe;	
	private Transporte transporte;
	private double peso;
	
	/**
	 * @param cliente : Cliente
	 * @param comidas : PlatoComida[]
	 * @param restaurante : Restaurante
	 * POST: crea el objeto Pedido con los atributos recibidos
	 */
	public Pedido(Cliente cliente, PlatoComida[] comidas, Restaurante restaurante) {		
		this.cliente = cliente;
		this.comidas = comidas;
		this.restaurante = restaurante;
		for (int i = 0; i < this.comidas.length; i++) {
			this.importe += this.comidas[i].getPrecio();
			this.peso += this.comidas[i].getPeso();
		}
	}

	/**
	 * @return peso
	 */
	public double getPeso(){		
		return peso;
	}
	
	/**
	 * @param transporte : Transporte
	 * @return el coste de ir al restaurante y llevar el pedido desede el restaurante al cliente
	 * Además si el importe del pedido es mayor que 100€ el coste se multiplica por 1.10
	 */
	public double coste(Transporte transporte){
		double coste = transporte.coste(transporte.getCodigo(), restaurante.getCodigo()) +
			transporte.coste(restaurante.getCodigo(), cliente.getCodigo());
		coste *= (importe >= 100)?1.10:1;
		return coste + importe;
	}
	
	// C�DIGO DE APOYO
	public double getImporte(){
		return importe;
	}	

	// C�DIGO DE APOYO
	public Transporte getTransporte() {
		return transporte;
	}

	// C�DIGO DE APOYO
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	
	// C�DIGO DE APOYO
	public Cliente getCliente(){
		return cliente;
	}
	
	// C�DIGO DE APOYO
	public Restaurante getRestaurante(){
		return restaurante;
	}
}
