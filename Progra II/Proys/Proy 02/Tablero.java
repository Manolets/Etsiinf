/**
 * Tablero
 */
public class Tablero {

    /**
     * Crea el array del tablero
     */
    private char [][] tablero;

    public Tablero(){
    }

    public Tablero(int n){
        this.tablero = new char [n][n];
        setCanvas(n);
    }

    /**
     * esCuadroBlanco(x, y: int) : bool
     * POST: devuelve si el cuadro debe ser blanco
     */
    public boolean esCuadroBlanco(int x, int y){
        return (x % 2 == 0 && y % 2 == 0 || x % 2 != 0 && y % 2 != 0);
    }

    /**
     * inicializarTablero(n : int)
     * POST: rellena el tablero de blanco y negro.
     */
    public void inicializarTablero(int n){
        for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero.length; j++) {
                if (esCuadroBlanco(i, j)) {
                    this.tablero[i][j] = 'N';
                } else {
                    this.tablero[i][j] = 'B';
                }
            }
        }
    }

    /**
     * setCanvas(n : int)
     * POST: inicia la pantalla del StdDraw, para poder pintar el tablero (mdodo gráfico)
     */
    public void setCanvas(int n){
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
    public boolean esPosicionTablero(int x, int y){
        return (x > 0 && y > 0 && x <= this.tablero.length && y <= this.tablero.length);
    }

    /**
     * pintarTablero()
     * POST: pinta el tablero en el modo gráfico y llama a aString para pintarlo
     * por la salida estandar
     */
    public void pintarTablero(){
        for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero.length; j++) {
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
        System.out.println(aString());
    }

    /**
     * aString() : String
     * POST: devuelve un String compuesto por los colores/ posiciones del tablero
     */
    public String aString(){
        String elTablero = "";
        for (int i = this.tablero.length - 1; i >= 0; i--) {
            for (int j = 0; j < this.tablero.length; j++) {
                 elTablero += this.tablero[j][i] + " ";
              }
             elTablero += "\n";
         }
         elTablero += "\n";
        return elTablero;
    }

    /**
     * marcarAmenazasReina()
     */
    public void marcarAmenazasReina(int x, int y){
        if (x < 1)
            x = 1;
        if (x > this.tablero.length)
            x = this.tablero.length;
        if (y < 1)
            y = 1;
        if (y > this.tablero.length)
            y = this.tablero.length;
        for (char[] charcter : tablero) {
            charcter[y - 1] = '*';
        }
        for (int i = 0; i < this.tablero.length; i++) {
            this.tablero[x - 1][i] = '*';            
        }
        int i = x, j = y;
        while (i > 0 && j > 0) {
            this.tablero[i - 1][j - 1] = '*';
            i --;
            j --;
        }
        i = x; j = y;
        while (i > 0 && j <= this.tablero.length) {
            this.tablero[i - 1][j - 1] = '*';
            i --;
            j ++;
        }
        i = x; j = y;
        while (i <= this.tablero.length && j > 0) {
            this.tablero[i - 1][j - 1] = '*';
            i ++;
            j --;
        }
        i = x; j = y;
        while (i <= this.tablero.length && j <= this.tablero.length) {
            this.tablero[i - 1][j - 1] = '*';
            i ++;
            j ++;
        }
        this.tablero[x - 1][y - 1] = 'R';
        pintarTablero();
    }
}