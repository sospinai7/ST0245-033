import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.crypto.spec.PSource;
import java.awt.desktop.SystemEventListener;
public class Nodo {
    public int marc[];
    public double algo;
    public double vrble;
    public double matriz[][];
    public double impurezas[][];
    public double impureza;
    public Nodo der;
    public Nodo izq;
    
    public Nodo(double [][] matrizDeDatos, int [] marc) {
        matriz = matrizDeDatos;
        impurezas = llenarImp(matriz,marc);
        this.marc = marc;
        int col = matrizDeDatos[0].length;
        if (col > 1) {
            impureza = vrbleConMenorimpureza(impurezas);
           vrble = equivalencia(matriz,impurezas,impureza);
           algo = algo(matriz, vrble);
           double[][] matrizizq = mayores(matriz, (int) algo, vrble);
           double[][] matrizDer = menores(matriz, (int) algo, vrble);
           if (matrizizq.length > 0)
              izq = new Nodo(matrizizq, marc );
           if (matrizDer.length > 0)
              der = new Nodo(matrizDer,marc);
         }
    }

    public static int algo(double[][] matriz, double algo){
        long inicio_algo = System.currentTimeMillis();

        for (int i = 0; i < matriz[0].length ; i++) {
            for (int j = 0; j < matriz.length ; j++) {
                if (matriz[j][i] == algo) {
                    return i;
                }
            }
        }

        long fin_algo = System.currentTimeMillis();
        long total_algo = fin_algo - inicio_algo;
        System.out.println("Tiempo de ejecución para algo: " + total_algo + "ms");

        return 0;
    }

    public static double equivalencia(double matriz[][],double [][] impureza, double valorimpureza ) {
        long inicio_equiv = System.currentTimeMillis();

        for (int j = 0; j <impureza.length ; j++) {
            for (int i = 0; i <impureza.length ; i++) {
                if (impureza[i][j] == valorimpureza) {
                    //System.out.println("Está en la posición: " + "[" + j +   "]" + "[" + i + "]");
                    return matriz[i][j];
                }
            }
        }

        long fin_equiv = System.currentTimeMillis();
        long total_equiv = fin_equiv - inicio_equiv;
        System.out.println("Tiempo de ejecución para equivalencia: " + total_equiv + "ms");

        return 0;
    }

    public static double vrbleConMenorimpureza(double[][]impureza5) {
        double a = impureza5[0][0];
        for (int i = 0; i < impureza5.length ; i++) {
            for (int j = 0; j <impureza5.length; j++) {
                if(impureza5[j][i] < a){
                    a = impureza5[j][i];
                }
            }
        }
        return a;
    }


    public static double[][] recortada (double[][]matriz,int colum) {
        long inicio_recortada = System.currentTimeMillis();

        double[][] recortada = new double[matriz.length][(matriz[0].length-1)];
        int w = 0;
        for (int i = 0; i < matriz[0].length ; i++) { 
            if (i == colum){
                continue;
            }
            for (int j = 0; j < matriz.length; j++) {
                recortada[j][w] = matriz[j][i];
            }
            w++;
        }

        long fin_recortada = System.currentTimeMillis();
        long total_recortada = fin_recortada - inicio_recortada;
        System.out.println("Tiempo de ejecución para la matriz recortada: " + total_recortada + "ms");

        return recortada;
    }

    public static double[][] llenarImp(double [][] matriz, int [] marc) {
        long inicio_llenar = System.currentTimeMillis();

        //Metodo para llenar la matriz
        double[][] impureza5 = new double[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz[0].length ; i++) {
            for (int j = 0; j < matriz.length ; j++) {
                ArrayList<Double> derecha = new ArrayList<>();
                ArrayList<Double> izquierda = new ArrayList<>();
                double vrbleParte= matriz[j][i];
                int mayores= 0;
                int menores = 0;
                int royaI = 0;
                int noRoyaI = 0;
                int royaD = 0;
                int noRoyaD = 0;
                double impureza;
                double impurezaD;
                double impurezaI;

                for (int k = 0; k < matriz.length ; k++) {
                    if (matriz[k][i] <= vrbleParte) {
                        if (marc[k]==1){
                            royaI++;
                        }else if(marc[k]==0){
                            noRoyaI++;
                        }
                        menores++;
                        izquierda.add(matriz[k][i]);
                    } else {
                        if (marc[k]==1){
                            royaD++;
                        }else if(marc[k]==0){
                            noRoyaD++;
                        }
                        mayores++;
                        derecha.add(matriz[k][i]);
                    }
                }
                impurezaD = (double) 1-(Math.pow(((double)royaD/derecha.size()),2)+ Math.pow(((double)noRoyaD/derecha.size()),2));
                impurezaI = (double) 1-(Math.pow(((double)royaI/izquierda.size()),2)+ Math.pow(((double)noRoyaI/izquierda.size()),2));
                impureza=((menores*impurezaI)+(mayores*impurezaD))/(mayores+menores);
                impureza5[j][i]=impureza;
                System.out.println("Nodo"+"["+i+"]"+"["+j+"]" +" Estos son los mayores que "+vrbleParte+": "+mayores+" y de esos mayores "+royaD+" tienen roya y "+noRoyaD+" no tienen roya");
                System.out.println("Nodo"+"["+i+"]"+"["+j+"]" +" Estos son los menores que "+vrbleParte+": "+menores+" y de esos menores "+royaI+" tienen roya y "+noRoyaI+" no tienen roya");
            }
        }

        long fin_llenar = System.currentTimeMillis();
        long total_llenar = fin_llenar - inicio_llenar;
        System.out.println("Tiempo de ejecución para llenar impureza(__): " + total_llenar + "ms");

        return impureza5;
    }


    public static double[][]  mayores (double [][] matriz, int colum, double valor){
        long inicio_mayores = System.currentTimeMillis();

        LinkedList<Integer> indicesDeLasFilasMayores = new LinkedList();
        for (int i = 0; i < matriz.length  ; i++) {
            if (matriz[i][colum] >= valor)
                indicesDeLasFilasMayores.add(i);
        }
        double [][] grandes = new double[indicesDeLasFilasMayores.size()][matriz[0].length];
        int indice = 0;
        for (int i = 0; i < grandes.length ; i++) {
            for (int j = 0; j < grandes[0].length; j++) {
                grandes[i][j] = matriz[indicesDeLasFilasMayores.get(indice)][j];
            }
            indice++;
        }
        double[][] recorte = recortada(grandes,colum);

        long fin_mayores = System.currentTimeMillis();
        long total_mayores = fin_mayores - inicio_mayores;
        System.out.println("Tiempo de ejecución para la matriz de mayores: " + total_mayores + "ms");

        return recorte;
    }

    public static LinkedList<Integer> indicesMayores(double [][] matriz, int colum, double valor) {
        long inicio_indicesMay = System.currentTimeMillis();

        LinkedList<Integer> indicesDeLasFilasMayores = new LinkedList();
        for (int i = 0; i < matriz.length  ; i++) {
            if (matriz[i][colum] >= valor)
                indicesDeLasFilasMayores.add(i);
        }

        long fin_indicesMay = System.currentTimeMillis();
        long total_indicesMay = fin_indicesMay - inicio_indicesMay;
        System.out.println("Tiempo de ejecución para indicesMayores(__): " + total_indicesMay + "ms");

        return indicesDeLasFilasMayores;
    }

    public static LinkedList<Integer> indicesMenores(double [][] matriz, int colum, double valor) {
        long inicio_indicesMen = System.currentTimeMillis();

        LinkedList<Integer> indicesDeLasFilasMenores = new LinkedList();
        for (int i = 0; i < matriz.length  ; i++) {
            if (matriz[i][colum] < valor)
                indicesDeLasFilasMenores.add(i);
        }

        long fin_indicesMen = System.currentTimeMillis();
        long total_indicesMen = fin_indicesMen - inicio_indicesMen;
        System.out.println("Tiempo de ejecución para indicesMayores(__): " + total_indicesMen + "ms");

        return indicesDeLasFilasMenores;
    }

    public static double[][]  menores (double [][] matriz, int colum, double valor) {
        long inicio_menores = System.currentTimeMillis();

        LinkedList<Integer> indicesMenores = new LinkedList();
        for (int i = 0; i < matriz.length  ; i++) {
            if (matriz[i][colum] < valor)
                indicesMenores.add(i);
        }
        double [][] pequeños = new double[indicesMenores.size()][matriz[0].length];
        int indice = 0;
        for (int i = 0; i < pequeños.length ; i++) {
            for (int j = 0; j < pequeños[0].length; j++) {
                pequeños[i][j] = matriz[indicesMenores.get(indice)][j];
            }
            indice++;
        }
        double[][] recorte = recortada(pequeños,colum);

        long fin_menores = System.currentTimeMillis();
        long total_menores = fin_menores - inicio_menores;
        System.out.println("Tiempo de ejecución para la matriz de menores: " + total_menores + "ms");

        return recorte;
    }
}

