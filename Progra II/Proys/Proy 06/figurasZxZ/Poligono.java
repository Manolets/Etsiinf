package figurasZxZ;

import java.awt.*;

/**
 * Poligono
 * 
 * @author Manuel López-Cerón Corredor
 */

public class Poligono {
    private Color color = null;
    private boolean atrib = true; // Esto es solo para la función lapiz en PoligonoApp

    private int n  = 100;
    private PuntoZxZ[] puntos = new PuntoZxZ[n];

    public Poligono(){};

    public Poligono(int n, boolean atrib, Color color){
        this.n = n;
        this.atrib = atrib;
        this.color = color;
        puntos = new PuntoZxZ[n];
    }

    public Color color(){
        return color;
    }

    public Poligono(PuntoZxZ[] puntos){
        for (int i = 0; i < puntos.length; i++) {
            this.puntos[i] = puntos[i];
        }
    }

    public Poligono(Poligono poligono){
        this.puntos = poligono.puntos;
    }

    public PuntoZxZ[] puntos() {
        return puntos;
    }

    public int size(){
        int c = 0;
        for (PuntoZxZ punto : puntos){
            if(punto != null)
                c++;
        }
        return c;
    }

    public PuntoZxZ get(int pos){
        return puntos[pos];
    }

    public void set(int pos, PuntoZxZ elem){
        puntos[pos] = elem;
    }

    public String toString(){
        String res = "(" + size() + ", [";
        for (int i = 0; i < size() - 1; i++) {
            res += puntos[i].toString() + ", ";
        }
        if (size() != 0) 
            res += puntos[size() - 1].toString();
        return res + "])";
    }

    public void add(PuntoZxZ elem){
        puntos[size()] = elem;
    }

    public void add(int pos, PuntoZxZ elem){
        puntos[pos] = elem;
    }

    public int indexOf(PuntoZxZ elem){
        int index = -1;
        for (int i = 0; i < puntos.length; i++) {
            if (puntos[i] != null) {
                if (puntos[i].equals(elem)) {
                    index = i;
                }
            }
        }
        return index;
    }

    public void removeElementAt(int pos){
        for (int i = pos; i < size(); i++) {
            puntos[i] = puntos[i + 1];
        }
    }

    public boolean remove(PuntoZxZ elem) {
        boolean res = false;
        int index = indexOf(elem);
        if (index != -1) {
            res = true;
            removeElementAt(index);
        }
        return res;
    }
    
    public void pintar() {
        // initialise();
        // StdDraw.clear();
        if (color != null)
            StdDraw.setPenColor(color);
        for (int i = 0; i < size(); i++) {
            if (puntos[i] != null) {
                puntos[i].pintar();
                if (i != 0){
                    if (puntos[i] != null && puntos[i - 1] != null)
                    StdDraw.line(puntos[i].x(), puntos[i].y(), puntos[i-1].x(), puntos[i-1].y());
                }
            }
        }
        if(puntos[0] != null)
        if (atrib)
            StdDraw.line(puntos[0].x(), puntos[0].y(), puntos[size() - 1].x(), puntos[size() - 1].y());

    }


    // private void initialise(){
    //     StdDraw.setCanvasSize(100, 100);
    //     StdDraw.setXscale(0, 100);
    //     StdDraw.setYscale(0, 100);
    // }

    public boolean esMenor(Poligono p) {
        return size() < p.size();
    }

    public String linea() {
        String res = "";
        for (int i = 0; i < size(); i++) {
            res += puntos[i].toString() + " ";
        }
        return res;
    }

    public void mover(int dx, int dy){
        for (int i = 0; i < puntos.length; i++) {
            puntos[i] = new PuntoZxZ(puntos[i].x() + dx, puntos[i].y() + dy);
        }
    }
    
    public int perimetro(){
        int perimetro = 0;
        for (int i = 0; i < puntos.length - 1; i++) {
            perimetro += Math.sqrt((puntos[i].x() - puntos[i+1].x())^2 + (puntos[i].y() - puntos[i+1].y()));
        }
        return (int) (perimetro + Math.sqrt((puntos[0].x() - puntos[puntos.length].x())^2 + (puntos[0].y() - puntos[puntos.length].y())));
    }
    
}