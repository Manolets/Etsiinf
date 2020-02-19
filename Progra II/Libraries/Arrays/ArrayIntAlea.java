//package arrays;

/**
 * Generaci�n de un array de enteros aleatorios.
 * @author Javier Galve
 * @since 11/2016 
 * @version 1.1  27/11/2018
 */

public class ArrayIntAlea
{
  /*
   * aleatorios (longitud, n : int) : int[]
   * POST: Genera un array de tama�o <longitud> formado por n�meros 
   *       aleatorios en el rango [0, <n>]
   */
  public static int[] aleatorios (int longitud, int n)
  {
    int[] resultado = new int[longitud];
    for (int i=0; i<resultado.length; i++)
    {
      resultado[i] = (int)((n+1)*Math.random());
    }  
    return resultado;
  }
  public static void main (String[] args)
  {
    System.out.println("aleatorios(90, 50) = " + 
                       ArrayIntOut.aString(aleatorios(90, 50)));  
  }  
}