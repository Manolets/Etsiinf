package figuras.punto;
import stdlib.*;
/** 
 * Pruebas del TAD Punto (2/2).
 * 
 * @since 26/02/2016
 * @version 1.1
 * @author Javier Galve   17/02/2020
 */

public class PuntoTest02 {
  
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
  //PRUEBAS de distanciaAlOrigen:
  static boolean prueba1DistanciaAlOrigen () 
  {
    return new Punto(0, 5).distanciaAlOrigen() == 5;
  }
  static boolean prueba2DistanciaAlOrigen ()
  {
    return new Punto(7, 0).distanciaAlOrigen() == 7;
  }
  static boolean prueba3DistanciaAlOrigen ()
  {  
    resetear();
    return p0.distanciaAlOrigen() == 0;
  }
  static boolean prueba4DistanciaAlOrigen ()
  {  
    resetear();
    return p2.distanciaAlOrigen() == 14;
  }
  static boolean prueba5DistanciaAlOrigen ()
  {  
    resetear();
    return p3.distanciaAlOrigen() == 17;
  }  
  static boolean pruebaDistanciaAlOrigen ()
  {
    return 
      prueba1DistanciaAlOrigen() &&
      prueba2DistanciaAlOrigen() &&
      prueba3DistanciaAlOrigen() &&
      prueba4DistanciaAlOrigen() &&
      prueba5DistanciaAlOrigen();
  }
  //PRUEBAS de mover:
  static boolean prueba1mover () 
  {
    resetear();
    p0.mover(0, 0);
    return p0.esIgual(new Punto(0, 0));
  }
  static boolean prueba2mover () 
  {
    resetear();
    p0.mover(1, 1);
    return p0.esIgual(new Punto(1, 1));
  }
  static boolean prueba3mover () 
  {
    resetear();
    p1.mover(1, 0);
    return p1.esIgual(new Punto(2, 1));
  }
  static boolean pruebaMover ()
  {
    return 
      prueba1mover() &&
      prueba2mover() &&
      prueba3mover();
  }
  //PRUEBAS de traslacion:
  static boolean prueba1traslacion () 
  {
    resetear();
    return p0.traslacion(0, 0).esIgual(new Punto(0, 0));
  }
  static boolean prueba2traslacion () 
  {
    resetear();
    return p0.traslacion(1, 1).esIgual(new Punto(1, 1));
  }
  static boolean prueba3traslacion () 
  {
    resetear();
    p1 = p1.traslacion(1, 0);
    return p1.esIgual(new Punto(2, 1));
  }
  static boolean pruebaTraslacion()
  {
    return 
      prueba1traslacion() &&
      prueba2traslacion() &&
      prueba3traslacion();
  }
  public static void main (String[] args) {
    //Inicialización:
    resetear();
    //Constructores:
    mostrar();  //cambiar: aString() --> toString() y comprobar
    //
    //PRUEBAS:
    System.out.println("pruebaDistanciaAlOrigen() = " + 
                       pruebaDistanciaAlOrigen());
    //
    System.out.println("pruebaMover() = " + pruebaMover());
    //
    System.out.println("pruebaTraslacion() = " + 
                       pruebaTraslacion());
  }  
  
}