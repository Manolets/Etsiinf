import javax.swing.*;


/**
 * VerContacto
 * @version 1.0
 * @author Manuel López-Cerón Corredor
 */
public class VerContacto {

    /** 
     * vercontacto(agenda : Agenda, id : int)
     * PRE: el id tiene que ser un elemento de la agenda
     * POST: Enseña una tarjeta con los datos del contacto seleccionado
    */
    public static void verContacto(Agenda agenda, int id){
        if(id >= 0)
            JOptionPane.showOptionDialog(null, agenda.get(id).toString(), agenda.get(id).nombre(), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
    }
}