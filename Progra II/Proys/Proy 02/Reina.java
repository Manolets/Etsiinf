/**
 * Reina
 */
public class Reina {
    
    public static void main(String[] args) {
        System.out.println("De cuanto quieres el tablero: ");
        int n = StdIn.readInt();
        Tablero t = new Tablero(n);
        System.out.println("Posicion X de la reina: ");
        int x = StdIn.readInt();
        System.out.println("Posicion Y de la reina: ");
        int y = StdIn.readInt();
        t.marcarAmenazasReina(x, (n+1) - y);
        while (true) {
            if (StdDraw.isMousePressed()) {
            t.inicializarTablero(n);
            t.marcarAmenazasReina((int)StdDraw.mouseX() + 1, (int) StdDraw.mouseY() + 1);
            }
        }
    }
}