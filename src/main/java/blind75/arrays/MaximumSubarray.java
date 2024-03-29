package blind75.arrays;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * A subarray is a contiguous part of an array.
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int maxSum=nums[0], localMaxSum=nums[0];
        for (int i=1; i<nums.length; i++) {
            localMaxSum = Math.max(localMaxSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, localMaxSum);
        }

        return maxSum;
    }

    public static void main(String... args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();

        int[] nums = {-1,-2,-3,-4,-5};
        System.out.println("Expected: -1 | Actual: " + maximumSubarray.maxSubArray(nums));
    }
}