package figurasZxZ;
import java.awt.Color;
/** 
 * Especificación de una figurasZxZ geométrica en el plano ZxZ.
 * 
 * Formada por la posicion en la que está su centro geométrico, 
 * su color y si está rellena o no.
 * Figura (posicion : PuntoZxZ; 
 *         color : Color; 
 *         rellena : boolean)
 * 
 * @since 17/04/2017  
 * @version 1.1    17/04/2018  JGF
 * @version 1.2    16/04/2020  JGF
 * 
 * @author Javier Galve
 */
public interface IFigura
{
  /**
   * posicion () : PuntoZxZ 
   * POST: Da la posición donde está la Figura.
   */
  public PuntoZxZ posicion ();
  /**
   * color () : Color
   * POST: Da el color de esta Figura.
   */
  public Color color ();
  /**
   * rellena () : boolean
   * POST: Indica si esta Figura está rellena o no.
   */
  public boolean rellena ();
  /**
   * toString () : String 
   * POST: Visualizador de Figura: convierte esta 
   *       Figura a String.
   */
  public String toString ();
  /**
   * equals (o : Object) : boolean
   * POST: Comparador de Figura: determina si esta Figura
   *       es igual a <o>.
   */
  public boolean equals (Object o);
  /**
   * mover (dx, dy : int)
   * EFECTO: Mueve esta Figura según (dx, dy).
   */
  public void mover (int dx, int dy);
  /**
   * distA0 () : int
   * POST: Calcula la distancia de esta Figura al origen de 
   *       coordenadas.
   */
  public int distA0 ();
  /**
   * perimetro () : int
   * POST: Calcula el perímetro de esta Figura.
   */
  public int perimetro ();
  /**
   * pintar ()
   * EFECTO: Pinta esta Figura en el lienzo.
   */
  public void pintar ();
}
