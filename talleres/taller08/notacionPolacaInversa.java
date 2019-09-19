package pilapolishnotation;
import java.util.*;
public class notacionPolacaInversa {

    public static int polaca  (String elString){
        String[] elemento = elString.split(" "); 
        Stack<Integer> pila= new Stack<>();
        int len = elemento.length;
        
        
        for(int i=0;i<elemento.length;i++){
            if(elemento[i].equals("+")){
                int b = pila.peek();
                pila.pop();
                int a = pila.peek();
                pila.pop();
                pila.push(a+b);
            }
            else if(elemento[i].equals("*")){
                int b = pila.peek();
                pila.pop();
                int a = pila.peek();
                pila.pop();
                pila.push(a*b);
            }
            else if(elemento[i].equals("-")){
                int b = pila.peek();
                pila.pop();
                int a = pila.peek();
                pila.pop();
                pila.push(a-b);
            }
            else if(elemento[i].equals("/")){
                int b = pila.peek();
                pila.pop();
                int a = pila.peek();
                pila.pop();
                pila.push(a/b);
            }
            else{
                pila.push(Integer.parseInt(elemento[i]));
            }
        }
        return (pila.pop());
    }
