class Solution{
	public static int[] runningSum(int[] nums){
		int size = nums.length;
		if(size == 0){
			int[] None = {};
			return None;
		}
		else if(size == 1){
			return nums;
		}
		int[] runningSum = new int[size];
		runningSum[0] = nums[0];
		for(int i = 1; i < size; i++){
			runningSum[i] = runningSum[i-1] + nums[i];
		}
		return runningSum;
	}
}

class N1480_RunningSumof1dArray{
	public static void main(String[] args){
		int[] test1Nums = {1,10,100,1000,10000};
		int[] runningSum1 = Solution.runningSum(test1Nums);
		for(int element:runningSum1){
			System.out.println(element);
		}
	}

}
