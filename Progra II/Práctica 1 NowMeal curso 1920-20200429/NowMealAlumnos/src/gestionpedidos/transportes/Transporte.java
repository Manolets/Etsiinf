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

public abstract class Transporte {
    private String codigo;
    private Mapa mapa;
    
    /**
     * Constructor abstracto de Transporte con parámetros 
     * @param codigo : String
     * @param mapa : Mapa
     */
    public Transporte(String codigo, Mapa mapa){
        this.codigo = codigo;
        this.mapa = mapa;
    }

    /**
     * Devuelve el coste de ir desde la posición actual del transporte a un 
     * @param codPosDestino : String que entra como parámetro
     */
    public double coste(String codPosDestino){
        return this.coste(codigo, codPosDestino);
    }

    /**
     * Dados los parámetros 
     * @param codPosOrigen : String y 
     * @param codPosDestino : String devuelve
     * @return coste : double que supondría llevar el pedido desde un codigo de origen
     * hasta un codigo de destino
     */
    public double coste(String codPosOrigen, String codPosDestino){
        return this.coste(codPosOrigen, codPosDestino);
    }

    /**
     * @return mapa : Mapa
     */
    public Mapa getMapa(){
        return mapa;
    }

    /**
     * @return codigo : String
     */
    public String getCodigo(){
        return codigo;
    }
}