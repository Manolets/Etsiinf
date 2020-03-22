
/**
 * Contacto
 */
public class Contacto {

    private String nombre;
    private String tlf;
    private String email;

    public Contacto(){};

    public Contacto(String nombre, String tlf){
        this.nombre = nombre;
        this.tlf = tlf;
    }

    public Contacto(String nombre, String tlf, String email){
        this.nombre = nombre;
        this.tlf = tlf;
        this.email = email;
    }

    public Contacto(Contacto contact){
        this.nombre = contact.nombre();
        this.tlf = contact.tlf();
        this.email = contact.email();
    }

    /**
     * nombre () : String
     * POST: Da el nombre de este Contacto.
     */
    public String nombre(){
        return nombre;
    }

    /** 
     * tf () : String
     * POST: Da el tf de este Contacto.
    */
    public String tlf(){
        return tlf;
    }

    /** 
     * email () : String
     * POST: Da el email de este Contacto.
    */
    public String email(){
        return email;
    }

    /** 
     * toString () : String
     * POST: Retorna los datos del Contacto como texto.
    */
    public String toString(){
        return "Nombre: " + nombre + "\nTlf: " + tlf + "\nEmail: " + email;
    }

    public String toSimplifiedString(){
        return nombre + ";" + tlf + ";" + email;
    }

    /** 
     * ponerNombre (nombre : String)
     * EFECTO: Modifica este contacto poniendo <nombre> como nuevo nombre.
    */
    public void ponerNombre(String nombre){
        this.nombre = nombre;
    }

    /** 
     * ponerTf (nombre : String)
     * EFECTO: Modifica este contacto poniendo <tf> como nuevo teléfono.
    */
    public void ponerTlf(String tlf){
        this.tlf = tlf;
    }

    /** 
     * ponerEmail (email : String)
     * EFECTO: Modifica este contacto poniendo <email> como nuevo email.
    */
    public void ponerEmail(String email){
        this.email = email;
    }

    /** 
     * equals (c : Contacto) : boolean
     * POST: Determina si <c> es igual a este Contacto.
    */
    public boolean equals(Contacto c){
        return nombre == c.nombre && tlf == c.tlf && email == c.email;
    }

    /**
     * clone () : Contacto
     * POST: Da una copia de este Contacto.
     */
    public Contacto clone(){
        return new Contacto(nombre, tlf, email);
    }

    /** 
     * linea () : String
     * POST: Convierte este Contacto en una línea de texto con los 
     * atributos separados por el carácter ';'.
    */
    public String linea(){
        return nombre + ";" + tlf + ";" + email;
    }

    /** 
     * static leer () : Contacto 
     * POST: Crea un Contacto con datos leídos de la entrada 
     * estándar (input) y lo entrega como resultado.
    */
    public static Contacto leer(){
        System.out.println("Dime el nombre del contacto: ");
        String name = StdIn.readString();
        System.out.println("Dime el tlf del contacto: ");
        String phone = StdIn.readString();
        System.out.println("Dime el email del contacto: ");
        String mail = StdIn.readString();
        return new Contacto(name, phone, mail);
    }

    /**
     * delete() : void
     * POST: borra todos los datos del contacto
     */
    public void delete(){
        nombre = "";
        tlf = "";
        email = "";
    }
}