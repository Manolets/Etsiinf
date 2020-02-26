import stdlib.*;
/** 
 * Dibujos y Textos en modo gráfico con StdDraw.
 * @since 19/02/2018
 * @version 1.0
 * @author Javier Galve
 */
public class Dibujos 
{
  
  public static void main (String[] args)
  {
    StdDraw.setCanvasSize(500, 500);
    StdDraw.setXscale(0, 500);
    StdDraw.setYscale(0, 500);
    
    StdDraw.text(250, 200, 
                 "There's a little black spot on the sun today, ");
    StdDraw.text(200, 200, 
                "It's the same old thing as yesterday... ", 
                 45);
    StdDraw.setPenColor(StdDraw.YELLOW);
    StdDraw.filledCircle(360, 360, 80);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.setPenRadius(0.01);
    StdDraw.circle(400, 380, 5);
  } 
  
}
