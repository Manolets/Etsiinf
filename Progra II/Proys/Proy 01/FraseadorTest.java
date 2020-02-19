import java.io.*;
/**
 * FraseadorTest
 */
public class FraseadorTest {
    static String[] lasFrases = new String[100];

    public static void main (String[] args) throws IOException
    {   
      // 1 - Leer las frases:
      Fraseador.leerArchivo("misFrases.txt", lasFrases);    
      // 2 - Prueba: Escribir todas las frases:
      //escribir(lasFrases);    
      // 2 - Escribir una frase aleatoria:
      //System.out.println(fraseAleatoria(lasFrases));
      Fraseador.escribirModoGrafico(Fraseador.fraseAleatoria(lasFrases));
    } 
}