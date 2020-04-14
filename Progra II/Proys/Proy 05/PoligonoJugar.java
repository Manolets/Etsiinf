/**
 * Pruebas informales de un Poligono<br>
 * @since 06/03/2020
 * @version 1.0   
 * @author Javier Galve
 */
// import figuras.punto.*;
// import stdlib.*;
public class PoligonoJugar
{
  public static void prueba00 ()
  {
    Poligono vacia = new Poligono();
    System.out.println("vacia = " + vacia);   
  }
  public static void prueba01 ()
  {
    Poligono vacia;
    Punto[] vacio = new Punto[]{};   // �se puede asignar "{}"?
    vacia = new Poligono(vacio);
    System.out.println("vacia = " + vacia);   
  }
  public static void prueba02 ()
  {
    Punto p2 = new Punto(4, 1);
    Punto p4 = new Punto(2, 3);
    Punto p6 = new Punto(6, 3);
    Punto[] puntos = {p2, p4, p6};
    Poligono pol = new Poligono(puntos);
    System.out.println("pol = " + pol);   
  }
  private static void iniciarGraficos () 
  {  
    final int XMAX = 25;
    StdDraw.setXscale(0, XMAX);
    StdDraw.setYscale(0, XMAX);
    StdDraw.setPenRadius(0.02);
    StdDraw.setPenColor(StdDraw.BLUE);
  }  
  
  public static void prueba03 ()
  {
    Punto p2 = new Punto(4, 10);
    Punto p4 = new Punto(2, 3);
    Punto p6 = new Punto(6, 3);
    Punto[] puntos = {p2, p4, p6};
    Poligono pol = new Poligono(puntos);
    pol.add(new Punto(18, 10));
    pol.add(new Punto(20, 20));
    System.out.println("pol = " + pol);   
    pol.pintar();
  }
  public static void prueba04 ()
  {
    Punto p1 = new Punto(4, 2);
    Punto p2 = new Punto(6, 2);
    Punto p5 = new Punto(6, 6);
    Poligono pol = new Poligono();
    pol.add(p1);
    pol.add(p2);
    pol.add(p5);
    pol.pintar();
  }
  public static void main (String[] args)
  {
  //  prueba00();
      //
  //  prueba01();
      //
  //  prueba02();
    //
  //  iniciarGraficos();
  //  prueba03();
    
   iniciarGraficos();
   prueba04();
  }
}