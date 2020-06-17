package figurasZxZ;
import stdlib.*;
/** 
 * 
 * @since 17/04/2017  
 * @version 1.1    17/04/2018  JGF
 * @version 1.1.1  18/04/2020  JGF
 *   - Convertido en PuntoZxZ
 * 
 * @author Javier Galve
 */
public class PuntoZxZ implements IPuntoZxZ
{
  private int x;
  private int y; 
  /**
   * PuntoZxZ (x : int; y : int);
   * POST: Constructor de PuntoZxZ: Construye un objeto
   *       de tipo PuntoZxZ a partir de las coordenadas 
   *       <x> e <y>.
   */
  public PuntoZxZ (int x, int y) 
  {
    this.x = x;
    this.y = y;
  }
  public int x () 
  {
    return x;
  }  
  public int y () 
  {
    return y;
  }
  public String toString ()
  {  
    return new String("(" + x +  ", " + y + ")"); 
  }   
  public boolean equals (Object o) 
  {
    if (! (o instanceof PuntoZxZ))
      return false;
    else
    {
      PuntoZxZ p = (PuntoZxZ)o;
      return x==p.x && y==p.y;
    }
  } 
  public int distancia (PuntoZxZ p) {
    return Math.abs(x - p.x())+ Math.abs(y - p.y()); 
  }
  public void mover (int dx, int dy) 
  {
    x = x + dx;
    y = y + dy;
  }
  public void pintar ()
  {
    StdDraw.point(x, y);
  }  

}