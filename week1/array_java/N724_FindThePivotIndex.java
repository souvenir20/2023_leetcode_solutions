package array;
import array.*;
public class N724_FindThePivotIndex{
	public static int pivotIndex(int[] nums) {
		if(nums.length == 0){
			return -1;
		}
		else if(nums.length == 1){
			return 0;
		}
		int[] runningSum_from_left = N1480_RunningSumof1dArray.runningSum(nums);
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
