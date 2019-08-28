MaxSpan
public int maxSpan(int[] nums) {
    if (nums.length > 0) {
        int maxSpan = 1;
        for (int j = 0; j < nums.length; j++)
            for (int i = nums.length - 1; i > j; i--)
                if (nums[i] == nums[j]) {
                    int contador = (i - j) + 1;
                    if (contador > maxSpan) maxSpan = contador;
                    break;
                }
        return maxSpan;
    } else return 0;
}


Fix34
public int[] fix34(int[] nums) {
    for (int i = 0; i < nums.length; i++)
        if (nums[i] == 3) {
            int t = nums[i + 1];
            nums[i + 1] = 4;
            for (int a = i + 2; a < nums.length; a++)
                if (nums[a] == 4) nums[a] = t;
        }
    return nums;
}


Fix45
public int[] fix45(int[] nums) {
    for (int z = 0; z < nums.length; z++)
        if (nums[z] == 5 && z == 0 || nums[z] == 5 && nums[z - 1] != 4) {
            int p = z;
            for (int j = 0; j < nums.length; j++)
                if (nums[j] == 4 && nums[j + 1] != 5) {
                    int t = nums[j + 1];
                    nums[j + 1] = 5;
                    nums[p] = t;
                    break;
                }
    }
    return nums;
}

CanBalance
public boolean canBalance(int[] nums) {
  int Suma1 = 0;
   
  for (int i = 0; i < nums.length; i++) {
    Suma1 += nums[i];
    int Suma2 = 0;
    for (int j = nums.length-1; j > i; j--) {
      Suma2 += nums[j];
    }
    if (Suma2 == Suma1)
      return true;
  }
  return false;
}

LinearIn

public boolean linearIn(int[] outer, int[] inner) {
  int n = 0;
  if(inner.length == 0) {
     return true;
  }
   
  int a = 0; 

  for(int i = 0; i < outer.length; i++) {
     if(outer[i] == inner[a]) {
        n++;
        a++;
     } else if(outer[i] > inner[a]) {
        return false;
     }
      
     if(n == inner.length) 
        return true;
  }
       
  return false;
}
