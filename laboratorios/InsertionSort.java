public class InsertionSortExample {  
	    public static void insertionSort(int array[]) {  
	        int n = array.length;  
	        for (int j = 1; j < n; j++) {  
	            int key = array[j];  
	            int i = j-1;  
	            while ( (i > -1) && ( array [i] > key ) ) {  
	                array [i+1] = array [i];  
	                i--;  
	            }  
	            array[i+1] = key;  
	        }  
	    }  
	       
	    public static void main(String a[]){    
	        long StartTime = System.currentTimeMillis();
	        int[] arr1 = {90,23,101,45,65,23,67,89,34,239};    
	        System.out.println("Before Insertion Sort");    
	        for(int i:arr1){    
	            System.out.print(i+" ");    
	        }    
	        System.out.println();    
	            
	        insertionSort(arr1);//sorting array using insertion sort    
	           
	        System.out.println("After Insertion Sort");    
	        for(int i:arr1){    
	            System.out.print(i+" ");    
	        } 
	        long endTime = System.currentTimeMillis();
	        long timeElapsed = endTime - StartTime;
	        System.out.println("Tiempo:" + timeElapsed);
	    }    
	}
