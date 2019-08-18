import java.util.Scanner;
 
public class SCML{ //Subsecuencia Común Más Larga
 
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String A = scn.nextLine();
        String B = scn.nextLine();
        System.out.println(SCML(A, B));
    }
    public static int SCML(String A, String B){ 
        if(A.length()==0 || B.length()==0){
            return 0;
        }
        String resA = A.substring(1);
	String resB = B.substring(1);
		
	if(A.charAt(0)==B.charAt(0)){
            int resRes = SCML(resA, resB);
            return 1 + resRes;
	}else {
            int remRes = Math.max(SCML(resA, B), SCML(A, resB));
            return remRes;
	}
    }
 
}
