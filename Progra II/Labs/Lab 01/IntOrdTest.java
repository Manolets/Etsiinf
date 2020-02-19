//import stdlib.*;
//import arrays.*;
import java.io.*; 

/** 
 * Pruebas de ordenaci�n de arrays de n�meros.
 * @since 6/02/2017
 * @version 2.1    05/02/2020
 * @author Javier Galve
 */
public class IntOrdTest
{
  //private Arrays ArrayIntIn;
  /*
   * test1ordenarSeleccion ()
   * EFECTO: Prueba la ordenaci�n por selecci�n con un array 
   *         formado por n�meros le�dos del <input>.
   */
  static void test1ordenarSeleccion () 
  { 
    int[] numeros = ArrayIntIn.leerN(3);
    System.out.println("numeros = " + ArrayIntOut.aString(numeros));
    System.out.println("ordenarSeleccion(numeros);");
    Ord.ordenarSeleccion(numeros);
    System.out.println("numeros = " + ArrayIntOut.aString(numeros));
  }
  /*
   * test2ordenarSeleccion ()
   * EFECTO: Prueba la ordenaci�n por selecci�n con un array 
   *         de n�meros le�dos de un archivo.
   */
  /*
   * test3ordenarSeleccion ()
   * EFECTO: Prueba la ordenaci�n por selecci�n con un array 
   *         de n�meros generados aleatoriamente.
   */
  /*
   * test1ordenarBurbuja ()
   * EFECTO: Prueba la ordenaci�n por burbuja con un array 
   *         formado por n�meros le�dos del <input>.
   */
  /*
   * test2ordenarBurbuja ()
   * EFECTO: Prueba la ordenaci�n por burbuja con un array 
   *         de n�meros le�dos de un archivo.
   */
  /*
   * test3ordenarBurbuja ()
   * EFECTO: Prueba la ordenaci�n por burbuja con un array 
   *         de n�meros generados aleatoriamente.
   */
  public static void main (String[] args) {
    test1ordenarSeleccion();
//    //
//    test2ordenarSeleccion();
//    //
//    test3ordenarSeleccion();
//    //
//    test1ordenarBurbuja();
//    //
//    test2ordenarBurbuja();
//    //
//    test3ordenarBurbuja();      
  }
  
}  