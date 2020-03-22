/**
 * ListaDeContactos
 */
public class ListaDeContactos {

    private Contacto[] elementos;
    private int longitud;
    public ListaDeContactos(){};

    /** 
     * ListaDeContactos (maxNumContactos : int)
    */
    public ListaDeContactos(int i){
        longitud = i;
        elementos = new Contacto[longitud];
    }

    /**
     * toString () : String
     * POST: Retorna la ListaDeContactos como texto.
     */
    public String toString(){
        String result = "";
        for (Contacto contacto : elementos) {
            if(contacto instanceof Contacto)
                result += contacto.toString() + "\n";
        }
        return result;
    }

    /** 
     * size () : int
     * POST: Da el número de contactos que hay en la colección.
    */
    public int size(){
        return longitudArray(elementos);
    }

    private int longitudArray(Contacto[] lista){
        int count = 0;
        for (Contacto contacto : lista) {
            if(contacto != null)
                count++;
        }

        return count;
    }

    /**
     * get (pos : int) : Contacto
     * PRE: pos IN [0, longitud-1] 
     * POST: Da el Contacto que está en <pos> en la colección.
     */
    public Contacto get(int pos){
        return elementos[pos];
    }

    /**
     * set (pos : int; elem : Contacto)
     * PRE: pos IN [0, longitud-1]
     * EFECTO: Añade <elem> a la colección, poniéndolo en la
     * posición <pos>, sin abrir hueco, es decir,
     * cambiando lo que hubiera por <elem>.
     */
    public void set(int pos, Contacto elem){
        elementos[pos] = elem;
    }

    /**
     * add (elem : Contacto)
     * EFECTO: Añade el elemento <elem> a la colección, poniéndolo al final.
     */
    public void add(Contacto elem){
        if (longitudArray(elementos) == elementos.length){
            elementos[elementos.length] = elem;
        } else {
            elementos[longitudArray(elementos)] = elem;
        }
    }

    /**
     * add (pos : int, elem : Contacto)
     * PRE: pos IN [0, longitud]
     * EFECTO: Añade el elemento <elem> a la colección, poniéndolo
     * en la posicion <pos>, abriendo hueco.
     */
    public void add(int pos, Contacto elem){
        for (int i = elementos.length; i < pos; i--) {
            elementos[i] = new Contacto(elementos[i - 1]);
        }
        elementos[pos] = elem;
    }

    /**
     * indexOf (elem : Contacto) : int
     * POST: Devuelve la posicion donde se encuentra <elem>.
     * Si no se encuentra, el resultado es -1.
     */
    public int indexOf(Contacto elem){
        int index = -1;
        for (int i = 0; i < elementos.length; i++) {
            if(elementos[i].equals(elem))
                index = i;
        }
        return index;
    }

    /**
     * removeElementAt (pos : int)
     * PRE: pos IN [0,longitud-1]
     * EFECTO: Elimina el elemento que está en la posición <pos>.
     * Mueve todos los elementos en [pos+1, size()-1] un
     * lugar a la izquierda. El objeto pasa a tener un
     * elemento menos.
     */
    public void removeElementAt(int pos){
        for (int i = pos; i < elementos.length; i++) {
            elementos[i] = new Contacto(elementos[i + 1]);
        }
    }

    /**
     * remove (elem : Contacto) : boolean
     * EFECTO: Si existe un elemento igual a <elem> en la
     * colección, lo elimina y devuelve true. En caso
     * contrario devuelve false.
     */
    public boolean remove(Contacto elem){
        boolean is = false;
        int pos = indexOf(elem);
        if(pos != -1) {
            is = true;
            removeElementAt(pos);
        }
        return is;
    }

    /**
     * maxSize () : int
     * POST: Da la capacidad máxima de la colección.
     */
    public int maxSize(){
        return longitud;
    }
}