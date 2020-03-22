import java.io.IOException;

/**
 * Prueba de AgendaAmpliada<br>
 * 
 * @since 13/03/2020
 * @version 1.0
 * @author Javier Galve
 */
public class AgendaAmpliadaTest {
  public static void pruebaLeerAgenda() throws IOException
  {
    Agenda agenda = AgendaAmpliada.leer("agenda.txt");
    System.out.println("agenda = \n" + agenda);
  }
  public static void pruebaEscribirAgenda () throws IOException
  {
    Agenda agenda = AgendaAmpliada.leer("agenda.txt");
    AgendaAmpliada.escribir(agenda, "copiaAgenda.txt");
  }
  public static void pruebaOrdenarAgenda () throws IOException
  {
    Agenda agenda = AgendaAmpliada.leer("agenda.txt");
    System.out.println("agenda = \n" + agenda);
    System.out.println("ordenar(agenda);");
    AgendaAmpliada.ordenar(agenda);
    System.out.println("agenda = \n" + agenda);
  }
  public static void main (String[] args) throws IOException
  {
    pruebaLeerAgenda();
    //
    pruebaEscribirAgenda(); 
    //
    pruebaOrdenarAgenda();
  }
}