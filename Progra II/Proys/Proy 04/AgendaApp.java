import java.io.*;

/**
 * AgendaApp
 * @version 1.0
 * @author Manuel López-Cerón Corredor
 */
public class AgendaApp {
    static Agenda agenda = new Agenda(); // La agenda que maneja la app

    /**
     * iniciarAgenda() : void
     * @throws IOException
     * POST: lee el archivo para iniciar la agenda
     */
    private static void iniciaAgenda() throws IOException {
        agenda = AgendaAmpliada.leer("agenda.txt");
        AgendaAmpliada.ordenar(agenda);
    }

    /**
     * mostrarPortada() : void
     * POST: llama a la portada principal del la aplicación
     */
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