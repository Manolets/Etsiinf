import java.io.*;
import java.nio.file.*;

/**
 * AgendaAmpliada
 * @version 1.0
 * @author Manuel López-Cerón Corredor
 */
public class AgendaAmpliada {

    /** 
     * leer (archivo : String) : Agenda
     * EFECTO: Crea una Agenda leyendo los datos de un fichero de
     * texto de nombre <archivo> que tiene los datos
     * guardados.
     * Cada línea tiene un contacto con el formato:
     * <nombre>;<tf>;<email>
    */
    static Agenda leer(String archivo) throws IOException {
        String[] partes = new String[3];
        Agenda agenda = new Agenda();
        File file = new File(archivo);   
        FileReader fr = new FileReader(file);  
        BufferedReader br = new BufferedReader(fr); 
        String line;
        while((line=br.readLine())!= null){  
          StringBuffer sb = new StringBuffer();    
          partes = sb.append(line).toString().split(";");
          if(!line.equals(";;")){
            Contacto c = new Contacto(partes[0], partes[1], partes[2]);
            agenda.añadirContacto(c);
          }
        }  
        fr.close();
        return agenda;
    }

    /**
     * escribir (agenda : Agenda; archivo : String)
     * EFECTO: Guarda la <agenda> en un fichero de texto de nombre
     * <archivo> con el formato:
     * <nombre>;<tf>;<email>
     */
    static void escribir(Agenda agenda, String archivo){
        String result = "";
        for (int i = 0; i < agenda.size(); i++) {
            result += agenda.get(i).nombre() + ";" + agenda.get(i).tlf() + ";" + agenda.get(i).email() + "\n";
        }
        try {
            Files.write(Paths.get(archivo), result.getBytes());
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    /**
     * ordenar (agenda : Agenda) // agenda es INOUT
     * EFECTO: Ordena la <agenda>.
     */
    static void ordenar(Agenda agenda){
        int n = agenda.size();
        Contacto temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(agenda.get(j-1).nombre().compareTo(agenda.get(j).nombre()) > 1){
                    //swap elements
                    temp = new Contacto(agenda.get(j-1));
                    agenda.get(j-1).ponerNombre(agenda.get(j).nombre());
                    agenda.get(j-1).ponerTlf(agenda.get(j).tlf());
                    agenda.get(j-1).ponerEmail(agenda.get(j).email());
                    agenda.get(j).ponerNombre(temp.nombre());
                    agenda.get(j).ponerTlf(temp.tlf());
                    agenda.get(j).ponerEmail(temp.email());
                } else if(agenda.get(j-1).nombre().compareTo(agenda.get(j).nombre()) == 0 && agenda.get(j-1).email().compareTo(agenda.get(j).email()) > 1){
                    temp = new Contacto(agenda.get(j-1));
                    agenda.get(j-1).ponerNombre(agenda.get(j).nombre());
                    agenda.get(j-1).ponerTlf(agenda.get(j).tlf());
                    agenda.get(j-1).ponerEmail(agenda.get(j).email());
                    agenda.get(j).ponerNombre(temp.nombre());
                    agenda.get(j).ponerTlf(temp.tlf());
                    agenda.get(j).ponerEmail(temp.email());
                }
                        
            }
        }
    }
}