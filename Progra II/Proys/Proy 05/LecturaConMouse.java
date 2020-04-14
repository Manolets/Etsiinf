/**
 * Lectura de un Punto, un Poligono y una 
 * ListaDePoligonos con el rat�n.<br>
 * @since 30/03/2020
 * @version 1.1     31/03/2020
 *    - Mejora sobre PoligonoMouse.
 *    - A�adida operaci�n leerListaDePoligonos
 * @author Javier Galve
 */
// import figuras.punto.*;
// import stdlib.*;

public class LecturaConMouse
{
  /**
   * leerPunto () : Punto
   * POST: Retorna el Punto donde est� localizado el
   *       rat�n al pulsarlo.
   */
  public static Punto leerPunto ()
  {
    Punto p = null;
    boolean leido = false;
    while (!leido)  
    {
      if (StdDraw.isMousePressed())
      {
        p = new Punto(StdDraw.mouseX(), 
                      StdDraw.mouseY());
        p.pintar();
        leido = true;
      }
    }
    return p;
  }
  /**
   * leerPoligono () : Poligono
   * POST: Retorna el Poligono le�do Punto a Punto
   *       mediante el rat�n.
   *       Se lee primero el numero de puntos que va
   *       a tener el Poligono y despu�s cada Punto se 
   *       separa del siguiente pulsando la barra de 
   *       espacio.
   */
  public static Poligono leerPoligono ()
  {
    StdDraw.clear();
    System.out.println("Número de puntos del polígono> ");
    int n = StdIn.readInt();
    System.out.println("Marque cada punto en la ventana gráfica " +
                       "con el ratón y pulse después la tecla " +
                       "de espacio...");
    int leidos = 0;
    Poligono polig = new Poligono();
    while (leidos <= n-1)
    {
      Punto p = leerPunto();
      //Esperar a que se pulse la tecla de espacio:
      do {} while (!StdDraw.isKeyPressed(32));
      polig.add(p);
      leidos = leidos + 1;
    }
    return polig;
  }

  /**
   * leerListaDePoligonos () : ListaDePoligonos
   * POST: Retorna la ListaDePoligonos leída Poligono a
   *       Poligono mediante el ratón.
   *        Se lee primero el numero de Polígonos que va
   *        a tener la ListaDePoligonos.
   */
  public static ListaDePoligonos leerListaDePoligonos(){
    System.out.println("Cuantos polígonos va a tener la lista?");
    int num = StdIn.readInt();
    ListaDePoligonos lista = new ListaDePoligonos();
    Poligono temp;
    for (int i = 0; i < num; i++) {
      temp = leerPoligono();
      lista.add(temp);
    }
    return lista;
  }
}