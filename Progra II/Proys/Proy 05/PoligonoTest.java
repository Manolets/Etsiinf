// import figuras.punto.*;
// import stdlib.*;
/**
 * Prueba de un Poligono<br>
 * @since 11/03/2020
 * @version 1.0
 * @author Javier Galve
 */
public class PoligonoTest
{
  public static Punto puntovacio = new Punto();
  public static Punto p1;
  public static Punto p2;
  public static Punto p3;
  public static Punto p4;
  public static Punto p5;
  public static Punto p6;
  public static Punto p7;
  public static Punto p8;
  public static Punto p9;
  
  static Punto[] arr0;
  static Punto[] arr1;
  static Punto[] arr2;
  static Punto[] arr3;
  static Punto[] arr4;
  static Punto[] arr5;
  static Punto[] arr6;
  //
  public static Poligono vacio;
  public static Poligono uno;
  public static Poligono segmento;
  public static Poligono triangulo;
  public static Poligono cuadrilatero;
  public static Poligono pentagono;
  public static Poligono hexagono;
  
  public static void resetear ()
  {
    p1 = new Punto(2, 1);
    p2 = new Punto(4, 1);
    p3 = new Punto(6, 1);
    p4 = new Punto(2, 3);
    p5 = new Punto(4, 3);
    p6 = new Punto(6, 3);
    p7 = new Punto(2, 5);
    p8 = new Punto(4, 5);
    p9 = new Punto(6, 5);
    //
    arr0 = new Punto[]{};   
    arr1 = new Punto[]{p1};
    arr2 = new Punto[]{p1, p2};
    arr3 = new Punto[]{p1, p2, p5};
    arr4 = new Punto[]{p1, p3, p6, p5};
    arr5 = new Punto[]{p1, p3, p9, p8, p4};
    arr6 = new Punto[]{p1, p2, p6, p9, p8, p4};
    //
    vacio = new Poligono(arr0);
    uno = new Poligono(arr1);
    segmento = new Poligono(arr2);
    triangulo = new Poligono(arr3);
    cuadrilatero = new Poligono(arr4);
    pentagono = new Poligono(arr5);
    hexagono = new Poligono(arr6);
  }
  static void mostrar ()
  {
    System.out.println("vacio = " + vacio);
    System.out.println("uno = " + uno);
    System.out.println("segmento = " + segmento);
    System.out.println("triangulo = " + triangulo);
    System.out.println("cuadrilatero = " + cuadrilatero);
    System.out.println("pentagono = " + pentagono);
    System.out.println("hexagono = " + hexagono);
  }
  static boolean testSize () 
  {
    return  
      vacio.size() == 0 &&
      uno.size() == 1 && 
      segmento.size() == 2 &&
      triangulo.size() == 3 &&
      cuadrilatero.size() == 4 &&
      pentagono.size() == 5 &&
      hexagono.size() == 6;
  }
  static boolean testGet () 
  {
    return
      uno.get(0).equals(p1) &&
      triangulo.get(2).equals(p5) &&
      pentagono.get(1).equals(p3);
  }
  static boolean test1set () 
  {
    resetear();
    triangulo.set(2, p6);
    return triangulo.toString().equals
      ("(3, [(2.00, 1.00), (4.00, 1.00), (6.00, 3.00)])");
  }
  static boolean test2set () 
  {
    resetear();
    segmento.set(1, p4);
    return segmento.toString().equals("(2, [(2.00, 1.00), (2.00, 3.00)])");
  }
  static boolean test3set () 
  {
    resetear();
    cuadrilatero.set(2, p9);
    return cuadrilatero.toString().equals
      ("(4, [(2.00, 1.00), (6.00, 1.00), (6.00, 5.00), (4.00, 3.00)])");
  }
  static boolean testSet () 
  {
    return 
      test1set() &&  
      test2set() &&  
      test3set();  
  }
  static boolean test1add () 
  {
    resetear();
    vacio.add(p1);
    return vacio.toString().equals
      ("(1, [(2.00, 1.00)])");
  }
  static boolean test2add () 
  {
    resetear();
    segmento.add(p5);
    return segmento.toString().equals(triangulo.toString());
  }
  static boolean testAdd () 
  {
    return 
      test1add() &&  
      test2add();  
  }
  static boolean test1addPos () 
  {
    resetear();
    vacio.add(0, p1);
    return vacio.toString().equals
      ("(1, [(2.00, 1.00)])");
  }
  static boolean test2addPos () 
  {
    resetear();
    segmento.add(2, p5);
    return segmento.toString().equals(triangulo.toString());
  }
  static boolean testAddPos () 
  {
    return 
      test1addPos() &&  
      test2addPos();  
  }
  static boolean testIndexOf () 
  {
    resetear();
    return
      segmento.indexOf(p5) == -1 &&
      segmento.indexOf(p2) == 1 &&
      triangulo.indexOf(p2) == 1;
  }
  static boolean test1removeElementAt () 
  {
    resetear();
    triangulo.removeElementAt(2);
    return triangulo.toString().equals(segmento.toString());
  }
  static boolean test2removeElementAt () 
  {
    resetear();
    triangulo.removeElementAt(2);
    triangulo.removeElementAt(1);
    return triangulo.toString().equals(uno.toString());
  }
  static boolean testRemoveElementAt () 
  {
    return 
      test1removeElementAt() &&  
      test2removeElementAt();  
  }
  static boolean test1remove() 
  {
    resetear();
    triangulo.remove(p5);
    return triangulo.toString().equals(segmento.toString());
  }
  static boolean test2remove() 
  {
    resetear();
    segmento.remove(p2);
    return segmento.toString().equals(uno.toString());
  }
  static boolean testRemove() 
  {
    return 
      test1remove() &&  
      test2remove();  
  }
  static void iniciarGraficos () 
  {  
    StdDraw.setXscale(-10, 10);
    StdDraw.setYscale(-10, 10);
    StdDraw.setPenRadius(0.02);
    StdDraw.setPenColor(StdDraw.BLUE);
//    StdDraw.enableDoubleBuffering();
  }  
  static void testPintar () 
  {
    resetear();
    iniciarGraficos();
    // vacio.pintar();
    // uno.pintar();
    // segmento.pintar();
    // triangulo.pintar();
    // cuadrilatero.pintar();
    // pentagono.pintar();
    hexagono.pintar();
  }
  public static void main (String[] args)
  {
   resetear();
  //  mostrar(); 
    //
  //  System.out.println("testSize() = " + testSize());
  //  System.out.println("testGet() = " + testGet()); 
  //  System.out.println("testSet() = " + testSet());
  //  System.out.println("testAdd() = " + testAdd());
  //  System.out.println("testAddPos() = " + testAddPos());    
  //  System.out.println("testIndexOf() = " + testIndexOf());
  //  System.out.println("testRemoveElementAt() = " + 
  //                     testRemoveElementAt());
  //  System.out.println("testRemove() = " + testRemove());
    //
  //  testPintar();
  }
}