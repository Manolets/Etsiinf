import java.io.*;

import javax.swing.JOptionPane;

/**
 * AgendaApp
 */
public class AgendaApp {
    static Agenda agenda = new Agenda();

    private static void iniciaAgenda() throws IOException {
        agenda = AgendaAmpliada.leer("agenda.txt");
        AgendaAmpliada.ordenar(agenda);
    }

    static void mostrarPortada(){
        AgendaAmpliada.ordenar(agenda);
        int selectedPortada[] = PortadaAgenda.portadaAgenda(agenda);
        switch (selectedPortada[0]) {
            case 5: 
                BuscarContacto.buscarContacto(agenda);
                break;
            case 4:
                if(!(selectedPortada[1] == -1))
                VerContacto.verContacto(agenda, selectedPortada[1]);
                break;
        
            case 3:
                if(!(selectedPortada[1] == -1))
                EditarContacto.editarContacto(agenda, selectedPortada[1]);
                break;

            case 2:
                AñadirContacto.añadirContacto(agenda);
                break;

            case 1:
                if(!(selectedPortada[1] == -1))
                AñadirContacto.quitarContacto(agenda, selectedPortada[1]);
                break;
            default:
                break;
        }

        if(selectedPortada[0] != 0)
            mostrarPortada();
    }

    public static void main(String[] args) {
        try {
            iniciaAgenda();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mostrarPortada();
    }
}