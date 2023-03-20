import array.Solution;
class Solution1{
	public static int pivotIndex(int[] nums) {
		if(nums.length == 0){
			return -1;
		}
		else if(nums.length == 1){
			return 0;
		}
		int[] runningSum_from_left = Solution.runningSum(nums);
		int[] runningSum_from_right = new int[nums.length];
		runningSum_from_right[0] = runningSum_from_left[nums.length-1];
		for(int i = 1;i<nums.length;i++){
			runningSum_from_right[i] = runningSum_from_right[0] - runningSum_from_left[i-1];
		}
		for(int i = 0;i < nums.length-1;i++){
			if(runningSum_from_left[i] == runningSum_from_right[i]){
				return i;
			}
		}
		return -1;
	}

}
class N724_FindThePivotIndex{
	public static void main(String[] args){
		int[] test1Nums = {1,10,100,1000,10000};
		int[] test2Nums = {2,1,-1};
		int index1 = Solution1.pivotIndex(test1Nums);
		int index2 = Solution1.pivotIndex(test2Nums);
		System.out.println("index1 = "+index1 +"index2 = "+index2);
	}
}
