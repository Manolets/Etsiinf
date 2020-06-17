package examen.datosVuelo;

public class Pasajero {
    private String nombre;
    private String nacionalidad;
    private String nDI;
    private int costePasaje;

    public Pasajero() {

    }

    // POST: res es cierto si el objeto es igual a "pas" y es falso e.o.c
    public boolean equals (Object pas){
        boolean check = false;
        if(pas instanceof Pasajero){
            pas = (Pasajero) pas;
            check = nombre.equals(pas.nombre) && nacionalidad.equals(pas.getNacionalidad()) && nDI.equals(pas.getIdent());
        }
        return check; // pas instanceof Pasajero && nombre.equals(pas.nombre) && nacionalidad.equals(pas.getNacionalidad()) && nDI.equals(anObject);
    }

    public String getNombre(){
        return nombre;
    }

    public String getNacionalidad(){
        return nacionalidad;
    }

    public int getCostePasaje() {
        return costePasaje;
    }

    public String getIdent(){
        return nDI;
    }
}