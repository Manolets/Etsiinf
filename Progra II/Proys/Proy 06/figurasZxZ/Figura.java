package figurasZxZ;
// import stdlib.*;
import auxi.*;
import java.awt.Color;
/** 
 * Implementaci�n de una figurasZxZ geom�trica en el plano ZxZ
 * especificada en IFigura.
 * 
 * @since 17/04/2017  
 * @version 1.1    17/04/2018  JGF
 * @version 1.2    16/04/2020  JGF
 * 
 * @author Javier Galve
 */
public class Figura implements IFigura 
{
  private PuntoZxZ posicion;
  private Color color;
  private boolean rellena;
   /**
   * Figura () 
   * POST: Construye una Figura de color azul sin relleno 
   *       en una posici�n aleatoria.
   */
  public Figura () 
  {
    posicion = new PuntoZxZ(Auxi.aleatorio(Tablero.ESCALAX),
                         Auxi.aleatorio(Tablero.ESCALAY));
    this.color = StdDraw.BLUE;
    this.rellena = false;
  }
  /**
   * Figura (color : Color) 
   * POST: Construye una Figura sin relleno de <color> en 
   *       una posici�n aleatoria.    
   */
  public Figura (Color color) 
  {
    posicion = new PuntoZxZ(Auxi.aleatorio(Tablero.ESCALAX),
                         Auxi.aleatorio(Tablero.ESCALAY));
    this.color = color;
    this.rellena = false;
  }
  /**
   * Figura (posicion : PuntoZxZ) 
   * POST: Construye una Figura de color azul sin relleno  
   *       en <posicion>.
   */
  public Figura (PuntoZxZ posicion) 
  {
    this.posicion = posicion;
    this.color = StdDraw.BLUE;
    this.rellena = false;
  }
  /**
   * Figura (posicion : PuntoZxZ; color : Color) 
   * POST: Construye una Figura de <color> sin relleno  
   *       en <posicion>.
   */
  public Figura (PuntoZxZ posicion, Color color) 
  {
    this.posicion = posicion;
    this.color = color;
    this.rellena = false;
  }
  /**
   * Figura (posicion : PuntoZxZ; color : Color; rellena : boolean) 
   * POST: Construye una Figura de <color> en <posicion> 
   *       rellena o no seg�n el valor de <rellena>.
   */
  public Figura (PuntoZxZ posicion, Color color, boolean rellena) 
  {
    this.posicion = posicion;
    this.color = color;
    this.rellena = rellena;
  }
  public PuntoZxZ posicion ()
  {
    return posicion;
  }  
  public Color color ()
  {
    return color;
  }
  public boolean rellena ()
  {
    return rellena;
  }
  public String toString ()
  {
    return "Figura(" + posicion.toString() + ")";
  }
  public boolean equals (Object o) 
  {
    if (! (o instanceof Figura))
      return false;
    else
    {
      Figura f = (Figura)o;
      return posicion.equals(f.posicion);
    }
  }
  public int distA0 ()
  {
    return posicion.distancia(new PuntoZxZ(0, 0)); 
  }
  public int perimetro ()
  {
    return 0;
  }
  public void mover (int dx, int dy) 
  {
    posicion.mover(dx, dy);
  }
  public void pintar ()
  {
    StdDraw.setPenColor(color);
    posicion.pintar();
  }  
  
}
