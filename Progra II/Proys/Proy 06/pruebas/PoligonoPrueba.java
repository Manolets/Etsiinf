package pruebas;
import figurasZxZ.*;
import stdlib.*;
import java.awt.Color;
/** 
 * Pruebas de Poligono.
 * 
 * @since 17/04/2018  
 * @version 1.0
 * @author JMB y JGF
 */
public class PoligonoPrueba
{
  public static PuntoZxZ p0, p1, p2, p3, p4, p5, p6, p7;
  public static PuntoZxZ[] arr1, arr2, arr3, arr5, array3;

  static Poligono pol1, pol2, pol3;
  static Poligono triangulo, pentagono;
  static Poligono pol1Replica, pol2Replica, pol3Replica;

  public static int aleatorio (int n)
  { 
    return (int)(Math.random() * Math.abs(n+1));
  }
  public static void resetear ()
  {
    p0 = new PuntoZxZ(160, 80);
    p1 = new PuntoZxZ(200, 100);
    p2 = new PuntoZxZ(180, 40);
    p3 = new PuntoZxZ(120, 300);
    p4 = new PuntoZxZ(250, 300);
    p5 = new PuntoZxZ(250, 360);
    p6 = new PuntoZxZ(210, 370);
    p7 = new PuntoZxZ(150, 380);
    //
    arr1 = new PuntoZxZ[]{p0};
    pol1 = new Poligono(arr1);
    //
    arr2 = new PuntoZxZ[]{p1, p2};
    pol2 = new Poligono(arr2);
    //
    array3 = new PuntoZxZ[]{p3, p4, p5};
    pol3 = new Poligono(array3);
    //
    arr3 = new PuntoZxZ[]{p0, p1, p2};
    arr5 = new PuntoZxZ[]{p3, p4, p5, p6, p7};
    //
    triangulo = new Poligono(arr3);
    pentagono = new Poligono(arr5);
    //
    pol1Replica = new Poligono(arr1);
    pol2Replica  = new Poligono(arr2);
    pol3Replica = new Poligono(array3);
  }
  public static void mostrar ()
  {
    resetear();
    System.out.println("pol1 = " + pol1);
    System.out.println("pol2 = " + pol2);
    System.out.println("pol3 = " + pol3);
    System.out.println("triangulo = " + triangulo);
    System.out.println("pentagono = " + pentagono);
  }
  public static void pruebaPintar ()
  { 
    resetear();
    Tablero.iniciar();
//    pol1.pintar(); 
//    pol2.pintar();
//    pol3.pintar();
//    triangulo.pintar();
    pentagono.pintar();
  }
  static boolean prueba1equals () 
  {
    resetear();
    return pol1.equals(pol1Replica);
  }
  static boolean prueba2equals () 
  {
    resetear();
    return pol2.equals(pol2Replica);
  }
  static boolean prueba3equals () 
  {
    resetear();
    return !pol2.equals(pol1Replica);
  }
  static boolean pruebaEquals ()
  {
    return 
      prueba1equals() &&
      prueba2equals() &&
      prueba3equals();
  }
  public static void main (String args[])
  {
    //Constructores:
//    mostrar();
    //
    //Métodos:
//    System.out.println("pruebaEquals() = " + pruebaEquals());
    //Gráficos:
//    pruebaPintar();
    //
  }
} 