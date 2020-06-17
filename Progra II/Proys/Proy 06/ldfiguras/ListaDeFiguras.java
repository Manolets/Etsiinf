package ldfiguras;

public class ListaDeFiguras {
    private int n = 100;
    
    private figurasZxZ.Poligono[] poligonos = new figurasZxZ.Poligono[n];
    
    public ListaDeFiguras(){}

    public ListaDeFiguras(int n){
        this.n = n;
        poligonos = new figurasZxZ.Poligono[n];
    }

    /** 
    public ListaDePoligonos(figurasZxZ.Poligono[] pol){
        for (int i = 0; i < pol.length; i++) {
            poligonos[i] = pol[i];
        }
    }

    public ListaDePoligonos(ListaDePoligonos list){
        this.poligonos = list.poligonos;
    }
    */
    public String toString(){
        String res = "";
        for (int i = 0; i < size(); i++) {
            res += poligonos[i].toString() + "\n";
        }
        return res;
    }

    public void add(figurasZxZ.Poligono c) {
        poligonos[size()] = new figurasZxZ.Poligono(c);
    }

    public int size() {
        int i = 0;
        for (int j = 0; j < poligonos.length; j++) {
            if (poligonos[j] != null)
                i++;
        }
        return i;
    }

    public figurasZxZ.Poligono get(int pos) {
        return poligonos[pos];
    }

    public void set(int pos, figurasZxZ.Poligono elem) {
        poligonos[pos] = elem;
    }

    public void removeElementAt(int pos) {
        if (pos != -1) {
            for (int i = pos; i < size(); i++) {
                poligonos[i] = poligonos[i + 1];
            }
        }
    }

    public void remove(figurasZxZ.Poligono elem){
        int j = -1;
        for (int i = 0; i < size(); i++) {
            if (!elem.equals(poligonos[i]))
                j = i;
        }
        removeElementAt(j);
    }

    public void ordenar(){
        int n = size();
        figurasZxZ.Poligono temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(poligonos[j-1].size() > poligonos[j].size()){
                    //swap elements
                    temp = new figurasZxZ.Poligono(poligonos[j-1]);
                    poligonos[j-1] = new figurasZxZ.Poligono(poligonos[j]);
                    poligonos[j] = new figurasZxZ.Poligono(temp);
                }       
            }
        }
    }

    public void addOrd(figurasZxZ.Poligono elem) {
        add(elem);
        ordenar();
    }

    public void pintar() {
        // StdDraw.enableDoubleBuffering();
        for (int i = 0; i < size(); i++) {
            poligonos[i].pintar();
        }
        StdDraw.show();
    }

    
}