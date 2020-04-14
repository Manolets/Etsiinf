/**
 * Pruebas de LecturaConMouse.<br>
 * 
 * @since 31/03/2020
 * @version 1.0   
 * @author Javier Galve
 */
// import figuras.punto.*;
// import stdlib.*;
public class LecturaConMouseTest
{
  static void iniciarGraficos () 
  { 
    int XMAX = 200;
    int YMAX = 200;
    StdDraw.setXscale(-XMAX, XMAX);
    StdDraw.setYscale(-YMAX, YMAX);
    StdDraw.setPenRadius(0.02);
    StdDraw.setPenColor(StdDraw.BLUE);    
//    StdDraw.setPenColor(StdDraw.RED);
  }  
  public static void testLeerPunto ()
  {
    Punto p = LecturaConMouse.leerPunto();
    System.out.println("punto = " + p);
  }
  public static void testPedirPunto(){
    System.out.println("Prueba a poner un punto en el centro de la pantalla");
    Punto p = LecturaConMouse.leerPunto();
    if (Math.abs(p.x()) < 20 && Math.abs(p.y()) < 20) {
      System.out.println("Bien muy cerca");
    } else {
      System.out.println("Te has salido mucho del centro");
    }
    System.out.println("Tu punto es " + p);
  }

  public static void testLeerPoligono ()
  {
    Poligono p = LecturaConMouse.leerPoligono();
    System.out.println("poligono = " + p);
    p.pintar();
  }
  public static void testPedirCuadrado(){
    System.out.println("Prueba a dibujar un cuadrado, a poder ser equilátero");
    Poligono p = LecturaConMouse.leerPoligono();
    if (p.size() == 4) {
      System.out.println("Bonito cuadrado");
    } else {
      System.out.println("No has hecho un cuadrado");
    }
    p.pintar();
  }

  public static void testLeerListaDePoligonos ()
  {
    ListaDePoligonos ldp = LecturaConMouse.leerListaDePoligonos();
    System.out.println("lista de poligonos = " + ldp);
    ldp.pintar();   
  }
  public static void main (String[] args)
  {
    iniciarGraficos();
    
    // testLeerPunto();
    // testPedirPunto();
    
    // testLeerPoligono();
    // testPedirCuadrado();
    
    // testLeerListaDePoligonos();
  } 
}