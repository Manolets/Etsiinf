package figurasZxZ;
import java.awt.Color;

public class Rectangulo extends Figura{
    private int ancho, alto;
    private PuntoZxZ origen;
    private boolean relleno = false;
    private Color color = Color.BLUE;

    // + Rectangulo ()
    // * POST: Construye un Rectangulo de color azul sin relleno
    // * en una posición aleatoria con una <anchura> y
    // * una <altura> de magnitud aleatoria.
    public Rectangulo() {
        int x = (int) Math.random() * Tablero.ESCALAX;
        int y = (int) Math.random() * Tablero.ESCALAY;
        origen = new PuntoZxZ(x, y);
        alto = (int) Math.random() * Tablero.ESCALAY/4;
        ancho = (int) Math.random() * Tablero.ESCALAY/4;
    }

    // + Rectangulo (color : Color)
    // * POST: Construye un Rectangulo de <color> sin relleno
    // * en una posición aleatoria con una <anchura> y
    // * una <altura> de magnitud aleatoria.
    public Rectangulo(Color color) {
        int x = (int) Math.random() * Tablero.ESCALAX;
        int y = (int) Math.random() * Tablero.ESCALAY;
        origen = new PuntoZxZ(x, y);
        alto = (int) Math.random() * Tablero.ESCALAY/4;
        ancho = (int) Math.random() * Tablero.ESCALAY/4;
        this.color = color;
    }

    // + Rectangulo (centro : PuntoZxZ; anchura, altura : int)
    // * POST: Construye un Rectangulo de color azul sin relleno,
    // * en la posicion <centro> y con <anchura> y <altura>.
    public Rectangulo(PuntoZxZ centro, int anchura, int altura){
        origen = centro;
        alto = altura;
        ancho = anchura;
    }

    // + Rectangulo (centro : PuntoZxZ; anchura, altura : int; color : Color)
    // * POST: Construye un Rectangulo de <color> sin relleno,
    // * en la posicion <centro> y con <anchura> y <altura>.

    public Rectangulo(Color color, PuntoZxZ centro, int anchura, int altura) {
        origen = centro;
        alto = altura;
        ancho = anchura;
        this.color = color;
    }

    // + Rectangulo (centro : PuntoZxZ; anchura, altura : int; color : Color; relleno : boolean)
    // * POST: Construye un Rectangulo relleno de <color>,
    // * posicion <centro>, con <anchura> y <altura>,
    // * y relleno o no según el valor de <relleno>.
    public Rectangulo(Color color, PuntoZxZ centro, int anchura, int altura, boolean relleno) {
        origen = centro;
        alto = altura;
        ancho = anchura;
        this.color = color;
        this.relleno = relleno;
    }

    // + anchura () : int
    public int anchura(){
        return ancho;
    }

    // + altura () : int
    public int altura(){
        return alto;
    }

    // + toString () : String
    public String toString(){
        return "(" + origen + ", " + ancho + ", " + alto + ", " + color + ", " + relleno + ")";
    }
    // + equals (o : Object) : boolean
    public boolean equals(Rectangulo rectangulo){
        return ancho == rectangulo.ancho && alto == rectangulo.alto;
    }
    // + perimetro () : int
    public int perimetro() {
        return alto*2 + ancho*2;
    }
    // + pintar ()
    public void pintar(){
        StdDraw.setPenColor(color);
        StdDraw.line(origen.x(), origen.y(), origen.x() + ancho, origen.y());
        StdDraw.line(origen.x(), origen.y(), origen.x(), origen.y() + alto);
        StdDraw.line(origen.x() + ancho, origen.y(), origen.x() + ancho, origen.y() + alto);
        StdDraw.line(origen.x(), origen.y() + alto, origen.x() + ancho, origen.y() + alto);
    }
}