import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Repertorio {
    static ArrayList<Dato> dato = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        //PrintStream fil = new PrintStream(new File("PRUEBA.txt"));
        long start = System.currentTimeMillis();

        archivo_leer(seleccionarDataset());
        int marc[] = llenarLabel();
        double matriz[][] = recolectarDatos();

        Nodo raizArbol = new Nodo(matriz, marc);
        Arbol tree = new Arbol(raizArbol);

        System.out.println("Aquí está la raiz " + tree.toString());

        long fin = System.currentTimeMillis();
        long total = fin - start;

        System.out.println("Tiempo de ejecucion total: " + total + "ms");
        System.out.println();
        System.out.println("Memoria usada para todo el programa:");
        System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
        System.out.println("MB: " + (double) ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024)/1024);
    }


    public static void archivo_leer(String data) {
        long start_leer = System.currentTimeMillis();
        try {
            PrintWriter writ = new PrintWriter("Datos.txt");
            File file = new File(data);
            Scanner scanner = new Scanner(file);
            writ.println("Ph\t    soil_temperature\tsoil_moisture   " +
                    "  illuminance   env_temperature   env_humidity\t\t marc");
            scanner.nextLine();
            String[] str = new String[7];
            System.out.println("Ph\t    soil_temperature\tsoil_moisture   " +
                    "  illuminance   env_temperature   env_humidity\t\t marc");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] test = line.split(",");
                for (int j = 0; j < str.length; j++) {
                    if (j >= test.length) {
                        str[j] = "";
                    } else {
                        str[j] = test[j];
                    }
                }

                dato.add(new Dato(Double.parseDouble(str[0]), Double.parseDouble(str[1]),
                        Double.parseDouble(str[2]), Double.parseDouble(str[3]),
                        Double.parseDouble(str[4]), Double.parseDouble(str[5]), (str[6])));
                for (String s : str) {
                    System.out.print(s + "\t\t\t  ");
                    writ.print(s + " \t\t\t ");
                }
                System.out.println();
                writ.println();
            }
            writ.close();
        } catch (FileNotFoundException e) {
            System.err.println("No encontado" + e.toString());
        }

        long fin_leer = System.currentTimeMillis();
        long total_leer = fin_leer - start_leer;
        System.out.println("Tiempo de ejecucion de archivo_leer: " + total_leer + "ms");
        System.out.println();
        System.out.println("Memoria usada para archivo_leer:");
        System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
        System.out.println("MB: " + (double) ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024)/1024);
    }


    public static String seleccionarDataset() {
        long start_selec = System.currentTimeMillis();
        Scanner teclado = new Scanner(System.in);
        String uno = "data_set.csv";
        String dos = "data_set_balanced.csv";
        String tres = "data_set_train.csv";
        String cuatro = "data_set_test.csv";
        System.out.println("Seleccione el dataset que desea usar.");
        System.out.println("1. " + uno);
        System.out.println("2. " + dos);
        System.out.println("3. " + tres);
        System.out.println("4. " + cuatro);
        String data = "";
        int a = 0;
        do {
            try {
                a = Integer.parseInt(teclado.nextLine());
                switch (a) {
                    case 1:
                        data = uno;
                        break;
                    case 2:
                        data = dos;
                        break;
                    case 3:
                        data = tres;
                        break;
                    case 4:
                        data = cuatro;
                        break;
                    default:
                        a = 0;
                        throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("El valor ingresado no es valido. \nIntente nuevamente.");
            }
        } while (a == 0);
        long fin_selec = System.currentTimeMillis();
        long total_selec = fin_selec - start_selec;
        System.out.println("Tiempo de ejecución para seleccionarDataset(): " + total_selec + "ms");

        return data;
    }


    public static double[][] recolectarDatos() throws Exception {
        long start_recol = System.currentTimeMillis();

        //Metodo para llenar la matriz
        int filas = dato.size();
        double[][] matriz5 = new double[filas][6];
        for (int i = 0; i < filas ; i++) {
            for (int j = 0; j < 6; j++) {
                matriz5[i][j] = dato.get(i).getValue(j);
            }
        }
        long fin_recol = System.currentTimeMillis();
        long total_recol = fin_recol - start_recol;
        System.out.println("Tiempo de ejecución para recolectarDatos(): " + total_recol + "ms");
        return matriz5;
    }

    public static int[] llenarLabel() {
        long start_llenar = System.currentTimeMillis();

        int marc5 [];
        int filas = dato.size();
        marc5 = new int [filas];
        for (int i = 0; i < filas ; i++) {
            if (dato.get(i).getmarc().compareToIgnoreCase("yes") == 0) {
                marc5[i] = 1;
            } else {
                marc5[i]=0;
            }
        }

        long fin_llenar = System.currentTimeMillis();
        long total_llenar = fin_llenar - start_llenar;
        System.out.println("Tiempo de ejecución para llenarLabel(): " + total_llenar + "ms");

        return marc5;
    }
}
