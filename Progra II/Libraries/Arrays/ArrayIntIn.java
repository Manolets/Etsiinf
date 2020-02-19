//package arrays;

//import stdlib.*;
import java.io.*;

/**
 * Lectura de un array de enteros.
 * @author Javier Galve
 * @since 11/2016 
 * @version 1.1  27/11/2018 
 */

public class ArrayIntIn
{
  /*
   * leerN (n : int) : int[]
   * POST: Lee un array de <n> enteros de la entrada estndar.
   */
  public static int[] leerN (int n)
  {
    int[] resultado = new int[n];
    for (int i=0; i<resultado.length; i++)
    {
      resultado[i] = StdIn.readInt();
    }  
    return resultado;
  }
  /*
   * leerN (n : int; archivo : String) : int[]
   * POST: Lee un array de <n> enteros de <archivo>.
   */
  public static int[] leerNArchivo (int n, String archivo) throws IOException
  {
    System.setIn(new FileInputStream(new File(archivo)));
    int[] numeros = leerN(n);
    System.in.close();  
    return numeros;
  }
  public static void pruebaLeerN ()
  {
    int[] numeros = leerN(5);
    System.out.println("numeros = " + ArrayIntOut.aString(numeros));    
  }
  public static void pruebaLeerNArchivo () throws IOException
  {
      int[] numeros = leerNArchivo(3, ".\\files\\numeros.txt");
      System.out.println("numeros = " + ArrayIntOut.aString(numeros));
  } 
  public static void main (String[] args) throws IOException
  {
    pruebaLeerN();
    //pruebaLeerNArchivo();
  }
}