package figuras.punto;
import stdlib.*;
/** 
 * Pruebas del TAD Punto.
 * 
 * @since 26/02/2016
 * @version 1.2
 * @author Javier Galve   17/02/2020
 */

public class PuntoTest {
  
  public static Punto p0;
  public static Punto p1;
  public static Punto p2;
  public static Punto p3;
  public static Punto p4;
  public static Punto p1Replica;
  public static Punto pSinNada;
  public static Punto pNadaDeNada;
  /**
   * Vuelve los objetos de prueba a su estado inicial.
   */
  public static void resetear () 
  {  
    p0 = new Punto(0, 0);
    p1 = new Punto(1, 1);
    p2 = new Punto(8, 6);
    p3 = new Punto(5, 12);
    p1Replica = new Punto(1, 1);
    pSinNada = new Punto();
  }
  /**
   * Muestra los objetos de prueba en modo texto.
   */
  public static void mostrar () 
  {  
    System.out.println("p0 = " + p0); 
    System.out.println("p1 = " + p1); 
    System.out.println("p2 = " + p2); 
    System.out.println("p3 = " + p3); 
    System.out.println("p1Replica = " + p1Replica); 
    System.out.println("pSinNada = " + pSinNada); 
    System.out.println("pNadaDeNada = " + pNadaDeNada); 
  }
    public static void testSelectores () 
  {  
//    System.out.println("p0.x = " + p0.x); //Ocultación!!
    System.out.println("p0.x() = " + p0.x()); 
    System.out.println("p0.y() = " + p0.y()); 
  }
  public static void testModificadores () 
  {  
    System.out.println("p0 = " + p0); 
    System.out.println("p0.ponerX(3);"); 
    p0.ponerX(3);
    System.out.println("p0 = " + p0); 
    System.out.println("p0.ponerY(5);"); 
    p0.ponerY(5);
    System.out.println("p0 = " + p0); 
  }
  public static void testComparadores () 
  {  
    System.out.println(p1 + "==" + p1Replica + " = " + 
                       (p1==p1Replica));
    System.out.println(p1 + ".esIgual(" + p1Replica + ") = " + 
                       p1.esIgual(p1Replica));   
  }
  public static void testAsignacion () 
  {  
    System.out.println("p2 = " + p2); 
    System.out.println("p3 = " + p3); 
    System.out.println("p2 = p3;"); 
    p2 = p3;
    System.out.println("p2 = " + p2); 
    System.out.println("p3 = " + p3); 
  }
  public static void testPintar () 
  {  
    resetear();   
    StdDraw.setXscale(0, 10);
    StdDraw.setYscale(0, 10);
    StdDraw.setPenRadius(0.02);
    p0.pintar();
    p1.pintar();
  }
  public static void main (String[] args) {
    //Inicialización:
    resetear();
    //Constructores:
    mostrar();  //cambiar: aString() --> toString() y comprobar
    //
//    testSelectores();
    //
//    testModificadores();
    //
//    testComparadores();
    //
//    testAsignacion();
    //
//    testPintar();
    //
  }  
  
}