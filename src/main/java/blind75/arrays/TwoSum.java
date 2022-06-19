package blind75.arrays;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * */
public class TwoSum {

    // O(n2) time complexity
    public int[] twoSum_1(int[] nums, int target) {

        int[] result = new int[2];
        int index1, index2;
        int length = nums.length;
        for (index1=0; index1 < length; index1++) {
            int num2 = target-nums[index1];
            for (index2=index1+1; index2 < length; index2++) {
                if (nums[index2] == num2) {
                    result[0] = index1;
                    result[1] = index2;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String... args) {
        int nums[] = {2,7,11,15};
        int target=9;
        TwoSum twoSum = new TwoSum();
        int result[] = twoSum.twoSum_1(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
