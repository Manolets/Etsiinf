/**
 * Lista de Poligonos implementada haciendo uso de
 * un ArrayList<Poligono>.<br>
 *
 * @since 02/04/2020 
 * @version 1.0    
 * @author Javier Galve
 */

public interface IListaDePoligonos
{
  /*
   * toString () : String
   * POST: Retorna la ListaDePoligonos como texto.
   */
  public String toString ();
  /*
   * add (p : Poligono)
   * EFECTO: A�ade el Poligono <p> a la ListaDePoligonos, 
   *         poni�ndolo al final.
   */
  public void add (Poligono c);
  /*
   * size () : int
   * POST: Retorna el tama�o de la ListaDePoligonos.
   */
  public int size ();
  /*
   * get (pos : int) : Poligono
   * PRE: pos IN [0, size()-1]
   * POST: Retorna el elemento de la ListaDePoligonos que est� 
   *       en la posici�n <pos>.
   */
  public Poligono get (int pos);
  /*
   * set (pos : int; elem : Poligono)
   * PRE: pos IN [0, size()-1]
   * EFECTO: Modifica el elemento de la colecci�n que est� en 
   *         la posici�n <pos> poniendo <elem>.
   */
  public void set (int pos, Poligono elem);
  /*
   * removeElementAt (pos : int)
   * PRE: pos IN [0, size()-1]
   * EFECTO: Elimina de esta ListaDePoligonos el <Poligono> 
   *         que est� en la posici�n <pos>. 
   */
  public void removeElementAt (int pos);
  /*
   * addOrd (elem : Poligono)
   * PRE: La colecci�n est� ordenada crecientemente por el 
   *      tama�o (n�mero de puntos) del poligono.
   * EFECTO: A�ade el elemento <elem> a la colecci�n, poni�ndolo 
   *         en la posicion que le corresponda para mantener 
   *         el orden creciente.
   */
  public void addOrd (Poligono elem);
   /**
   * pintar ()
   * EFECTO: Pinta esta ListaDePoligonos en el lienzo.
   */
  public void pintar ();
 
}