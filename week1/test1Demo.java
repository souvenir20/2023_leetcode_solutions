package array;

import array.Solution;

class testDemo {
    public static void main(String[] args) {
        int[] test1Nums = { 1, 10, 100, 1000, 10000 };
        int[] runningSum1 = Solution.runningSum(test1Nums);
        for (int element : runningSum1) {
            System.out.println(element);
        }
    }
}
