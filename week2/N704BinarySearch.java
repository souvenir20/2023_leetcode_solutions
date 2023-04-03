public class N704BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int middle = (left + right)/2;
        while(nums[middle] != target && left < right){
            if(nums[middle] > target){
                right = middle - 1;
            }
            else{
                left = middle + 1;
            }
            middle = (left + right) / 2;
        }
        if(nums[middle] == target){
            return middle;
        }
        else{
            return -1;
        }
    }
}
