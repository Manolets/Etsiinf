package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;
import anotacion.Programacion2;
@Programacion2 (
	nombreAutor1 = "Manuel",
	apellidoAutor1 = "López-Cerón Corredor",
	emailUPMAutor1 = "manuel.lopez-ceron.corredor@alumnos.upm.es",
	nombreAutor2 = "",
	apellidoAutor2 = "", 
	emailUPMAutor2 = ""
)

public class Moto extends Transporte{
    
    private double eurosPKm = 2;
    public static final int TARIFA_MIN = 10;

    /**
     * Crea el objeto de Moto a partir de los parámetros introducidos
     * @param codigo : String
     * @param mapa : Mapa
     */
    public Moto(String codigo, Mapa mapa){
        super(codigo, mapa);
    }

    /**
     * Dados los parámetros 
     * @param codPosOrigen : String y 
     * @param codPosDestino : String devuelve
     * @return coste : double que supondría llevar el pedido desde un codigo de origen
     * hasta un codigo de destino y añade la tarifa mínima de la moto
     */
    @Override
    public double coste(String codPosOrigen, String codPosDestino){
        return super.getMapa().distancia(codPosOrigen, codPosDestino) * eurosPKm + TARIFA_MIN;
    }

    /**
     * @return eurosPKm
     */
    public double getEurosPKm(){
        return eurosPKm;
    }

    /**
     * Un void que cambia el valor de miCoste al valor del parámetro
     * @param miCosteKm : double
     */
    public void setEurosPKm(double miCosteKm){
        this.eurosPKm = miCosteKm;
    }
}