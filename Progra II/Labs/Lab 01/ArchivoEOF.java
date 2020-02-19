//import stdlib.*;
import java.io.*;
/** 
 * Lectura y escritura en archivos de texto.
 * Detecci�n del EOF.
 * Redireccionamiento de la E/S est�ndar.
 * @since 05/02/2020
 * @version 1.0
 * @author Javier Galve
 */
class ArchivoEOF
{
  /*
   * suma () : int
   * POST: Devuelve la suma de los n�meros le�dos de la 
   *       entrada est�ndar (<input>). Se desconoce a 
   *       priori cu�ntos n�meros vendr�n. 
   *       Los n�meros vienen separados por espacios 
   *       o saltos de l�nea. 
   *       El final viene marcado con <ctrl><d>.
   */
  static int suma () 
  { 
    int resultado = 0;
    while (!StdIn.isEmpty())
    {  
       resultado = resultado + StdIn.readInt();
    }  
    //for (; !StdIn.isEmpty(); resultado += StdIn.readInt());
    return resultado;
  }
  /*
   * suma (entrada : String) : int
   * POST: Devuelve la suma de los n�meros le�dos de
   *       del archivo <entrada>. 
   *       Se desconoce a priori cu�ntos n�meros vendr�n. 
   *       Los n�meros vienen separados por espacios 
   *       o saltos de l�nea. 
   *       El final viene marcado con <ctrl><d>.
   */
  static int suma (String entrada) throws IOException 
  { 
    System.setIn(new FileInputStream(new File(entrada)));
    int resultado = suma();
    System.in.close();
    return resultado;
  }
  /*
   * copiar ()
   * EFECTO: 
   *   Genera en el <output> una copia del <input>.
   *   Se desconoce a priori cu�ntos n�meros vendr�n. 
   *   Los n�meros vienen separados por espacios 
   *   o saltos de l�nea. 
   *   El final viene marcado con <ctrl><d>.
   */
  static void copiar () 
  { 
    while (!StdIn.isEmpty())
    { 
      StdOut.print(" " + StdIn.readInt());
    }
    StdOut.println();
  }
  /*
   * copiar (entrada, salida : String)
   * EFECTO: Genera en el archivo <salida> una copia del 
   *         archivo <entrada>.
   *         Pone el archivo <salida> en la carpeta actual
   *         indicada por el "Interactions Working Directory"
   */
  static void copiar (String entrada, 
                      String salida) throws IOException 
  { 
    System.setIn(new FileInputStream(new File(entrada)));
    System.setOut(new PrintStream(new File(salida)));   
    copiar();
    System.in.close();
    System.out.close();
  }
  public static void main (String[] args) throws IOException
  {
    //System.out.println(suma());
    //    
    //copiar();
    //
    //System.out.println(suma("numeros.txt"));
    //
    //copiar("numeros.txt", "numerosOut.txt");
  }
}  