public int countEvens(int[] nums) {
  int len = nums.length;
  int cont=0;
  for(int i=0;i<len;i++){
    if(nums[i]%2==0){
      cont++;
    }
  }
  return(cont);
}

public int bigDiff(int[] nums) {
  int max = nums[0];
  int min = nums[0];
  int len = nums.length;
  for (int i = 0; i < len; i++) {
    if (nums[i] > max){
      max = nums[i]; 
    }  
    if (nums[i] <= min){
      min = nums[i];
    } 
  }
  return max - min;
}

public int sum13(int[] nums) {
  int cont=0;
  int len = nums.length;
  for(int i=0;i<len;i++){
    if(nums[i] != 13){
      cont += nums[i];
    }
    else if(i<=len-1){
      i++;
    }
  }
  return cont;
}

public int sum67(int[] nums) {
  int sum = 0;
  for (int i = 0; i < nums.length; i++) {
    if (nums[i] != 6){
      sum += nums[i];
    }else{
      while(nums[i] != 7){
       i++;
      }
    }
  }
  return sum;
}

public boolean has22(int[] nums) {
  for(int i = 0; i <= nums.length - 2; i++){
    if(nums[i] == 2 && nums[i + 1] == 2){
      return true;
    }
  }
  return false;
}
