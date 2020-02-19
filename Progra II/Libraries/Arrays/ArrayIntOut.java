//package arrays;

/**
 * Escritura de un array de enteros.
 * @author Javier Galve
 * @since 11/2016 
 * @version 1.1  27/11/2018 
 */

public class ArrayIntOut
{
  static int[] datos = {12, 34, 9, 0, -62, 88};
  static int[] ejArray = {2, 4, 6, 8, 10, 1, 3, 5, 7, 9};
  static int[] aNa;
  static int[] aNaDeNa = null;
  static int[] a0 = {};
  static int[] a1 = {1};
  static int[] a3 = {34, 5, 12} ;    
  static int[] a5 = {27, 19, 34, 5, 12} ;    
  static int[] ar1 =  { -20, 19, 1, 5, -1, 27, 19, 5 } ;
  static int[] ar2 =  { 2, 4, 1, 2, 6, 3, 6, 9 } ;
  static int[] ar3 =  { -20, 19, 1, 5, -1, 27, -29, 19, 5 } ;
  static char[] cars = new char[3];
  
  /*
   * escribir (a : int[])
   * EFECTO: Muestra a en la salida estandar.
   */ 
  public static void escribir (int[] a)
  {
    System.out.print("["); 
    for (int i=0; i < a.length; i++)
    {
      if (i!=0) System.out.print(", ");
      System.out.print(a[i]); 
    }  
    System.out.println("]");
  }
  /*
   * aString (a : int[]) : String
   * POST: Visualizador de un array de enteros: 
   *       convierte los datos del array en un String.
   */
  public static String aString (int[] a)
  {
    String resultado = "[";
//    int i = 0;
//    while (i < a.length)
//    {
//      if (i!=0) resultado = resultado + ", ";
//      resultado = resultado + a[i];
//      i = i+1;
//    }  
    for (int i=0; i < a.length; i++)
    {
      if (i!=0) resultado = resultado + ", ";
      resultado = resultado + a[i];
    }  
    return resultado + "]";
  }
  public static void main (String[] args)
  {
    System.out.println("datos = " + datos);
    System.out.println("datos = " + aString(datos));
    System.out.println("cars = " + cars);
    //
//    escribir(datos);
  }  
  
  
}