import java.awt.*;

import javax.swing.*;

/**
 * AñadirContacto
 */
public class AñadirContacto {

    public static void añadirContacto(Agenda agenda){
        JPanel panel = new JPanel();
        JTextField nombre = new JTextField(20);
        JLabel nombrel = new JLabel("Nombre: ");
        JTextField tlf = new JTextField(15);
        JLabel tlfl = new JLabel("Tlf: ");
        JTextField email = new JTextField(25);
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

        int option = JOptionPane.showOptionDialog(null, panel, "Crear Contacto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, null, null, null);
        boolean existe = false;
        for (int i = 0; i < agenda.size(); i++) {
            if(agenda.get(i).nombre().equals(nombre.getText()))
                existe = true;
        }

        if (option == 0 && !existe && nombre.getText().length() > 0) {
            String name = nombre.getText();
            String telf = tlf.getText();
            String mail = email.getText();
            if(telf.length() < 1)
                telf = " ";
            if(mail.length() < 1)
                mail = " ";
            Contacto contacto = new Contacto(name, telf, mail);
            agenda.añadirContacto(contacto);
            AgendaAmpliada.escribir(agenda, "agenda.txt");
        }

        if (existe && option == 0) {
            JOptionPane.showMessageDialog(null, "El nombre ya existe", "ERROR", JOptionPane.OK_OPTION, null);
            añadirContacto(agenda);
        }

        if (nombre.getText().length() == 0 && option == 0) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio", "ERROR", JOptionPane.OK_OPTION, null);
            añadirContacto(agenda);
        }

    }

    public static void quitarContacto(Agenda agenda, int id){
        int selected = JOptionPane.showConfirmDialog(null, "Está seguro de que quiere eliminar el contacto?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION, null);
        System.out.println(selected);
        if (selected == 0) {
            agenda.quitar(id);
            AgendaAmpliada.escribir(agenda, "agenda.txt");
        }
    }
}