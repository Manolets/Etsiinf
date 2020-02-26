//package fecha;
/** 
 * Programa FechaOpsTest. 
 * Pruebas de la clase Fecha.
 * 
 * @since 28/02/2019
 * @version 1.0   21/02/2018
 * @author Javier Galve  
 */
public class FechaOpsTest 
{
  static Fecha f1 = new Fecha(0, 6, 1978); 
  static Fecha f2 = new Fecha(1, 6, 1978); 
  static Fecha f3 = new Fecha(1, 14, 1978); 
  static Fecha f4 = new Fecha(31, 6, 1978); 
  static Fecha f5 = new Fecha(31, 1, 2016); 
  static Fecha f6 = new Fecha(1, 2, 2016); 
  static Fecha f7 = new Fecha(31, 12, 2016); 
  static Fecha f8 = new Fecha(1, 1, 2017); 
  static Fecha f9 = new Fecha(2, 2, 2016); 
  static Fecha hoy = Fecha.hoy(); 
  static Fecha mañana = hoy.fechaSiguiente();
  static Fecha pasadoMañana = hoy.fechaSiguiente().fechaSiguiente();
  /*
   * PRUEBAS:
   */
  //  edad:
  static boolean prueba1edad = 
    FechaOps.edad(Fecha.hoy(), new Fecha(24, 11, 1964)) == 55;
  static boolean prueba2edad = 
    FechaOps.edad(Fecha.hoy(), new Fecha(24, 11, 1970)) == 49;
  static boolean prueba3edad = 
    FechaOps.edad(Fecha.hoy(), new Fecha(28, 12, 1980)) == 39;
  static boolean pruebaEdad = 
    prueba1edad &&
    prueba2edad &&
    prueba3edad ;
         
  //  diasEntreFechas:
  static boolean prueba1diasEntreFechas = 
    FechaOps.diasEntreFechas(f7, f8) == 1;
  static boolean prueba2diasEntreFechas = 
    FechaOps.diasEntreFechas(f8, new Fecha(1, 1, 2018)) == 365;
  static boolean prueba3diasEntreFechas = 
    FechaOps.diasEntreFechas(f6, new Fecha(6, 2, 2016)) == 5;
  static boolean prueba4diasEntreFechas = 
    FechaOps.diasEntreFechas(f8, f8) == 0;
  static boolean prueba5diasEntreFechas = 
    FechaOps.diasEntreFechas(f6, f4) == 0;
  static boolean pruebaDiasEntreFechas = 
    prueba1diasEntreFechas &&
    prueba2diasEntreFechas &&
    prueba3diasEntreFechas &&
    prueba4diasEntreFechas &&
    prueba5diasEntreFechas;

//  //  fechaTrasDias:
//  static boolean prueba1fechaTrasDias = 
//    f5.fechaTrasDias(1).esIgual(f6);
//  static boolean prueba2fechaTrasDias = 
//    f8.fechaTrasDias(5).esIgual(new Fecha(6, 1, 2017));
//  static boolean prueba3fechaTrasDias = 
//    f6.fechaTrasDias(20).esIgual(new Fecha(21, 2, 2016));
//  static boolean prueba4fechaTrasDias = 
//    f5.fechaTrasDias(0).esIgual(f5);
//  static boolean pruebaFechaTrasDias = 
//    prueba1fechaTrasDias &&
//    prueba2fechaTrasDias &&
//    prueba3fechaTrasDias &&
//    prueba4fechaTrasDias;


//  //estaEnIntervalo :
//  static boolean prueba1estaEnIntervalo = 
//    f5.estaEnIntervalo(f5, f6) == true;
//  static boolean prueba2estaEnIntervalo = 
//    f5.estaEnIntervalo(f4, f6) == true;
//  static boolean prueba3estaEnIntervalo = 
//    f5.estaEnIntervalo(f6, f7) == false;
//  static boolean pruebaEstaEnIntervalo =
//    prueba1estaEnIntervalo &&
//    prueba2estaEnIntervalo &&
//    prueba3estaEnIntervalo;
//
  public static void main (String[] args) 
  {   
    System.out.println("pruebaEdad = " + 
                       pruebaEdad);
    System.out.println("pruebaDiasEntreFechas = " + 
                       pruebaDiasEntreFechas);
  }
}
