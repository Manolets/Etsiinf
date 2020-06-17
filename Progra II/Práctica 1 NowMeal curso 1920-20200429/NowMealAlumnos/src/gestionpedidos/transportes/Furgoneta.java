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


public abstract class Furgoneta extends Transporte{
    
    private double tara;

    /**
     * Constructor abstracto de furgoneta con parametros
     * @param codigo : String
     * @param mapa : Mapa
     * @param tara : Double
     */
    public Furgoneta(String codigo, Mapa mapa, Double tara){
        super(codigo, mapa);
        this.tara = tara;
    }
    
    /**
     * @return el transporte como tipo Furgoneta
     */
    public Furgoneta getTransporte(){
        return this;
    }

    /**
     * @return tara : double
     */
    public double getTara(){
        return tara;
    }

    /**
     * Un void que cambia el valor de la tara de la furgoneta de a cuerdo con el parámetro
     * @param tara : double
     */
    public void setTara(double tara){
        this.tara = tara;
    }

}