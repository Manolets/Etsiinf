package figurasZxZ;
//package figuras.puntoZxZ;
/** 
 * Especificación del TAD PuntoZxZ.
 * Representa un PuntoZxZ del plano cartesiano ZxZ.
 * PuntoZxZ = (x, y : int) 
 * 
 * @since 16/04/2020
 * @version 1.0
 * 
 * @author Javier Galve
 * 
 */
public interface IPuntoZxZ
{
  /**
   * x () : int
   * POST: Selector que da el valor del atributo x.
   */
  public int x ();
  /**
   * y () : int
   * POST: Selector que da el valor del atributo y.
   */
  public int y ();
  /**
   * toString () : String 
   * POST: Visualizador de PuntoZxZ: convierte este 
   *       PuntoZxZ a String.
   */
  public String toString ();
  /**
   * equals (p : PuntoZxZ) : boolean
   * POST: Comparador de PuntoZxZ: determina si este PuntoZxZ 
   *       es igual a <p>.
   */
  public boolean equals (Object o);
  /**
   * distancia (p : PuntoZxZ) : int
   * POST: Calcula la distancia de este PuntoZxZ al <p>.
   */
  public int distancia (PuntoZxZ p);
  /**
   * mover (dx, dy : double)
   * EFECTO: Mueve este PuntoZxZ según (dx, dy).
   */
  public void mover (int dx, int dy);
  /**
   * pintar ()
   * EFECTO: Pinta este PuntoZxZ en el lienzo.
   */
  public void pintar ();
  
}

