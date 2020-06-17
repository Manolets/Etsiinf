package figurasZxZ;
import java.awt.Color;
// import stdlib.*;
/** 
 * Representa un p�xel en la pantalla.
 * Dot = (posicion : PuntoZxZ)
 * Dot hereda de Figura:
 *   - La posici�n de Dot est� representada
 *     por la <posicion> de Figura.  

 * @since 17/04/2017  
 * @version 1.1    17/04/2018  Javier Galve
 * @author Javier Galve
 */
public class Dot extends Figura
{
 private PuntoZxZ punto;
 private Color color;
  /**
   * Dot () 
   * POST: Construye un Dot relleno de color azul 
   *       en una posici�n aleatoria.
   */
  public Dot () {
    int x = (int) Math.random() * Tablero.ESCALAX;
    int y = (int) Math.random() * Tablero.ESCALAY;
    punto = new PuntoZxZ(x, y);
    color = Color.BLUE;
  }
  /**
   * Dot (color : Color) 
   * POST: Construye un Dot relleno de <color>
   *       en una posici�n aleatoria.
   */
  public Dot (Color color) 
  {
    int x = (int) Math.random() * Tablero.ESCALAX;
    int y = (int) Math.random() * Tablero.ESCALAY;
    punto = new PuntoZxZ(x, y);
    this.color = color;
  }
  /**
   * Dot (posicion : PuntoZxZ) 
   * POST: Construye un Dot de color azul en 
   *       <posicion>.
   */
  public Dot (PuntoZxZ posicion) 
  {
    punto = new PuntoZxZ(posicion.x(), posicion.y());
    color = Color.BLUE;
  }

  public int x(){
    return punto.x();
  }

  public int y(){
    return punto.y();
  }

  public String toString ()
  {
    return "Dot(" + punto.x() + "," + punto.y() + ")";
  }

  public boolean equals (Dot o)
  {
    return this.punto.x() == o.x() && this.punto.y() == o.y();
  }
  
}
