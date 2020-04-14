import java.io.*;

/**
 * Implementaci�n de operaciones de E/S en archivos de Punto, Poligono y
 * ListaDePoligonos.<br>
 *
 * @since 31/03/2020
 * @version 1.0
 * @author Javier Galve
 */
// import stdlib.*;
// import figuras.punto.*;

public class PoligonosInOut 
{
  /**
   * escribir (pol : Poligono; archivo : String) 
   * EFECTO: Escribe el Poligono <pol> como una 
   *         l�nea en un archivo de texto de nombre
   *         <archivo>. 
   */
  public static void escribir (Poligono pol, String archivo) 
  {
    Out out = new Out(archivo);
    int i = 0;
    while (i <= pol.size()-1)
    {  
      out.print(pol.get(i).toString());
      i = i + 1;
      if(i <= pol.size()-1)
        out.print(";");
    }
    out.close();
  }
  /**
   * escribir (ldp : ListaDePoligonos; archivo : String) 
   * EFECTO: Escribe la ListaDePoligonos <ldp> en un archivo 
   *         de texto de nombre <archivo>, cada pol�gono en
   *         una l�nea. 
   */
  public static void escribir (ListaDePoligonos ldp, String archivo) 
  {
    Out out = new Out(archivo);
    for (int i = 0; i < ldp.size(); i++) {
      for (int j = 0; j < ldp.get(i).size(); j++) {
        out.print(ldp.get(i).get(j).toString());
        if(j <= ldp.size())
          out.print(";");
      }
      out.print("\n");
    }
    out.close();
  }
  /**
   * aPoligono (linea : String) : Poligono
   * POST: Convierte una <l�nea> de texto
   *       formada por coordenadas de puntos, separados 
   *       entre s� por espacios, en un Poligono.
   */
  private static Poligono aPoligono (String linea) 
  {
    Poligono pol = new Poligono();
    String[] datos = linea.split(";");
    for (int i = 0; i < datos.length; i++)
    {
      datos[i] = datos[i].replace("(", "");
      datos[i] = datos[i].replace(")", "");
      String[] coordenadas = datos[i].split(", ");
      double x = Double.parseDouble(coordenadas[0]);
      double y = Double.parseDouble(coordenadas[1]);
      pol.add(new Punto(x, y));  
    }
    return pol;
  }
  
  /**
   * leer (archivo : String) : ListaDePoligonos POST: Retorna una ListaDePoligonos
   * le�da de un archivo de texto de nombre <archivo>.
   * 
   * @throws IOException
   */
  public static ListaDePoligonos leer(String archivo) throws IOException 
  {
    ListaDePoligonos ldp = new ListaDePoligonos();
    File file = new File(archivo);   
    FileReader fr = new FileReader(file);  
    BufferedReader br = new BufferedReader(fr); 
    String line;
    while((line=br.readLine())!= null){  
      StringBuffer sb = new StringBuffer();    
      ldp.add(aPoligono(sb.append(line).toString()));
    }  
    fr.close();
    return ldp;
  }
  
}