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

public class FurgonetaSubcontratada extends Furgoneta{
    private double eurosPKm = 1;

    /**
     * Crea el objeto de FurgonetaSubcontratada a partir de los parámetros introducidos
     * @param codigo : String
     * @param mapa : Mapa
     * @param tara : double
     */
    public FurgonetaSubcontratada(String codigo, Mapa mapa, Double tara){
        super(codigo, mapa, tara);
    }

    /**
     * Dados los parámetros 
     * @param codPosOrigen : String y 
     * @param codPosDestino : String devuelve
     * @return coste : double que supondría llevar el pedido desde un codigo de origen
     * hasta un codigo de destino y si la tara es mayor de 1000Kg se multiplica el coste por 1.10
     */
    @Override
    public double coste(String codPosOrigen, String codPosDestino){
        double coste = 0;
        if (super.getTara() < 1000) {
            coste = super.getMapa().distancia(codPosOrigen, codPosDestino)*eurosPKm;
        } else {
            coste = super.getMapa().distancia(codPosOrigen, codPosDestino)*eurosPKm*1.10;
        }

        return coste;
    }

    /**
     * @return eurosPKm
     */
    public double eurosPKm(){
        return eurosPKm;
    }

    /**
     * Un void que cambia el valor de eurosPKm a el parámetro
     * @param eurosPKm : double
     */
    public void setEurosPKm(double eurosPKm){
        this.eurosPKm = eurosPKm;
    }
}
