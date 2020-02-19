//import stdlib.*;
/** 
 * Muestra las operaciones de entrada/salida para tipos 
 * predefinidos.
 * @author JGF
 * @since 09/09/2018
 * @version 1.0
*/

class EntradaSalida 
{
   
  public static void main (String[] args) 
  {
  
    System.out.println("Lectura de tipos predefinidos en Java");
    //Enteros:
    System.out.print("i>");
    int i = StdIn.readInt();
    //Para escribir, usaremos "System.out.println" y 
    //"StdOut.println" indistintamente:
    System.out.println("i = " + i);
    StdOut.println("i = " + i);

    //Reales:
    System.out.print("d>");
    double d = StdIn.readDouble();
    System.out.println("d = " + d);

    //Caracteres:
    System.out.print("c>");
    char c = StdIn.readChar(); 
    c = StdIn.readChar(); 
    System.out.println("c = " + c);
    StdOut.println("c = " + c);

    //Booleanos:
    System.out.print("b>");
    boolean b = StdIn.readBoolean();
    System.out.println("b = " + b);
    StdOut.println("b = " + b);

    //Strings:
    System.out.print("s>");
    String s = StdIn.readString();
    System.out.println("s = " + s);
    StdOut.println("s = " + s);

  }  
  
}