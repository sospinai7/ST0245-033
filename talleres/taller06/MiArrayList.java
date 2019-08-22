import java.util.*;
public class MiArrayList{
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[]; 

    public MiArrayList() {
        size = 0;
        elements = new int[DEFAULT_CAPACITY]; 
    }     

    public int size() {
        return size;
    }   

    public void add(int e) {
        if (size == elements.length) { // C1 = 2      O(1)
            int[] nuevo = new int[elements.length*2]; // C2 = 3   O(1)
            for (int i = 0; i < elements.length; i++){ // C3 + C4n O(n)
                nuevo[i] = elements[i];  // C5n             O(n)
            }
            elements = nuevo;    //C6         O(1)
        }
        elements[size] = e; // C7        O(1) 
        size++; // C8    
    }    

    public int get(int i) {
        if (i < size && i > 0) {
	    return elements[i];
	}else {
	    throw new IndexOutOfBoundsException("Index : " + i);
	}
    }

    public void add(int index, int e) {
        //...
    } 

    public void del(int index){
        //...
    }
    
}
