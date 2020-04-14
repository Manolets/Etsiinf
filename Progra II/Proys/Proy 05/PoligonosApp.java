

/**
 * PoligonosApp
 */
public class PoligonosApp {

    public static ListaDePoligonos figuras = new ListaDePoligonos(1000);

    public static void mostrarFiguras(){
        StdDraw.clear();
        figuras.pintar();
        StdDraw.show();
    }

    static void panelListener(){
        PanelHerramientas.iniciarPanelHerramientas();
    }

    public static void main(String[] args) {
        Herramientas.iniciarCanvas();
        panelListener();
        System.out.println(StdDraw.getPenColor());
    }
}