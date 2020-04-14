import java.awt.*;

import javax.swing.*;
/**
 * Herramientas
 */
public class Herramientas {
    static Object mouse = new Object();

    public static void iniciarCanvas(){
        int x, y;
        Dimension canvas = new Dimension(1418, 800);
        x = (int) canvas.getWidth();
        y = (int) canvas.getHeight();
        StdDraw.setCanvasSize(x, y);
        StdDraw.setXscale(0, x);
        StdDraw.setYscale(0, y);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
    }

    private static int c = 0;
    
    public static void clear(){
        PoligonosApp.figuras = new ListaDePoligonos();
        PoligonosApp.mostrarFiguras();
        c = 0;
        PanelHerramientas.iniciarPanelHerramientas();
    }

    public static void colores(){
        String[] botones = {"RGB", "Blanco", "Negro", "Azul", "Verde", "Rojo", "Amarillo", "Rosa", "Naranja"};
        int res = JOptionPane.showOptionDialog(null, null, "¿Que color quieres?", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, botones, null);
        switch (res) {
            case 0:
                rgb();
                break;

            case 1:
                StdDraw.setPenColor(StdDraw.WHITE);
                break;
            case 2:
                StdDraw.setPenColor(StdDraw.BLACK);
                break;
            case 3:
                StdDraw.setPenColor(StdDraw.BLUE);
                break;
            case 4:
                StdDraw.setPenColor(StdDraw.GREEN);
                break;
            case 5:
                StdDraw.setPenColor(StdDraw.RED);
                break;
            case 6:
                StdDraw.setPenColor(StdDraw.YELLOW);
                break;
            case 7:
                StdDraw.setPenColor(StdDraw.PINK);
                break;
            case 8:
                StdDraw.setPenColor(StdDraw.ORANGE);
                break;
        
            default:
                break;
        }
        PanelHerramientas.iniciarPanelHerramientas();
    }

    private static void rgb(){
        JLabel redl = new JLabel("Red: "), greenl = new JLabel("Green: "), bluel = new JLabel("Blue: ");
        JTextField red = new JTextField(5), green = new JTextField(5), blue = new JTextField(5);
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setPreferredSize(new Dimension(420, 50));
        p.add(redl);    p.add(red);
        p.add(greenl);  p.add(green);
        p.add(bluel);   p.add(blue);

        Dimension size = greenl.getPreferredSize();
        redl.setBounds(10, 25, size.width, size.height);
        red.setBounds(40, 25, size.width * 2, size.height);
        greenl.setBounds(130, 25, size.width, size.height);
        green.setBounds(180, 25, size.width * 2, size.height);
        bluel.setBounds(290, 25, size.width, size.height);
        blue.setBounds(320, 25, size.width * 2, size.height);

        JOptionPane.showOptionDialog(null, p, "RGB (0, 255)", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, null, null);
        try {
            StdDraw.setPenColor(Integer.parseInt(red.getText()), Integer.parseInt(green.getText()), Integer.parseInt(blue.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Los valores tienen que estar entre 0 y 255", "ERROR", JOptionPane.ERROR_MESSAGE);
            rgb();
        }
        PanelHerramientas.iniciarPanelHerramientas();
    }


    public static void linea() {
        Poligono linea = new Poligono(10, true, StdDraw.getPenColor());

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (!StdDraw.isMousePressed()) {}

        linea.add(new Punto(StdDraw.mouseX(), StdDraw.mouseY()));
        linea.add(new Punto(StdDraw.mouseX(), StdDraw.mouseY()));

        while (StdDraw.isMousePressed()){}
        
        while (!StdDraw.isMousePressed()) {
            PoligonosApp.figuras.removeElementAt(c);
            linea.removeElementAt(1);
            linea.add(new Punto(StdDraw.mouseX(), StdDraw.mouseY()));
            PoligonosApp.figuras.set(c, linea);
            PoligonosApp.mostrarFiguras();
        }
        while (StdDraw.isMousePressed()) {}
        c++;
        PanelHerramientas.iniciarPanelHerramientas();
    }

    public static void cuadrilatero() {
        Poligono cuad = new Poligono(10, true, StdDraw.getPenColor());
        while (!StdDraw.isMousePressed()) {}

        Punto inicial = new Punto(StdDraw.mouseX(), StdDraw.mouseY());
        cuad.add(inicial);
        cuad.add(inicial);
        cuad.add(inicial);
        cuad.add(inicial);

        while (StdDraw.isMousePressed()){}

        while (!StdDraw.isMousePressed()) {
            PoligonosApp.figuras.removeElementAt(c);
            cuad.removeElementAt(3);
            cuad.removeElementAt(2);
            cuad.removeElementAt(1);
            
            cuad.add(new Punto(StdDraw.mouseX(), inicial.y()));
            cuad.add(new Punto(StdDraw.mouseX(), StdDraw.mouseY()));
            cuad.add(new Punto(inicial.x(), StdDraw.mouseY()));

            
            PoligonosApp.figuras.set(c, cuad);
            PoligonosApp.mostrarFiguras();
        }
        while (StdDraw.isMousePressed()) {}
        c++;
        PanelHerramientas.iniciarPanelHerramientas();
    }

    public static void poligono(int lados){
        Poligono pol = new Poligono(lados + 3, true, StdDraw.getPenColor());
        int count = 1;
        while (!StdDraw.isMousePressed()) {}
        Punto inicial = new Punto(StdDraw.mouseX(), StdDraw.mouseY());
        pol.add(inicial);
        for (int i = 0; i < lados -1; i++) {
            while (StdDraw.isMousePressed()) {}
            while (!StdDraw.isMousePressed()) {
                PoligonosApp.figuras.removeElementAt(c);
                pol.removeElementAt(count);
                pol.add(new Punto(StdDraw.mouseX(), StdDraw.mouseY()));
                
                PoligonosApp.figuras.set(c, pol);
                PoligonosApp.mostrarFiguras();
            }
            count++;
        }
        while (StdDraw.isMousePressed()) {}
        c++;
        PanelHerramientas.iniciarPanelHerramientas();
    }


    public static void lapiz(){
        Poligono lap = new Poligono(10000, false, StdDraw.getPenColor());
        while (!StdDraw.isMousePressed()) {}
        while (StdDraw.isMousePressed()) {
            if (!StdDraw.isKeyPressed(0x1B)) {
                try {
                    lap.add(new Punto(StdDraw.mouseX(), StdDraw.mouseY()));
                    PoligonosApp.figuras.set(c, lap);
                    PoligonosApp.mostrarFiguras();
                } catch (Exception e) {
                    c++;
                    lapiz();
                }
            } 
        }
        c++;

        PanelHerramientas.iniciarPanelHerramientas();

    }
}