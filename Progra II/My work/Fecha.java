/**
 * Fecha
 * 
 * Maneja dia mes y año
 * 
 */
public class Fecha {

    int dia;
    int mes;
    int año;

    Fecha(int dia, int mes, int año){
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    //Visualizador
    public String fechaToString(){
        return "[" + this.dia + "/" + this.mes + "/" + this.año + "]";
    }

    //Comparador
    public boolean esIgual(Fecha f){
        if (f.dia == this.dia && f.mes == this.mes && f.año == this.año) {
            return true;  
        } else {
            return false;
        }
    }

    //Comprobador
    public boolean esFechaCorrecta(){
        if (fechaToString().length() == 12) {
            return true;
        }else{
            return false;
        }
    }
    
}