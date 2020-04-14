/**
 * Agenda
 * @version 1.0
 * @author Manuel López-Cerón Corredor
 */
public class Agenda {

    private ListaDeContactos ldc;

    public Agenda(){
        ldc = new ListaDeContactos(100);
    }

    /**
     * toString () : String
     * POST: Retorna la Agenda como texto.
     */
    public String toString(){
        return ldc.toString();
    }

    /**
     * estaVacia () : boolean
     * POST: Determina si esta Agenda está vacía.
     */
    public boolean estaVacia(){
        return ldc.size() == 0;
    }

    /**
     * estaLlena () : boolean
     * POST: Determina si esta Agenda está llena.
     */
    public boolean estaLlena(){
        return ldc.size() == ldc.maxSize();
    }

    /**
     * añadirContacto (c : Contacto)
     * EFECTO: Añade el Contacto <c> a esta Agenda,
     * poniéndolo al final.
     */
    public void añadirContacto(Contacto c){
        ldc.add(c);
    }

    /**
     * size () : int
     * POST: Retorna el tamaño de la agenda.
     */
    public int size(){
        return ldc.size();
    }

    /**
     * get (pos : int) : Contacto
     * PRE: pos IN [0, size()-1]
     * POST: Retorna el elemento de la agenda que está
     * en la posición <pos>.
     */
    public Contacto get(int pos){
        return ldc.get(pos);
    }

    /**
     * set (pos : int; elem : Contacto)
     * PRE: pos IN [0, size()-1]
     * EFECTO: Modifica el elemento de la colección que
     * está en la posición <pos> poniendo <elem>.
     */
    public void set(int pos, Contacto elem){
        ldc.set(pos, elem);
    }

    /**
     * nombresContactos () : String
     * POST: Retorna un listado de los nombres que están
     * en esta Agenda, cada nombre en una línea.
     */
    public String nombresContactos(){
        String result = "";
        for (int i = 0; i < ldc.size(); i++) {
            result += ldc.get(i).nombre() + "\n";            
        }
        return result;
    }

    /**
     * buscarNombre (nombre : String) : Contacto
     * POST: Devuelve el primer Contacto de esta Agenda
     * cuyo nombre sea <nombre>. Si no se encuentra,
     * devuelve un Contacto nulo.
     */
    public Contacto buscarNombre(String nombre){
        Contacto result = new Contacto();
        for (int i = 0; i < ldc.size(); i++) {
            if(ldc.get(i).nombre().equals(nombre))
                result = new Contacto(ldc.get(i));
        }
        return result;
    }

    /**
     * buscarTelefono (tf : String) : Contacto
     * POST: Devuelve el primer Contacto de esta Agenda
     * cuyo telefono es <tf>. Si no se encuentra,
     * devuelve un Contacto nulo.
     */
    public Contacto buscarTelefono(String tlf){
        Contacto result = new Contacto();
        for (int i = 0; i < ldc.size(); i++) {
            if(ldc.get(i).tlf().equals(tlf))
                result = new Contacto(ldc.get(i));
        }
        return result;
    }

    /**
     * modificarContacto (nombre : String; tf : String)
     * EFECTO: Modifica el Contacto de esta Agenda cuyo
     * nombre es <nombre> cambiando su tf por <tf>.
     * Si no se encuentra, no hace nada.
     */
    public void modificarContacto(String nombre, String tlf){
        for (int i = 0; i < ldc.size(); i++) {
            if(ldc.get(i).nombre().equals(nombre))
                ldc.get(i).ponerTlf(tlf);;
        }
    }

    /**
     * quitar (contacto : Contacto)
     * EFECTO: Elimina de esta Agenda el elemento <contacto>.
     * Si no existe no hace nada.
     */
    public void quitar(Contacto contacto){
        int pos = ldc.indexOf(contacto);
        ldc.get(pos).delete();
    }

    public void quitar(int pos){
        ldc.get(pos).delete();
    }
}