import java.util.*;
import java.text.*;
import java.awt.*;
//import stdlib.*;
/** 
 * Operaciones de Fecha.
 * 
 * @since 19/02/2020    
 * @version 1.0    
 * @author 
 */
public class FechaOps
{
  /**
   * esMenorOIgual (f1, f2 : Fecha)
   * POST: Determina si <f1> es menor o igual que <f2>
   *       en sentido cronol�gico.
   */ 
  public static boolean esMenorOIgual (Fecha f1, Fecha f2) 
  {
    return f1.esMenor(f2) || f1.esIgual(f2);
  }
  /**
   * esMenorOIgual (dia1, mes1, dia2, mes2 : int) : boolean
   * POST: Determina si la Fecha (<dia1>, <mes1>) 
           es menor en sentido cronol�gico que la 
           Fecha (<dia2>, <mes2>).     
   */
  public static boolean esMenorOIgual (int dia1, int mes1, int dia2, int mes2) 
  {
    return
      (mes1 < mes2)  ||
      (mes1 == mes2 && dia1 < dia2);
  }
  /**
   * estaEnIntervalo (f, fecha1, fecha2 : Fecha) : Boolean
   * POST: Determina si la Fecha f est� en el intervalo 
          [fecha1, fecha2].       
   */         
  public static boolean estaEnIntervalo (Fecha f,
                                         Fecha fecha1, 
                                         Fecha fecha2) { 
    return false;
  }  
  /**
   * edad (f, nac : Fecha) : int
   * POST: Calcula la edad (en años) que se tiene al d�a de la 
   *       fecha <f> conociendo la Fecha de nacimiento <nac>.
   */         
  public static int edad (Fecha f, Fecha nac) {
    return 0;
  }
  /**
   * diasEntreFechas (fecha1, fecha2 : Fecha) : int
   * POST: Devuelve el n�mero de d�as transcurridos
          entre <fecha1> y <fecha2>.
   */ 
  public static int diasEntreFechas (Fecha fecha1, Fecha fecha2) 
  { 
    return 0;
  }
  public static Fecha leer () {
   System.out.print("dia>");
   int dia = StdIn.readInt(); 
   System.out.print("mes>");
   int mes = StdIn.readInt(); 
   System.out.print("año>");
   int año = StdIn.readInt(); 
   return new Fecha(dia, mes, año);
  }
}
