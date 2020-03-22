/**
 * Pruebas de Contacto<br>
 * @since 14/03/2018
 * @version 1.0     
 * @author Javier Galve
 */
public class ContactoTest
{
  static Contacto c1;
  static Contacto c2;
  static Contacto c3;
  static Contacto c4;
  static Contacto c5;
  static Contacto c6;
  
  public static void resetear ()
  {
    c1 = new Contacto("Abilio", "111", "abilio@abilio.es");
    c2 = new Contacto("Gumersindo", "222", "gumersindo@gumersindo.es");
    c3 = new Contacto("Sandalio", "333", "sandalio@sandalio.es");
    c4 = new Contacto("Ermisinda", "444", "ermisinda@ermisinda.es");
    c5 = new Contacto("Luzdivina", "555", "luzdivina@luzdivina.es");
    c6 = new Contacto("Tranquilina", "666", "tranquilina@tranquilina.es");
  }
  public static void mostrar ()
  {
    System.out.println("c1 = " + c1);
    System.out.println("c2 = " + c2);
    System.out.println("c3 = " + c3);
    System.out.println("c4 = " + c4);
    System.out.println("c5 = " + c5);
    System.out.println("c6 = " + c6);
  }
  public static void main (String[] args)
  {
    resetear();
    mostrar();
    System.out.println("El contacto leído es = " + 
                       Contacto.leer());
  }
}