
/**
 * CartasEnJuego
 */
public class CartasEnJuego {
    static String cartasDeLaBaraja[] = { "AsDeOros", "DosDeOros", "TresDeOros", "CuatroDeOros", "CincoDeOros",
            "SeisDeOros", "SieteDeOros", "OchoDeOros", "NueveDeOros", "SotaDeOros", "CaballoDeOros", "ReyDeOros",
            "AsDeCopas", "DosDeCopas", "TresDeCopas", "CuatroDeCopas", "CincoDeCopas", "SeisDeCopas", "SieteDeCopas",
            "OchoDeCopas", "NueveDeCopas", "SotaDeCopas", "CaballoDeCopas", "ReyDeCopas", "AsDeBastos", "DosDeBastos",
            "TresDeBastos", "CuatroDeBastos", "CincoDeBastos", "SeisDeBastos", "SieteDeBastos", "OchoDeBastos",
            "NueveDeBastos", "SotaDeBastos", "CaballoDeBastos", "ReyDeBastos", "AsDeEspadas", "DosDeEspadas",
            "TresDeEspadas", "CuatroDeEspadas", "CincoDeEspadas", "SeisDeEspadas", "SieteDeEspadas", "OchoDeEspadas",
            "NueveDeEspadas", "SotaDeEspadas", "CaballoDeEspadas", "ReyDeEspadas" };

    static Carta[] baraja = new Carta[48];

    /**
     * iniciarGraficos () EFECTO: Establece el contexto gráfico.
     */
    static void iniciarGraficos() {
        StdDraw.setCanvasSize(1500, 800);
        StdDraw.setXscale(0, 1500);
        StdDraw.setYscale(0, 800);
    }

    static void barajaGenerada() {
        String[] tempString = new String[2];
        for (int i = 0; i < baraja.length; i++) {
            tempString = cartasDeLaBaraja[i].split("De");
            baraja[i] = new Carta(tempString[0], tempString[1]);
        }
    }

    static String aString(Carta[] baraja) {
        String result = "";
        for (Carta carta : baraja) {
            result += carta.toString() + " ";
        }
        return result;
    }

    static void pintarBaraja(Carta[] baraja) {
        int x = 130, y = 650;
        for (int i = 0; i < baraja.length; i++) {
            baraja[i].pintar(x, y);
            x += 110;
            if ((i + 1) % 12 == 0 && (i + 1) != 0) {
                x = 130;
                y -= 150;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void ponerBocaAbajo(int i, Carta[] baraja){
        if(baraja[i].bocaArriba())
            baraja[i].darLaVuelta();
    }

    static void barajar(Carta[] baraja){
        int[] temp = new int[48];
        Carta[] tempBaraja = new Carta[48];
        for (int i = 0; i < baraja.length; i++) {
            tempBaraja[i] = new Carta(baraja[i].valor(), baraja[i].palo());
        }
        for (int i = 0; i < temp.length; i++) {
            int aleatorio = (int) (Math.random() * 48);
            if (temp[aleatorio] == -1) {
                i--;
            } else {
                baraja[i] = tempBaraja[aleatorio];
            }
            temp[aleatorio] = -1;
        }
    }

    static String escribeBaraja(Carta[] baraja){
        String result = "";
        for (int i = 0; i < baraja.length; i++) {
            result += baraja[i].toString() + " ";
            if((i+1) % 12 == 0)
                result += "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        barajaGenerada();
        iniciarGraficos();
        pintarBaraja(baraja);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StdDraw.clear();
        barajar(baraja);
        pintarBaraja(baraja);
        // baraja[0].pintar(0, 0);
    }
}