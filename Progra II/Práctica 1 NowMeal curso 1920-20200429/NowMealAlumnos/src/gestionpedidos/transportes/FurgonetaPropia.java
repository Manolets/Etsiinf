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

public class FurgonetaPropia extends Furgoneta {
    private double velocidadMedia = 30;
    private static final double EUROS_P_HORA = 40;

    /**
     * Contruye el objeto de Furgoneta propia a  partir de los parámetros introducidos
     * @param codigo : String
     * @param mapa : Mapa
     * @param tara : Double
     */
    public FurgonetaPropia(String codigo, Mapa mapa, Double tara){
        super(codigo, mapa, tara);
    }

    /**
     * Dados los parámetros 
     * @param codPosOrigen : String y 
     * @param codPosDestino : String devuelve
     * @return coste : double que supondría llevar el pedido desde un codigo de origen
     * hasta un codigo de destino y si la tara es mayor de 500Kg se multiplica el coste por 1.10
     */
    @Override
    public double coste(String codPosOrigen, String codPosDestino){
        double coste;
        if (super.getTara() < 500) {
            coste = super.getMapa().distancia(codPosOrigen, codPosDestino)*EUROS_P_HORA/velocidadMedia;
        } else {
            coste = super.getMapa().distancia(codPosOrigen, codPosDestino)*EUROS_P_HORA/velocidadMedia*1.10;
        }

        return coste;
    }

    /**
     * @return EUROS_P_HORA : double
     */
    public double eurosPorHora(){
        return EUROS_P_HORA;
    }

    /**
     * @return velocidadMedia : double
     */
    public double velocidadMedia(){
        return velocidadMedia;
    }

    /**
     * Un void que cambia el valor de la velocidad media de acuerdo con el parámetro
     * @param velocidadMedia : double
     */
    public void setVelocidadMedia(double velocidadMedia){
        this.velocidadMedia = velocidadMedia;
    }
}