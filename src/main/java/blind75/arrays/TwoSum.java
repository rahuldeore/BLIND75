package blind75.arrays;

import java.util.*;

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

    // Sort Array first and traverse using two pointers, left and right. bring them closer to find the right combination.
    // O(nlogn + 2n)
    public int[] twoSum_2(int[] nums, int target) {
        int length = nums.length;
        int[] result = new int[2];
        boolean found = false;

        int[] sortedNums = Arrays.copyOf(nums, length);
        Arrays.sort(sortedNums);

        int lIndex=0, rIndex=(length-1), sum=0;

        while (lIndex < rIndex) {
            sum = (sortedNums[lIndex] + sortedNums[rIndex]);
            if ( sum == target) {
                found = true;
                break;
            } else if ( sum < target) {
                lIndex++;
            } else {
                rIndex--;
            }
        }

        // When traversing for finding indexes on original array, consider the edge case of both numbers being same.
        // Added boolean left and right to make sure each index is updated only once.
        boolean left=false, right=false;
        if (found) {
            for (int i=0; i<length; i++) {
                if (!left && nums[i] == sortedNums[lIndex]) {
                    result[0] = i;
                    left=true;
                }
                if (!right && nums[i] == sortedNums[rIndex]) {
                    result[1] = i;
                    right=true;
                }
            }
        }
        return result;
    }

    // Ideally sounds faster but slower than the sorted array solution.
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        int length = nums.length;
        var hashNums = new HashMap<Integer, Integer>();
        int firstNum=0, secondNum=0;

        for (int i=0; i<length; i++) {
            hashNums.put(nums[i], i);
        }

        for(int i=0; i<length; i++) {
            firstNum = nums[i];
            secondNum = target - firstNum;
            if (hashNums.containsKey(secondNum) && hashNums.get(secondNum) != i) {
                result[0] = i;
                result[1] = hashNums.get(secondNum);
                break;
            }
        }
        return result;
    }

        public static void main(String... args) {
        int nums[] = {2,7,11,15};
        int target=9;
        TwoSum twoSum = new TwoSum();
        int result_1[] = twoSum.twoSum_1(nums, target);
        System.out.println(result_1[0] + " " + result_1[1]);

        int nums1[] = {3,3};
        int target1=6;
        int result[] = twoSum.twoSum(nums1, target1);
        System.out.println(result[0] + " " + result[1]);

        int nums2[] = {2,5,5,11};
        int target2=10;
        int result2[] = twoSum.twoSum(nums2, target2);
        System.out.println(result2[0] + " " + result2[1]);

        int nums3[] = {3,2,4};
        int target3=6;
        int result3[] = twoSum.twoSum(nums3, target3);
        System.out.println(result3[0] + " " + result3[1]);
    }
}
