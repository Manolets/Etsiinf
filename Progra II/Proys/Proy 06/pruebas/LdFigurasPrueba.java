package pruebas;
import figurasZxZ.*;
import ldfiguras.*;
import auxi.*;
import stdlib.*;
/** 
 * Pruebas de LdFiguras.
 * 
 * @since 17/04/2017  
 * @version 1.1    17/04/2018  Javier Galve
 * @author Javier Galve
 */
public class LdFigurasPrueba
{  
  public static Figura c1;
  public static Figura c2;
  public static Figura c3;
  public static Figura r1;
  public static Figura r2;
  public static Figura d1;
  public static Figura d2;
  //Poligonos:
  public static Figura triangulo;
  public static Figura pentagono;
  //Listas:
  public static LdFiguras ldf0, ldf1, ldf2, ldf3, ldf5;
  //
  public static LdFiguras ldf1Replica, ldf2Replica, ldf3Replica;

  public static void resetear ()
  {
    FiguraPrueba.resetear();
    PoligonoPrueba.resetear();
    //
    c1 = new Circulo(new PuntoZxZ(100, 200), 15);
    c2 = new Circulo(new PuntoZxZ(40, 80), 10);
    c3 = new Circulo();
    //
    r1 = new Rectangulo(new PuntoZxZ(150, 210), 200, 100);
    r2 = new Rectangulo(new PuntoZxZ(300, 160), 50, 100);
    //
    d1 = new Dot(new PuntoZxZ(100, 100));
    d2 = new Dot(new PuntoZxZ(45, 35));    
    //
    //Poligonos:
    //
    triangulo = new Poligono(PoligonoPrueba.arr3);
    pentagono = new Poligono(PoligonoPrueba.arr5);
    //
    //Listas:
    //
    ldf0 = new LdFiguras();
    //
    ldf1 = new LdFiguras();
    ldf1.add(d1); 
    //
    ldf2 = new LdFiguras();
    ldf2.add(r2); 
    ldf2.add(r1); 
    //
    ldf3 = new LdFiguras();
    ldf3.add(c1); 
    ldf3.add(c2); 
    ldf3.add(c3); 
    //
    ldf5 = new LdFiguras();
    ldf5.add(c1); 
    ldf5.add(r1); 
    ldf5.add(d1); 
    ldf5.add(c2);
    ldf5.add(r2);   
    ldf5.add(triangulo);
    ldf5.add(pentagono);    
  }
  public static void mostrar ()
  {
    resetear();
    System.out.println("ldf0 = " + ldf0);
    System.out.println("ldf1 = " + ldf1);
    System.out.println("ldf2 = " + ldf2);
    System.out.println("ldf3 = " + ldf3);
    System.out.println("ldf5 = " + ldf5);
  }
  public static void pruebaPintar ()
  { 
    resetear();
    Tablero.iniciar();
    ldf1.pintar();
    ldf2.pintar();
    ldf3.pintar();
    ldf5.pintar();
  }
  public static void main (String args[])
  {     
    //Creación:
//    mostrar();
    //
    //Gráficos:
    pruebaPintar();
    //
  }
} 