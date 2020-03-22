import java.awt.*;

import javax.swing.*;

/**
 * EditarContacto
 */
public class EditarContacto {

    public static void editarContacto(Agenda agenda, int id){
        JPanel panel = new JPanel();
        JTextField nombre = new JTextField(agenda.get(id).nombre(), 20);
        JLabel nombrel = new JLabel("Nombre: ");
        JTextField tlf = new JTextField(agenda.get(id).tlf(), 15);
        JLabel tlfl = new JLabel("Tlf: ");
        JTextField email = new JTextField(agenda.get(id).email(), 25);
        JLabel emaill = new JLabel("Email: ");
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(600, 300));
        panel.add(nombrel);
        panel.add(nombre);
        panel.add(tlfl);
        panel.add(tlf);
        panel.add(emaill);
        panel.add(email);
        Dimension size = nombrel.getPreferredSize();
        nombrel.setBounds(50, 50, size.width, size.height);
        size = nombre.getPreferredSize();
        nombre.setBounds(110, 50, size.width, size.height);
        size = tlfl.getPreferredSize();
        tlfl.setBounds(50, 150, size.width, size.height);
        size = tlf.getPreferredSize();
        tlf.setBounds(110, 150, size.width, size.height);
        size = emaill.getPreferredSize();
        emaill.setBounds(50, 250, size.width, size.height);
        size = email.getPreferredSize();
        email.setBounds(110, 250, size.width, size.height);

        JOptionPane.showOptionDialog(null, panel, "Editar " + agenda.get(id).nombre(), JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, null, null);
        agenda.get(id).ponerNombre(nombre.getText());
        agenda.get(id).ponerTlf(tlf.getText());
        agenda.get(id).ponerEmail(email.getText());
        AgendaAmpliada.escribir(agenda, "agenda.txt");
    }
}