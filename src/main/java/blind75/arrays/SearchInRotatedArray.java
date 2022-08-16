package blind75.arrays;


import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
 * or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 *
 * Constraints:
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -104 <= target <= 104
 * */
public class SearchInRotatedArray {
    public int search_linear(int[] nums, int target) {
        // Linear search. Need to find O(log n) solution.
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int result;
        int length = nums.length;
        if (length == 1) {
            if (target == nums[0])
                return 0;
            else
                return -1;
        }
        // Array is rotated length times, do direct binary search
        if (nums[0] < nums[length-1]) {
            result = binarySearch(nums, target, 0, nums.length-1);
        } else {
            int start = 0, end = length - 1, mid = (int) Math.ceil((start + end) / 2.0);
            // Find the infliction point, then search in subarray
            while (mid > 0 && nums[mid - 1] < nums[mid]) {
                if (nums[mid] > nums[end]) {
                    start = mid;
                    mid = (int) Math.ceil((start + end) / 2.0);
                } else {
                    end = mid;
                    mid = (int) Math.floor((start + end) / 2.0);
                }
            }

            int inflictionPoint = nums[mid-1] < nums[mid] ? mid-1 : mid;

            // where does target lies in the original nums ?
            if (target >= nums[inflictionPoint] && target <= nums[length - 1]) {
                int to = inflictionPoint == length-1 ? length : length-1;
                result = binarySearch(nums, target, inflictionPoint, to);
                //result = result == -1 ? result : result + inflictionPoint;
            } else {
                result = binarySearch(nums, target, 0, inflictionPoint - 1);
            }
        }
        return result;
    }
    public int binarySearch(int[] nums, int target, int start, int end) {
        int result=-1;
        int low=start, high=end, mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return result;
    }

    public static void main(String... args) {
        SearchInRotatedArray search = new SearchInRotatedArray();
        int[] nums = {4,5,6,7,8,9,1,2,3};
        int[] nums2 = {1,2,3,4,5,6,7,8,9};
        int[] nums3 = {4,5,6,7,0,1,2};
        int[] nums4 = {1}; // Target 0. failed at this test case. Resolved
        int[] nums5 = {1,3}; // Target 0. Failed at this test case. Resolved
        int[] nums6 = {1,3}; // Target 2. Failed at this test case. Resolved with updated binary search.
        int[] nums7 = {3,1};
        /*if (search.search(nums2, 1) == search.search_2(nums2, 1)) {
            System.out.println("Found");
        }*/
        System.out.println(search.search(nums, 1)); // 6
        System.out.println(search.search(nums2, 4)); // 3
        System.out.println(search.search(nums3, 5)); // 1
        System.out.println(search.search(nums4, 0)); // -1
        System.out.println(search.search(nums5, 0)); // -1
        System.out.println(search.search(nums6, 2)); // -1
        System.out.println(search.search(nums6, 3)); // 1
        System.out.println(search.search(nums7, 0)); // -1
        System.out.println(search.search(nums7, 1)); // 1
        System.out.println(search.search(nums7, 3)); // 0
    }
}
