
import java.awt.Dimension;
import javax.swing.*;

/**
 * AgendaAppImpl
 */
public class PortadaAgenda {

    // private Agenda agenda = new Agenda();
    private static String[] listaDeNombres = new String[100];
    private static int pressed;
    private static int selected;

    public static int[] portadaAgenda(Agenda agenda){
        for (int i = 0; i < agenda.size(); i++) {
            listaDeNombres[i] = agenda.get(i).nombre();
        }
        String[] temp = new String[agenda.size()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = listaDeNombres[i];
        }
        JList list = new JList(temp);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JViewport viewport = scrollPane.getViewport();
        int w = 800;
        int h = 400; //viewport.getPreferredSize().height;
        Dimension preferredSize = new Dimension(w, h);
        viewport.setPreferredSize(preferredSize);
        String[] buttons = {"Cerrar", "Eliminar", "Añadir", "Editar", "Ver", "Buscar"};
        pressed = JOptionPane.showOptionDialog(null, scrollPane, "Agenda", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, null);
        selected = -1;
        if(pressed == 3 || pressed == 4 || pressed == 1)
            selected = list.getSelectedIndex();
        
        return new int[] {pressed, selected};
    }
}