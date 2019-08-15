public class Fibonacci{
   public static long fibonacci(int n) { 
    	if(n <= 1){                                     //C1
		    return 1;
    	}else{
		    return fibonacci(n-1) + fibonacci(n-2); // T(n)=C2+T(n-1)+T(n-2)
    	}
   }
}
