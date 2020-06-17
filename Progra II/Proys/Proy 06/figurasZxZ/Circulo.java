package figurasZxZ;
// import auxi.*;
// import stdlib.*;
import java.awt.Color;
/**
 * Circulo.
 * Representa un c�rculo formado por un centro y un radio.
 * Circulo = (centro : Punto; radio : double)
 * Circulo hereda de Figura:
 *   - El <centro> de Circulo est� representado
 *     por la <posicion> de Figura.  
 * 
 * @since 17/04/2017  
 * @version 1.1    17/04/2018  Javier Galve
 * @version 1.1.1  16/04/2020  Javier Galve
 * 
 * @author Javier Galve
 */
public class Circulo extends Figura
{
  private int radio;
   /**
   * Circulo () 
   * POST: Construye un Circulo relleno de color azul 
   *       en una posici�n aleatoria con un radio de 
   *       tama�o aleatorio.
   */
  public Circulo () 
  {
    super();
    this.radio = (int) (Math.random() * 101);
  }
   /**
   * Circulo (color : Color) 
   * POST: Construye un Circulo de <color> sin relleno 
   *       en una posici�n aleatoria con un radio de 
   *       tama�o aleatorio.
   */
  public Circulo (Color color) 
  {
    super(color);
    this.radio = (int) (Math.random() * 101);
  }
  /**
  * Circulo (centro : PuntoZxZ; radio : int) 
   * POST: Construye un Circulo de color azul sin relleno  
   *       en una posicion <centro> y con tama�o <radio>.
   */
public Circulo (PuntoZxZ centro, int radio) 
  {
    super(centro);
    this.radio = radio;
  }
  /**
   * Circulo (centro : PuntoZxZ; radio : int; 
   *          color : Color; relleno : boolean) 
   * POST: Construye un Circulo de <color> en <centro> 
   *       y tama�o <radio>, relleno o no seg�n el valor 
   *       de <relleno>.
   */
  public Circulo (PuntoZxZ centro, int radio, 
                  Color color, boolean relleno) 
  {
    super(centro, color, relleno);
    this.radio = radio;
  }
  public int radio ()
  {
    return radio;
  }
  @Override
  public String toString ()
  {
    return new String("Circulo(" + super.toString() + 
                      ", " + this.radio + ")");
  }
  @Override
  public boolean equals (Object o) 
  {
    if (! (o instanceof Circulo))
      return false;
    else
    {
      Circulo c = (Circulo)o;
      return 
        super.equals(c.posicion()) &&
        radio==c.radio;
    }
  }
  @Override
  public int perimetro ()
  {
    return 2*radio*(int)Math.PI; 
  }
  @Override
  public void pintar () 
  {
    StdDraw.setPenColor(color());
    super.pintar();
    if (rellena())
      StdDraw.filledCircle(posicion().x(), posicion().y(), radio);
    else
      StdDraw.circle(posicion().x(), posicion().y(), radio);
  }  
  
}