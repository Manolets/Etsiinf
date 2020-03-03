//package fecha;
import java.util.*;
/** 
 * Algunas pruebas de la clase Fecha.
 * 
 * @since 4/02/2016 
 * @version 2.3   19/02/2020
 * @author Javier Galve  
 */
public class FechaTest 
{
  static Fecha f0 = new Fecha(0, 6, 1978); 
  static Fecha f1 = new Fecha(0, 6, 1978); 
  static Fecha f2 = new Fecha(1, 6, 1978); 
  static Fecha f3 = new Fecha(1, 14, 1978); 
  static Fecha f4 = new Fecha(31, 6, 1978); 
  static Fecha f5 = new Fecha(31, 1, 2016); 
  static Fecha f6 = new Fecha(1, 2, 2016); 
  static Fecha f7 = new Fecha(31, 12, 2016); 
  static Fecha f8 = new Fecha(1, 1, 2017); 
  static Fecha f9 = new Fecha("2/2/2016"); 
  static Fecha hoy = Fecha.hoy(); 
  static Fecha mañana = Fecha.mañana();
  static Fecha pasadoMañana = Fecha.mañana().fechaSiguiente();
  /*
   * PRUEBAS:
   */
  
  //  esFechaCorrecta:
  static boolean prueba1EsFechaCorrecta = 
    f1.esFechaCorrecta() == false;
  static boolean prueba2EsFechaCorrecta = 
    f2.esFechaCorrecta() == true;
  static boolean prueba3EsFechaCorrecta = 
    f3.esFechaCorrecta() == false;
  static boolean prueba4EsFechaCorrecta = 
    f4.esFechaCorrecta() == false;
  static boolean pruebaEsFechaCorrecta = 
    prueba1EsFechaCorrecta &&
    prueba2EsFechaCorrecta &&
    prueba3EsFechaCorrecta &&
    prueba4EsFechaCorrecta;

  //  esIgual:
  static boolean prueba1esIgual = 
    f5.esIgual(f5) == true;
  static boolean prueba2esIgual = 
    f5.esIgual(f2) == false;
  static boolean prueba3esIgual = 
    f7.esIgual(f8) == false;
  static boolean pruebaEsIgual = 
    prueba1esIgual &&
    prueba2esIgual &&
    prueba3esIgual;
  
  //  esMenor:
  static boolean prueba1esMenor = 
    f5.esMenor(f5) == false;
  static boolean prueba2esMenor = 
    f5.esMenor(f2) == false;
  static boolean prueba3esMenor = 
    f7.esMenor(f8) == true;
  static boolean pruebaEsMenor = 
    prueba1esMenor &&
    prueba2esMenor &&
    prueba3esMenor;
  
  //  fechaSiguiente:
  static boolean prueba1fechaSiguiente = 
    f6.fechaSiguiente().esIgual(f9);
  static boolean prueba2fechaSiguiente = 
    f5.fechaSiguiente().esIgual(f6);
  static boolean prueba3fechaSiguiente = 
    f7.fechaSiguiente().esIgual(f8);
  static boolean pruebaFechaSiguiente = 
    prueba1fechaSiguiente &&
    prueba2fechaSiguiente &&
    prueba3fechaSiguiente;
  static void pruebaEscribirModoGrafico ()
  {
    Fecha.hoy().escribirModoGrafico(50, 50, 200);
  }
  public static void main (String[] args) 
  {   
   System.out.println("f2 = " + f2);
    
   System.out.println("f9 = " + f9);
       
    System.out.println("pruebaEsIgual = " + 
                       pruebaEsIgual);
       
   System.out.println("pruebaEsMenor = " + 
                      pruebaEsMenor);
    
   System.out.println("pruebaEsFechaCorrecta = " + 
                      pruebaEsFechaCorrecta);
    
   System.out.println("pruebaDate = " + 
                      new Date());
    
   System.out.println("hoy = " + hoy);
    
   System.out.println("pruebaFechaSiguiente = " + 
                      pruebaFechaSiguiente);
    
   System.out.println("mañana = " + mañana);
    
   System.out.println("pasado mañana = " + pasadoMañana);
       
   pruebaEscribirModoGrafico();
   }
}
