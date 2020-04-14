import javax.swing.*;


/**
 * PanelHerramientas
 * 
 * @author Manuel López-Cerón Corredor
 * 
 * 
 */

public class PanelHerramientas {

    public static void iniciarPanelHerramientas(){
        
        // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        String botones[] = {"Limpiar", "Colores", "Linea", "Cuadrilatero", "Poligono", "Lapiz", "Guardar (sin color)", "Cargar (sin color)"};

        int opt = JOptionPane.showOptionDialog(null, null, "Herramientas", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, botones, null);

        switch (opt) {
            case 0:
                Herramientas.clear();
                break;

            case 1:
                Herramientas.colores();
                break;

            case 2:
                Herramientas.linea();
                break;

            case 3:
                Herramientas.cuadrilatero();
                break;

            case 4:
                JTextField lados = new JTextField(20);
                JOptionPane.showOptionDialog(null, lados, "De cuantos lados?", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, null, null);
                Herramientas.poligono(Integer.parseInt(lados.getText()));
                break;

            case 5:
                Herramientas.lapiz();
                break;

            case 6:
                Herramientas.guardar();
                break;
            
            case 7:
                Herramientas.cargar();
                break;
        
            default:
                break;
        }
    }
}