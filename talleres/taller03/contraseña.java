public class contraseña {
    public static void combination(String s) { 
        combinationsAux("", s); 
        }

   
   public static void combinationsAux(String prefix, String s) {  
        if (s.length()>0) { 
            System.out.println(prefix+s.charAt(0));   
            combinationsAux(prefix + s.charAt(0), s.substring(1)); 
            combinationsAux(prefix , s.substring(1));        
        }
    }

}
