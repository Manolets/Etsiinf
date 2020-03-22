/**
 * Pruebas informales de ListaDeContactos<br>
 * @since 11/03/2020
 * @version 1.0   
 * @author Javier Galve
 */
public class ListaDeContactosJugar
{
  
  public static void prueba01 ()
  {
    ListaDeContactos vacia;
    vacia = new ListaDeContactos();
    System.out.println("vacia = " + vacia);   
    System.out.println();
  }
  public static void prueba02 ()
  {
    ContactoTest.resetear();
    ListaDeContactos lista02 = new ListaDeContactos();
    lista02.add(ContactoTest.c1);
    lista02.add(ContactoTest.c2);
    lista02.add(ContactoTest.c3);
    System.out.println("lista02 = " + "\n" + lista02);   
  }
  public static void main (String[] args)
  {
    prueba01();
    prueba02();
  }

}