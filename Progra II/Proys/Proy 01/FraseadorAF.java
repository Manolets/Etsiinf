import java.io.*;
import javax.swing.*;

/** 
 * El fraseador procaz.
 * PRE: El Working directory debe ser el del programa.
 * 
 * @since 8/02/2017
 * @version 1.2   31/01/2019
 * @author Javier Galve
 */
class FraseadorAF
{

  static String[] lasFrases = new String[100];

  /*
   * longitud (frases : String[]) : int
   * POST: Calcula la longitud de <frases>
   */
  static int longitud(String[] frases){
    int longitud = 0;
    while (frases[longitud] != null && longitud < frases.length) {
      longitud++;
    }
    return longitud;
  }

  /*
   * fraseAleatoria (frases : String[]) : String
   * POST: Devuelve una frase aleatoria de <frases>
   */
  static String fraseAleatoria(String[] frases){
    return frases[(int)(Math.random() * longitud(frases))];
  }

  /*
   * leer (frases : String[]) //frases es InOut
   * POST: Lee un array de Strings del <input>.
   */
  static void leer(String[] frases){
    System.out.println("Separa las palabras con _");
    for (int i = 0; i < frases.length; i++) {
      System.out.println("Dime la frase " + (i + 1));
      String tempString = StdIn.readString();
      frases[i] = tempString.replace("_", " ");
    }
    System.out.println("Tus frases son:");
    for (String frase : frases) {
      System.out.println(frase);
    }
  }

  /*
   * leerArchivo (archivo : String; frases String[]) //frases es InOut
   * POST: Lee un array de Strings de <archivo>.
   */
  static void leerArchivo(String archivo, String[] frases) throws IOException{
    int i = 0;
    File file = new File(archivo);   
    FileReader fr = new FileReader(file);  
    BufferedReader br = new BufferedReader(fr); 
    String line;
    while((line=br.readLine())!= null){  
      StringBuffer sb = new StringBuffer();    
      frases[i] = sb.append(line).toString();
      i++;
    }  
    fr.close();

  }

  /*
   * escribir (frases : String[])
   * EFECTO: Escribe <frases> en la salida est�ndar, 
   *         una por l�nea.
   */
  static void escribir(String[] frases){
    for (int j = 0; j < frases.length; j++) {
      if (frases[j] != null) {
        System.out.println("Frase " + j + ":");
        System.out.println(frases[j]);
      }
    }
  }

  /*
   * escribirModoGrafico (frase : String)
   * EFECTO: Escribe <frase> en modo gr�fico. 
   *         una por l�nea.
   */
  static void escribirModoGrafico(String frase){
    //GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    //Font[] allFonts = ge.getAllFonts();

    JOptionPane.showMessageDialog(null, frase);
  }

  public static void main (String[] args) throws IOException
  {   
    // 1 - Leer las frases:
    leerArchivo("misFrases.txt", lasFrases);    
    // 2 - Prueba: Escribir todas las frases:
    escribir(lasFrases);    
    // 2 - Escribir una frase aleatoria:
    //System.out.println(fraseAleatoria(lasFrases));
    escribirModoGrafico(fraseAleatoria(lasFrases));
  } 
  
}