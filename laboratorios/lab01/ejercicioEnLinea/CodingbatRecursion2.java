// ejercicio groupsum5
public boolean groupSum5(int start, int[] nums, int target) {
  if(start >= nums.length)
 	{
		if(target == 0)
  		return true;
  	return false;
 	}
 	if(nums[start] % 5 == 0)
 	{
 		if(start < nums.length - 1 && nums[start+1] == 1)
	 		return groupSum5(start + 2, nums, target - nums[start]);
	 	return groupSum5(start + 1, nums, target - nums[start]);
 	}
  if(groupSum5(start + 1, nums, target - nums[start]))
  	return true;
  return groupSum5(start + 1, nums, target);
}


// Ejercicio groupsum6
public boolean groupSum6(int start, int[] nums, int target) {
  if(start == nums.length)
 	{
		if(target == 0)
  		return true;
  	return false;
 	}
 	if(nums[start] == 6)
 		return groupSum6(start + 1, nums, target - nums[start]);
  if(groupSum6(start + 1, nums, target - nums[start]))
  	return true;
  return groupSum6(start + 1, nums, target);
}


// GroupNoAjd
public boolean groupNoAdj(int start, int[] nums, int target) {
  	if(target == 0)
  	return true;
  if(start >= nums.length)
  	return false;
  if(groupNoAdj(start + 2, nums, target - nums[start]))
  	return true;
  return groupNoAdj(start + 1, nums, target);
}


// groupSumClump
public boolean groupSumClump(int start, int[] nums, int target) {
  if(start >= nums.length)
 	{
		if(target == 0)
  		return true;
  	return false;
 	}
 	int a = start + 1;
 	for(;  a < nums.length && nums[start] == nums[a]; a++);
 	if(groupSumClump(a, nums, target - ((a - start) * nums[start])))
 		return true;
 	return groupSumClump(a, nums, target);	
}


// Split53
public boolean split53(int[] nums) {
  return rec(nums, 0, 0);
}

public boolean rec(int[] nums, int a, int b)
{
	if(a == nums.length)
		return (b == 0);
	if(nums[a] % 5 == 0)
		return rec(nums, a + 1, b + nums[a]);
	if(nums[a] % 3 == 0)
		return rec(nums, a + 1, b - nums[a]);
	if(rec(nums, a + 1, b + nums[a]))
		return true;
	return rec(nums, a + 1, b - nums[a]);
}
