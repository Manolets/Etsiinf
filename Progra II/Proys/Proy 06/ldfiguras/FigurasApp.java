package ldfiguras;
import figurasZxZ.*;
import list.*;
import auxi.*;
import pruebas.*;
import stdlib.*;
import java.awt.Color;
/** 
 * App de Figuras geom�tricas.
 * 
 * @since 17/04/2020  
 * @version 1.0
 * @author Javier Galve
 */
public class FigurasApp
{
 /*
  * generaFiguras () : LdFiguras
  * POST: Genera una LdFiguras compuesta por un n�mero aleatorio
  *       de ellas. Cada figurasZxZ se localiza en un PuntoZxZ 
  *       aleatorio y tiene un tama�o aleatorio un color aleatorios. 
  */
  public static LdFiguras generaFiguras ()
  {
    // PARA HACER
  }
  /**
   * caer (f : Figura; dy : int) 
   * EFECTO: Desplaza verticalmente la Figura <f> 
   *         una distancia de magnitud <dy>.
   */
  public static void caer (Figura f, int dy)
  {
    // PARA HACER
  }
  /**
   * caer (ldf : LdFiguras ; dy : int) 
   * EFECTO: Desplaza verticalmente todas las figuras
   *         de la LdFiguras <ldf> una distancia de 
   *         magnitud <dy>.
   */
  public static void caer (LdFiguras ldf, int dy)
  {
    // PARA HACER
  }
  public static void pruebaPintarAleatorias ()
  {
    Tablero.iniciar();
    generaFiguras().pintar();
  }
  public static void pruebaPintarCaer ()
  { 
    LdFigurasPrueba.resetear();
    Tablero.iniciar();
    LdFigurasPrueba.ldf5.pintar();
    caer(LdFigurasPrueba.ldf5, 30);
    LdFigurasPrueba.ldf5.pintar();
  }
    public static void pruebaCaer () 
  {
    resetear();
    Tablero.iniciarAnimacion();    
    pentagono.pintar();
    for (int i=1; i<=15; i++)
    {
      StdDraw.clear();
      pentagono.caer(10);
      pentagono.pintar();
      StdDraw.show();
      StdDraw.pause(500);
    }
  }
  public static void pruebaListaCaer () 
  {
    LdFigurasPrueba.resetear();
    Tablero.iniciar();
    LdFiguras ldf = generaFiguras();
    ldf.add(LdFigurasPrueba.triangulo);
    ldf.add(LdFigurasPrueba.pentagono);    
    for (int i = 1; i<=25; i++)
    {
      StdDraw.clear();
      caer(ldf, 20);
      ldf.pintar();
      StdDraw.show();
      StdDraw.pause(1000);
    }
  }  
  public static void main (String args[])
  {     
    //Gr�ficos:
//    pruebaPintarCaer();
//    pruebaPintarAleatorias();
    //
    //Animaci�n:
//    pruebaCaer();
//    pruebaListaCaer();
  }  
}