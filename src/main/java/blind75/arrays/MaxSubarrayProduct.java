package blind75.arrays;

/**
 * Difficulty: Medium
 * TODO: Does not pass all test cases. Fix this.
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * A subarray is a contiguous subsequence of the array.
 *
 * Example 1:
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * */
public class MaxSubarrayProduct {
    public int maxProduct(int[] nums) {
        int product=nums[0], maxProduct=nums[0];
        int signCount=0;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] < 0) {
                signCount++;
            }
        }

        for(int i=1; i<nums.length; i++) {
            if(nums[i] < 0) signCount--;

            if (product == 0) {
                product = nums[i];
            } else {
                product = product * nums[i];
            }

            if (product < 0 && signCount%2==1) {
                continue;
            } else {
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    public static void main(String... args) {
        MaxSubarrayProduct maxProduct = new MaxSubarrayProduct();

        int[] nums={2,3,-2,4};
        System.out.println("Expected output: 6 | Actual output: " + maxProduct.maxProduct(nums));

        int[] nums2={-2,3,-4};
        System.out.println("Expected output: 24 | Actual output: " + maxProduct.maxProduct(nums2));

        int[] nums3={0,2};
        System.out.println("Expected output: 2 | Actual output: " + maxProduct.maxProduct(nums3));

        int[] nums4={3,-1,4};
        System.out.println("Expected output: 4 | Actual output: " + maxProduct.maxProduct(nums4));

    }
}