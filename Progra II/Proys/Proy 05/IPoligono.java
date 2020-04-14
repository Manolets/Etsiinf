/**
 * Especificaci�n de un Poligono<br>
 *
 * @since 02/04/2020
 * @version 1.0
 * @author Javier Galve
 */
// import figuras.punto.*;

public interface IPoligono
{
  /*
   * size () : int
   * POST: N�mero de elementos de la colecci�n.
   */
  public int size ();
  /*
   * get (pos : int) : int
   * PRE: pos IN [0, size()-1]
   * POST: resultado es el elemento de la colecci�n que est� 
   *       en la posici�n <pos>.
   */
  public Punto get (int pos);
  /*
   * set (pos, elem : int)
   * PRE: pos IN [0, size()-1]
   * EFECTO: Modifica el elemento de la colecci�n que est� en 
   *         la posici�n <pos> poniendo <elem>.
   */
  public void set (int pos, Punto elem);
  /*
   * toString () : String 
   * POST: Devuelve la cadena de caracteres formada por los
   *       atributos de la colecci�n.
   */
  public String toString ();
  /*
   * add (elem : int)
   * EFECTO: A�ade el elemento <elem> a la colecci�n, poni�ndolo 
   *         al final.
   */
  public void add (Punto elem);
  /*
   * add (pos, elem : int)
   * PRE: pos IN [0, size()]
   * EFECTO: A�ade el elemento <elem> a la colecci�n, poni�ndolo 
   *         en la posicion <pos>.
   */
  public void add (int pos, Punto elem);
  /*
   * indexOf (elem : int) : int
   * POST: Devuelve la posicion donde se encuentra <elem>.
   *       Si no se encuentra, el resultado es -1
   */
  public int indexOf (Punto elem);
  /*
   * removeElementAt (pos : int)
   * PRE: pos IN [0,size()-1]
   * EFECTO: Elimina el elemento que est� en la posici�n <pos>.
   *         Mueve todos los elementos en [pos+1, size()-1] un lugar 
   *         a la izquierda.
   *         El objeto pasa a tener un elemento menos.
   */
  public void removeElementAt (int pos) ;
  /**
   * remove (elem : int) : boolean 
   * EFECTO: Si existe un elemento igual a <elem> en la colecci�n, 
   *         lo elimina y devuelve true. En caso contrario 
   *         devuelve false.
   */ 
  public boolean remove (Punto elem);
  /**
   * pintar ()
   * EFECTO: Pinta este Poligono en el lienzo.
   */
  public void pintar ();
  /*
   * esMenor (p : Poligono) : boolean
   * POST: Determina si este Poligono es menor 
   *       que <p> en el sentido de que est� 
   *       formado por un n�mero inferior de puntos.
   */
  boolean esMenor (Poligono p);
  /*
   * linea () : String
   * POST: Retorna este Poligono como una l�nea de texto
   *       formada por todos los puntos que la componen,
   *       con cada punto separado del anterior por 
   *       un espacio.
   */
  public String linea ();
  
}