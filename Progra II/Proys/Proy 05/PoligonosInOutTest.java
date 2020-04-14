import java.io.IOException;

/**
 * Pruebas de PoligonosInOut<br>
 * 
 * @since 31/03/2020
 * @version 1.0
 * @author Javier Galve
 */
// import stdlib.*;

public class PoligonosInOutTest {
  static final int XMAX = 15;
  static final int YMAX = 15;

  static void iniciarGraficos() {
    StdDraw.setXscale(-XMAX, XMAX);
    StdDraw.setYscale(-YMAX, YMAX);
    StdDraw.setPenRadius(0.02);
    StdDraw.setPenColor(StdDraw.BLUE);
    // StdDraw.setPenColor(StdDraw.RED);
  }

  public static void test1EscribirPoligono() {
    PoligonoTest.resetear();
    System.out.println(PoligonoTest.triangulo.linea());
  }

  /**
   * test2EscribirPoligono () EFECTO: Escribe el Poligono "PoligonoTest.triangulo"
   * en el archivo "files/pol2.txt". PRE: Se necesita crear una subcarpeta de
   * nombre "files" en la carpeta actual para ejecutar esta prueba.
   */
  public static void test2EscribirPoligono() {
    PoligonoTest.resetear();
    PoligonosInOut.escribir(PoligonoTest.triangulo, "files/pol2.txt");
  }

  /**
   * testEscribirListaDePoligonos () EFECTO: Escribe la ListaDePoligonos
   * "ListaDePoligonosTest.listaDePol4" en el archivo "files/ldp4.txt". PRE:
   * Se necesita crear una subcarpeta de nombre "files" en la carpeta actual para
   * ejecutar esta prueba.
   */
  public static void testEscribirListaDePoligonos() {
    ListaDePoligonosTest.resetear();
    PoligonosInOut.escribir(ListaDePoligonosTest.listaDePol4, "files/ldp4.txt");
  }

  /**
   * testLeerListaDePoligonos () EFECTO: Lee una ListaDePoligonos del archivo
   * "files/ldp4.txt". y la escribe en la salida est�ndar y la pinta en un
   * panel gr�fico. PRE: Se necesita crear una subcarpeta de nombre "files" en la
   * carpeta actual para ejecutar esta prueba.
   * 
   * @throws IOException
   */
  public static void testLeerListaDePoligonos() throws IOException
  {
    ListaDePoligonos ldp = 
      PoligonosInOut.leer("files/ldp4.txt");
    System.out.println("ldp = " + ldp);
    ldp.pintar();
  }

  public static void testLeerPoligono() throws IOException {
    Poligono p = PoligonosInOut.leer("files/pol1.txt").get(0);
    p.pintar();
  }

  public static void testescribirDeInput1(){
    Poligono p = LecturaConMouse.leerPoligono();
    PoligonosInOut.escribir(p, "files/pol1.txt");
    p.pintar();
  }

  public static void testescribirDeInput2(){
    ListaDePoligonos lista = LecturaConMouse.leerListaDePoligonos();
    PoligonosInOut.escribir(lista, "files/pol3.txt");
    lista.pintar();
  }

  public static void testleerDeEscrito() throws IOException {
    ListaDePoligonos ldp = PoligonosInOut.leer("files/pol3.txt");
    ldp.pintar();
  }

  public static void main (String[] args) throws IOException
  {
    //  test1EscribirPoligono(); 
    
    //  test2EscribirPoligono();
    
    //  testEscribirListaDePoligonos();

    iniciarGraficos();

    // testescribirDeInput1();

    // testLeerPoligono();

    // testescribirDeInput2();
    
    // testLeerListaDePoligonos();

    // testleerDeEscrito();
  }
}