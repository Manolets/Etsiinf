/**
 * ReinaAF
 * 
 * @author Manuel López-Cerón Corredor
 * @version 1.0
 * 
 * Este modulo pinta por la salida estandar un tablero de ajedrez y después las posiciones por una reina colocada
 * por el usuario, como añadido también hay un modo gráfico y una opción de colocar la reina pulsando sobre la 
 * casilla deseada.
 * 
 */
public class ReinaAF {

    static char [][] tablero;

    /*
    esCuadroBlanco (x, y : int) : boolean
    PRE: esPosicionTablero(x, y)
    POST: Devuelve cierto si y solo si el cuadro de coordenadas (x, y)
    es un cuadro blanco [y falso e.o.c.].
    */
    static boolean esCuadroBlanco(int x, int y){
        return (x % 2 == 0 && y % 2 == 0 || x % 2 != 0 && y % 2 != 0);
    }

    static void inicializarTablero(int n){
        tablero = new char [n][n];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (esCuadroBlanco(i, j)) {
                    tablero[i][j] = 'N';
                } else {
                    tablero[i][j] = 'B';
                }
            }
        }
    }

    static void setCanvas(int n){
        if (n > 20)
            StdDraw.setCanvasSize(800, 800);
        inicializarTablero(n);
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n);
        StdDraw.enableDoubleBuffering();
        pintarTablero();
    }

    /*
    esPosicionTablero (x, y : int) : boolean
    POST: resultado = x IN [1, n] and y IN [1, n]
    */
    static boolean esPosicionTablero(int x, int y){
        return (x > 0 && y > 0 && x <= tablero.length && y <= tablero.length);
    }

    static void pintarTablero(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == 'N') {
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                } else if (tablero[i][j] == 'B'){
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                } else if (tablero[i][j] == '*'){
                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5); 
                } else if(tablero[i][j] == 'R'){
                    StdDraw.setPenColor(StdDraw.YELLOW);
                    StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                }
            }
        }
        StdDraw.show();
        System.out.println(aString(tablero));
    }
    /*
    aString (tablero : TipoTablero) : String
    POST: Convierte tablero a String.
    */
    static String aString(char[][] tablero){
        String elTablero = "";
        for (int i = tablero.length - 1; i >= 0; i--) {
            for (int j = 0; j < tablero.length; j++) {
                 elTablero += tablero[j][i] + " ";
              }
             elTablero += "\n";
         }
         elTablero += "\n";
        return elTablero;
    }

    static void marcarAmenazasReina(int x, int y){
        if (x < 1)
            x = 1;
        if (x > tablero.length)
            x = tablero.length;
        if (y < 1)
            y = 1;
        if (y > tablero.length)
            y = tablero.length;
        for (char[] charcter : tablero) {
            charcter[y - 1] = '*';
        }
        for (int i = 0; i < tablero.length; i++) {
            tablero[x - 1][i] = '*';            
        }
        int i = x, j = y;
        while (i > 0 && j > 0) {
            tablero[i - 1][j - 1] = '*';
            i --;
            j --;
        }
        i = x; j = y;
        while (i > 0 && j <= tablero.length) {
            tablero[i - 1][j - 1] = '*';
            i --;
            j ++;
        }
        i = x; j = y;
        while (i <= tablero.length && j > 0) {
            tablero[i - 1][j - 1] = '*';
            i ++;
            j --;
        }
        i = x; j = y;
        while (i <= tablero.length && j <= tablero.length) {
            tablero[i - 1][j - 1] = '*';
            i ++;
            j ++;
        }
        tablero[x - 1][y - 1] = 'R';
        pintarTablero();
    }

    public static void main(String[] args) {
        System.out.println("De cuanto quieres el tablero: ");
        int n = StdIn.readInt();
        setCanvas(n);
        System.out.println("Posicion X de la reina: ");
        int x = StdIn.readInt();
        System.out.println("Posicion Y de la reina: ");
        int y = StdIn.readInt();
        marcarAmenazasReina(x, (n+1) - y);
        // while (true) {
        // arrayTablero(n);
        // marcarAmenazasReina((int)StdDraw.mouseX() + 1, (int) StdDraw.mouseY() + 1);
        // }
        while (true) {
            if (StdDraw.isMousePressed()) {
            inicializarTablero(n);
            marcarAmenazasReina((int)StdDraw.mouseX() + 1, (int) StdDraw.mouseY() + 1);
            }
        }
    }

}