//import java.util.*;
// import java.text.*;
import java.awt.*;
// import java.io.*;
//import stdlib.*;

/** 
 * Implementaci�n del TAD Fecha.
 * 
 * @since 20/02/2020  
 * @version 1.0    
 * @author 
 */

public class Fecha 
{
  private int dia;
  private int mes;
  private int año;
  
  public Fecha () {
  }

  public Fecha (int dia, int mes, int año) {
    this.dia = dia;
    this.mes = mes;
    this.año = año;
  }

  public Fecha (String date) {
    String [] partes = date.split("/");
    dia = Integer.parseInt(partes[0]);
    mes = Integer.parseInt(partes[1]);
    año = Integer.parseInt(partes[2]);
  }

  public int dia () {
    return dia;
  }

  public int mes () {
    return mes;
  }

  public int año () {
    return año;
  }

  public String toString () {
    return "[" + dia + "/" + mes + "/" + año + "]";
  }

  /** 
   * esBisiesto (int año) : Boolean 
   * POST: Determina si <año> es bisiesto
   * POST: resultado = << <año> es un multiplo de 4 que 
   *                   no es el año 0 de un siglo o 
   *                   es un multiplo de 400 >>
   */
  private boolean esBisiesto (int año) {
    return (año % 4 == 0 && !(año % 100 == 0)) || (año % 400 == 0);
  }
  /**
   * diasDeFebrero (año : Entero) : Entero
   * POST: Devuelve el n�mero de d�as que tiene el mes de
   *       Febrero de <año>
   */
  private int diasDeFebrero (int año) {
    if (esBisiesto(año))
      return 29;
    return 28;
  }
  /**
   * diasDelMes (mes, año : int) : int
   * PRE: mes IN [1, 12]
   * POST: Calcula el n�mero de d�as del <mes> 
   *      (para este <año> en el caso de Febrero).
   * POST:
   *   mes IN {4, 6, 9, 11} --> 30
   *   mes IN {1, 3, 5, 7, 8, 10, 12} --> 31
   *   mes = 2 --> diasDeFebrero(año)
   */
  private int diasDelMes (int mes, int año) {
    if (mes == 2)
      return diasDeFebrero(año);
    
    if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
      return 31;
    }
    return 30;
  } 
  /** 
   * esFechaCorrecta () : Boolean
   * POST: resultado = f.mes IN [1, 12] and 
   *                   f.dia IN [1, diasDelMes(f.mes, f.año)]
   EJEMPLOS:
     (0/6/1978).esFechaCorrecta() = false
     (1/6/1978).esFechaCorrecta() = true
     (1/14/1978).esFechaCorrecta() = false
     (31/6/1978).esFechaCorrecta() = false
   */   
  public boolean esFechaCorrecta () {
    if (dia < 1 || mes < 1 || mes > 12)
      return false;
    if (dia <= diasDelMes(mes, año))
      return true;
    return false;
  }
  /** 
   * esIgual (f : Fecha) : Boolean
   * POST: Determina si esta fecha es igual a <f>.
   */
  boolean esIgual (Fecha f) {
    if (f.dia == this.dia && f.mes == this.mes && f.año == this.año)
      return true;

    return false;
  }
  /**
   * esMenor (f : Fecha) : Boolean
   * POST: Determina si esta fecha es menor que <f>
   *       en sentido cronol�gico.
   */ 
  public boolean esMenor (Fecha f) {
    if (f.año > this.año) {
      return true;
    } else if (f.mes > this.mes && f.año == this.año) {
       return true;
    } else if (f.dia > this.dia && f.año == this.año && f.mes == this.mes) {
      return true; 
    }
    return false;
  }
  /**
   * fechaSiguiente () : Fecha
   * POST: Devuelve la Fecha siguiente a esta, es decir, 
   *       incrementada en un d�a.
   */ 
  public Fecha fechaSiguiente () {
    if (dia < diasDelMes(mes, año))
      return new Fecha(dia + 1, mes, año);
    else if (dia == diasDelMes(mes, año) && mes < 12)
      return new Fecha(1, mes + 1, año);
    else
      return new Fecha(1, 1, año + 1);
  }
  /**
   * mes (name : String) : int 
   * PRE: name IN months
   * POST: Devuelve el n�mero de mes en [1, 12]
   *       que corresponde a un nombre (<name>) 
   *       de mes en ingles con 3 letras:
   * DONDE:
   *       months = 
   *         {Jan, Feb, Mar, Apr, May, Jun, 
   *          Jul, Aug, Sep, Oct, Nov, Dec} 
   */ 

   public boolean estaEnIntervalo(Fecha fecha1, Fecha fecha2){
    Fecha f = new Fecha(dia, mes, año);
    return FechaOps.estaEnIntervalo(f, fecha1, fecha2);
   }


  public static int mes (String name) 
  {
    String[] months = 
      {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
       "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} ;
    boolean encontrado = false;
    int i = 0;
    while (i <= months.length && !encontrado)
    { 
      if (months[i].equals(name))
        encontrado = true;
      else
        i = i + 1;
    }
    return i+1;
  }
  /**
   * hoy () : Fecha
   * POST: Devuelve la Fecha de hoy.
   */ 
  public static Fecha hoy() {
    String fecha = ("" + java.time.LocalDate.now()).replace("-", "/");
    String partes[] = fecha.split("/");
    return new Fecha(Integer.parseInt(partes[2]), Integer.parseInt(partes[1]), Integer.parseInt(partes[0]));
  }
  /**
   * ma�ana () : Fecha
   * POST: Devuelve la Fecha de ma�ana.
   */ 
  public static Fecha mañana () {
    return (hoy().fechaSiguiente());
  }  

  private static void iniciarGraficos () 
  {  
    int XMAX = 700;
    int YMAX = 700;
    int ESCALAX = 100;
    int ESCALAY = 100;
    StdDraw.setCanvasSize(XMAX, YMAX);
    StdDraw.setXscale(0, ESCALAX);
    StdDraw.setYscale(0, ESCALAY);
    StdDraw.setPenRadius(0.02);
  }  
   public void escribirModoGrafico (int xTexto, 
                                   int yTexto, 
                                   int tamañoTexto) 
  {  
    iniciarGraficos();
    Font font = new Font("Arial", Font.BOLD, tamañoTexto/2);
    StdDraw.setFont(font);
    StdDraw.text(xTexto, yTexto, this.toString());
  }  

}
