public class Subgrupo{ 
        public static boolean groupSum(int start, int[] nums, int target){
                if (start == nums.length){//C1
                  return target == 0; 
                }else{
                  return groupSum(start+1,nums, target - nums[start]) || groupSum(start+1,nums, target);  //T(n) = 2 T(n-1) + C2
                }
        }
}
