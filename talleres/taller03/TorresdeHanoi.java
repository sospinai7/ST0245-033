import java.util.*;
public class TorresdeHanoi{
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        int n = ent.nextInt();
        torresDeHannoi(n);
    }
    public static void torresDeHannoi(int n) {
        torresDeHannoiAux(n, 1, 2, 3);
    }
    public static void torresDeHannoiAux(int n, int origen, int intermedio, int destino) {
        if(n==1){
            System.out.println("El disco 1 de la torre 'origen' al 'destino'.");
        }
        else{
            torresDeHannoiAux(n-1, origen, destino, intermedio);
            System.out.println("Mover disco "+n+" de "+ origen + " a " + destino);
            torresDeHannoiAux(n-1, intermedio, origen, destino);
        }
    }
}

