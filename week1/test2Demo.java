import array.*;
class testDemo{
	public static void main(String[] args){
		int[] test1Nums = {1,1,1,2,3};
		int[] test2Nums = {1,10,100,100,1000};
		int[] test3Nums = {};
		int[] runningSum1 = Solution.runningSum(test1Nums);
		for(int element:runningSum1){
			System.out.println(element);
		}
		int index1 = N724_FindThePivotIndex.pivotIndex(test1Nums);
		int index2 = N724_FindThePivotIndex.pivotIndex(test2Nums);
		System.out.println("index1 = "+index1 +"index2 = "+index2);
	}
}
