/**
 * FechaApp
 */
public class FechaApp {

    public static void main(String[] args) {
        System.out.println("Dime tu fecha de nacimiento en formato dd/mm/aaaa >");
        Fecha cumple = new Fecha(StdIn.readString());
        while (!cumple.esFechaCorrecta()) {
            System.out.println("No es un formato válido, inserte otra fecha");
            cumple = new Fecha(StdIn.readString());
        }

        System.out.println("Tienes una edad de: " + FechaOps.edad(Fecha.hoy(), cumple));
    }
}