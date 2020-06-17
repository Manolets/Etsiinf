package figurasZxZ;
import stdlib.*;
import java.awt.Color;
/** 
 * Tablero. 
 * Tablero gráfico.
 * @author Javier Galve  
 * @version 1.0     17/03/2017
 */
public class Tablero
{
  
  public static final int ESCALAX = 400;
  public static final int ESCALAY = 400;
  public static final double GROSORPINCEL = 0.008;
  public static final Color COLOR_FONDO = StdDraw.CYAN;
  
  public static void iniciar () 
  {  
    StdDraw.setXscale(0, ESCALAX);
    StdDraw.setYscale(0, ESCALAY);
    StdDraw.setPenRadius(GROSORPINCEL);
    StdDraw.setPenColor(StdDraw.RED);
  }  
  public static void iniciarAnimacion () 
  {  
    iniciar();
    StdDraw.enableDoubleBuffering();
  }  
  
}  

