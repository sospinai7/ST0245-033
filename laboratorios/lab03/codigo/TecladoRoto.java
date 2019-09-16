import java.util.*;
public class TecladoRoto{
    //Punto 2.1
    public static void teclado(String a){
        LinkedList<String>texto = new LinkedList<>();
        
        int k = 0;
        for (int i = 0; i < a.lenght(); i++) 
        {
            if (a.CharAt(i) == '[') 
            {
                  lista.addLast(a.substring(k, i));
                  for (int j = i; j < a.length(); j++) 
                  {
                        if (a.CharAt(j)==']') 
                        {
                            lista.addFirst(a.substring(i+1,j));
                            k = j +1;
                        }
                        else if (j == a.length() -1) 
                        {
                            lista.addFirst(a.sibstring(i+1, j+1));
                        }
                  }
            }
        }
        String listaFinal = "";
        for (String e : lista) 
        {
            listaFinal = e
        }
        
        return listaFinal;
    }
}
