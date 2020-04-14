import javax.swing.*;

import java.awt.*;
import java.util.*;

/**
 * BuscarContacto
 * @version 1.0
 * @author Manuel López-Cerón Corredor
 */
public class BuscarContacto {
    private static int casosint = 0;

    /** 
     * buscarContacto(agenda : Agenda)
     * crea un panel para buscar un contacto presente en la agenda
     * y llama a mostrarContacto según la selección
    */
    public static void buscarContacto(Agenda agenda){
        JPanel fpanel = new JPanel();
        JLabel buscar = new JLabel("Buscar: ");
        JLabel info = new JLabel("(El buscador busca en los tres campos del contacto, nombre, tlf y email)");
        JTextField buscador = new JTextField(20);
        String[] temp = new String[0];
        JList listaDeEncontrados = new JList(temp);
        JScrollPane encontrados = new JScrollPane(listaDeEncontrados);
        fpanel.setLayout(null);
        fpanel.setPreferredSize(new Dimension(700, 400));
        fpanel.add(buscar);     //Etiqueta de buscador
        Dimension size = buscar.getPreferredSize(); 
        buscar.setBounds(25, 25, size.width, size.height);
        fpanel.add(info);
        size = info.getPreferredSize();
        info.setBounds(25, 0, size.width, size.height);
        fpanel.add(buscador);   //Buscador
        size = buscador.getPreferredSize();
        buscador.setBounds(75, 25, size.width, size.height);
        fpanel.add(encontrados);//Panel de encontrados 
        size = encontrados.getPreferredSize();
        encontrados.setBounds(25, 75, 600, 300);
        int pressed = JOptionPane.showOptionDialog(null, fpanel, "Buscar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, null, null, null);//OK = 0, Canecl = 2
        if (pressed == 0) {
            String buscado = buscador.getText();
            boolean[] casos = matches(agenda, buscado);
            int count = 0;
            temp = new String[casosint];
            for (int i = 0; i < casos.length; i++) {
                if(casos[i] && casos.length > i){
                    temp[count] = agenda.get(i).nombre();
                    count++; 
                }
            }

            listaDeEncontrados = new JList(temp);
            encontrados = new JScrollPane(listaDeEncontrados);
            JPanel panel = new JPanel();
            panel.setLayout(null);
            JLabel encontradosLabel = new JLabel("Encontrados");
            panel.setPreferredSize(new Dimension(700, 400));
            panel.add(encontradosLabel);     //Etiqueta de encontrados
            size = encontradosLabel.getPreferredSize();
            encontradosLabel.setBounds(25, 25, size.width, size.height);
            panel.add(encontrados);//Panel de encontrados 
            size = encontrados.getPreferredSize();
            encontrados.setBounds(25, 75, 600, 300);
            pressed = JOptionPane.showOptionDialog(null, panel, "Buscar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, null, null, null);//OK = 0, Canecl = 2
            if (pressed == 0) {
                int selected = listaDeEncontrados.getSelectedIndex();
                for (int i = 0; i < agenda.size(); i++) {
                    if (selected != -1 && temp[selected].equals(agenda.get(i).nombre())) {
                        VerContacto.verContacto(agenda, i);
                    }
                }
            }
        }
    }

    private static boolean[] matches(Agenda agenda, String caso){
        boolean index[] = new boolean[100];
        Arrays.fill(index, false);
        for (int i = 0; i < agenda.size(); i++) {
            if (agenda.get(i).toSimplifiedString().contains(caso)) {
                index[i] = true;
                casosint++;
            }
        }

        return index;
    }
}