
/**
 * Carta
 */
public class Carta {
    private String valor;
    private String palo;
    private boolean bocaArriba;

    public Carta (String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
        bocaArriba = false;
    }

    public Carta (String valor, String palo, boolean ba) {
        this.valor = valor;
        this.palo = palo;
        bocaArriba = ba;
    }

    public String palo() {
        return palo;
    }

    public String valor() {
        return valor;
    }

    public boolean bocaArriba(){
        return bocaArriba;
    }

    public void cambiarPalo(String palo){
        this.palo = palo;
    }

    public void cambiarValor(String valor){
        this.valor = valor;
    }

    public void darLaVuelta(){
        bocaArriba = !bocaArriba;
    }

    public String toString(){
        return valor + " De " + palo;
    }

    private String elegirArchivo(){
        String path = "images/";
        switch (valor) {
            case "As":
                path += "As";
                break;

            case "Dos":
                path += "Dos";
                break;

            case "Tres":
                path += "Tres";
                break;

            case "Cuatro":
                path += "Cuatro";
                break;

            case "Cinco":
                path += "Cinco";
                break;

            case "Seis":
                path += "Seis";
                break;

            case "Siete":
                path += "Siete";
                break;

            case "Ocho":
                path += "Ocho";
                break;

            case "Nueve":
                path += "Nueve";
                break;

            case "Sota":
                path += "Sota";
                break;

            case "Caballo":
                path += "Caballo";
                break;

            case "Rey":
                path += "Rey";
                break;

            default:
                break;
        }
        path += "De";
        switch (palo) {
            case "Oros":
                path += "Oros";
                break;

            case "Bastos":
                path += "Bastos";
                break;

            case "Espadas":
                path += "Espadas";
                break;

            case "Copas":
                path += "Copas";
                break;

            default:
                break;
        }

        return path + ".jpg";
    }

    public void pintar(int x, int y){
        StdDraw.picture(x, y, elegirArchivo(), 150, 225);
    }
    
}