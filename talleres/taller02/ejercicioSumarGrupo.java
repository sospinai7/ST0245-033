	public class ejercicioSumarGrupo {
   public static boolean SumaGrupo(int start, int[] nums, int target) {
    if(start == nums.length){
	    return target == 0;
	  }
    else
      return sumaGrupo(start+1, nums, target) || sumaGrupo( start+1, nums, target = nums[start]);
 	}	
 }
