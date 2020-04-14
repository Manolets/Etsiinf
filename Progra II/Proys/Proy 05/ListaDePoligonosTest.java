/**
 * Pruebas de ListaDePoligonos.
 * 
 * @since 30/03/2020
 * @version 1.0
 * @author Javier Galve
 */
// import stdlib.*;
// import figuras.punto.*;

public class ListaDePoligonosTest 
{ 
  public static ListaDePoligonos listaDePol0; 
  public static ListaDePoligonos listaDePol1;
  public static ListaDePoligonos listaDePol2;
  public static ListaDePoligonos listaDePol4;
   
  public static ListaDePoligonos otraLista;
  
  static void resetear () 
  { 
    PoligonoTest.resetear();
    //
    listaDePol1 = new ListaDePoligonos();
    listaDePol1.add(PoligonoTest.segmento); 
    //
    listaDePol2 = new ListaDePoligonos();
    listaDePol2.add(PoligonoTest.triangulo); 
    listaDePol2.add(PoligonoTest.pentagono); 
    //
    listaDePol4 = new ListaDePoligonos();
    listaDePol4.add(PoligonoTest.hexagono); 
    listaDePol4.add(PoligonoTest.triangulo); 
    listaDePol4.add(PoligonoTest.pentagono); 
    listaDePol4.add(PoligonoTest.cuadrilatero); 
  }
  static void resetearOtraLista () 
  { 
    Punto p1 = new Punto(16, 12);
    Punto p2 = new Punto(16, 4);
    Punto p3 = new Punto(8, 4);
    Poligono triangulo = 
      new Poligono(new Punto[]{p1, p2, p3});
    //   
    Punto p4 = new Punto(28, 8);
    Punto p5 = new Punto(28, 4);
    Punto p6 = new Punto(18, 4);
    Punto p7 = new Punto(18, 8);
    Poligono cuadrilatero = 
      new Poligono(new Punto[]{p4, p5, p6, p7});
    //
    otraLista = new ListaDePoligonos();
    otraLista.add(triangulo); 
    otraLista.add(cuadrilatero); 
  }
  static void mostrar () 
  {
    System.out.println("listaDePol0 = " + listaDePol0);
    System.out.println("listaDePol1 = " + listaDePol1);
    System.out.println("listaDePol2 = " + listaDePol2);
    System.out.println("listaDePol4 = " + listaDePol4);
  }
  static void testAddOrd () 
  { 
    PoligonoTest.resetear();
    
    listaDePol0 = new ListaDePoligonos();
    //
    listaDePol1 = new ListaDePoligonos();
    listaDePol1.addOrd(PoligonoTest.triangulo); 
    //
    listaDePol2 = new ListaDePoligonos();
    listaDePol2.addOrd(PoligonoTest.triangulo); 
    listaDePol2.addOrd(PoligonoTest.pentagono); 
    //
    listaDePol4 = new ListaDePoligonos();
    listaDePol4.addOrd(PoligonoTest.hexagono); 
    listaDePol4.addOrd(PoligonoTest.triangulo); 
    listaDePol4.addOrd(PoligonoTest.pentagono); 
    listaDePol4.addOrd(PoligonoTest.cuadrilatero); 
    //
    mostrar();
  }
  private static void iniciarGraficos () 
  {  
    final int XMAX = 30;
    StdDraw.setXscale(0, XMAX);
    StdDraw.setYscale(0, XMAX);
    StdDraw.setPenRadius(0.02);
    StdDraw.setPenColor(StdDraw.BLUE);
  }  
  static void testPintar () 
  { 
    iniciarGraficos();
    PoligonoTest.resetear();
    resetear();
    resetearOtraLista();
    listaDePol4.pintar();
    otraLista.pintar();
  }
  public static void main (String[] args) 
  {
    StdDraw.enableDoubleBuffering();
   resetear();
   mostrar();
   
   resetear();
   testAddOrd();   
    
   testPintar();
  }
}