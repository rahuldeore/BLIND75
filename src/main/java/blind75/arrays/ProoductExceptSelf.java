package blind75.arrays;
/**
 * Difficulty: Medium
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * */
public class ProoductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int product = 1, zeroCount=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                if (zeroCount > 1) {
                    // all nums in answer array will be 0, then return the array
                    for(int j=0; j<answer.length; j++) {
                        answer[j] = 0;
                    }
                    return answer;
                } else {
                    continue;
                }
            }
            product = product * nums[i];
        }


        if (zeroCount == 1) {
            for (int i=0; i<nums.length; i++) {
                if (nums[i] != 0) {
                    answer[i] = 0;
                } else {
                    answer[i] = product;
                }
            }
        } else {
            for (int i=0; i<nums.length; i++) {
                answer[i] = product / nums[i];
            }
        }
        return answer;
    }

}
