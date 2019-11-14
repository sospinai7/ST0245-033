public class Arbol {
    public Nodo raiz;

    public Arbol(Nodo raiz){
        this.raiz = raiz;
    }

    public String toString(){
        return "La impureza es: " + raiz.impureza+" La matriz de impureza es: "+raiz.impurezas
                +", El label es: "+ raiz.marc +" Está en la variable(algo): "+ raiz.algo + " la matriz es: "+raiz.matriz +" La variable es: "+
                raiz.vrble;
    }
}
