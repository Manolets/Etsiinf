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

    static String [][] tablero;

    static void arrayTablero(int n){
        tablero = new String [n][n];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (i % 2 == 0 && j % 2 == 0 || i % 2 != 0 && j % 2 != 0) {
                    tablero[i][j] = "N";
                } else {
                    tablero[i][j] = "B";
                }
            }
        }
    }

    static void setCanvas(int n){
        if (n > 20)
            StdDraw.setCanvasSize(800, 800);
        arrayTablero(n);
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n);
        tablero();
    }

    static void tablero(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j].equals("N")) {
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                } else if (tablero[i][j].equals("B")){
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                } else if (tablero[i][j].equals("*")){
                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5); 
                } else if(tablero[i][j].equals("R")){
                    StdDraw.setPenColor(StdDraw.YELLOW);
                    StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                }
            }
        }
        for (int i = tablero.length - 1; i >= 0; i--) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void reina(int x, int y){
        if (x < 1)
            x = 1;
        if (x > tablero.length)
            x = tablero.length;
        if (y < 1)
            y = 1;
        if (y > tablero.length)
            y = tablero.length;
        for (String[] strings : tablero) {
            strings[y - 1] = "*";
        }
        for (int i = 0; i < tablero.length; i++) {
            tablero[x - 1][i] = "*";            
        }
        int i = x, j = y;
        while (i > 0 && j > 0) {
            tablero[i - 1][j - 1] = "*";
            i --;
            j --;
        }
        i = x; j = y;
        while (i > 0 && j <= tablero.length) {
            tablero[i - 1][j - 1] = "*";
            i --;
            j ++;
        }
        i = x; j = y;
        while (i <= tablero.length && j > 0) {
            tablero[i - 1][j - 1] = "*";
            i ++;
            j --;
        }
        i = x; j = y;
        while (i <= tablero.length && j <= tablero.length) {
            tablero[i - 1][j - 1] = "*";
            i ++;
            j ++;
        }
        tablero[x - 1][y - 1] = "R";
        tablero();
    }

    public static void main(String[] args) {
        System.out.println("De cuanto quieres el tablero: ");
        int n = StdIn.readInt();
        setCanvas(n);
        // System.out.println("Posicion X de la reina: ");
        // int x = StdIn.readInt();
        // System.out.println("Posicion Y de la reina: ");
        // int y = StdIn.readInt();
        // reina(x, (n+1) - y);
        // while (true) {
        // arrayTablero(n);
        // reina((int)StdDraw.mouseX() + 1, (int) StdDraw.mouseY() + 1);
        // }
        while (true) {
            if (StdDraw.isMousePressed()) {
            arrayTablero(n);
            reina((int)StdDraw.mouseX() + 1, (int) StdDraw.mouseY() + 1);
            }
        }
    }

}