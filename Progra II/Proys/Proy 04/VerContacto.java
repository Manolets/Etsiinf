import javax.swing.*;

import java.awt.Dimension;
import java.beans.beancontext.BeanContext;
import java.text.BreakIterator;

/**
 * VerContacto
 */
public class VerContacto {

    public static void verContacto(Agenda agenda, int id){

        // JViewport viewport = scrollPane.getViewport();
        // int w = 800;
        // int h = 400;
        // Dimension preferredSize = new Dimension(w, h);
        // viewport.setPreferredSize(preferredSize);
        if(id >= 0)
            JOptionPane.showOptionDialog(null, agenda.get(id).toString(), agenda.get(id).nombre(), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
    }
}