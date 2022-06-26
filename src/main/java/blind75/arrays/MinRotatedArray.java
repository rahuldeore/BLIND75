package blind75.arrays;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Difficulty: Medium
 * TODO: Edge cases were corrected by means of hacking. Need to revisit this to understand the core.
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array
 * nums = [0,1,2,4,5,6,7] might become:
 *
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2],
 * ..., a[n-2]].
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * You must write an algorithm that runs in O(log n) time.
 *
 * Example 1:
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2]
 * Output: 0
 * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
 *
 * Example 3:
 * Input: nums = [11,13,15,17]
 * Output: 11
 * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
 *
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * All the integers of nums are unique.
 * nums is sorted and rotated between 1 and n times.
 *
 * */
public class MinRotatedArray {
    public int findMin(int[] nums) {
        // Really bad performance due to stream
        /**List<Integer> numsList = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        return numsList.stream().min((Comparator.comparing(o -> o))).get();*/

        // O(n)
        /**int min=nums[0];
        for (int i=1; i<nums.length;i++) {
            if (min>nums[i]) {
                min=nums[i];
            }
        }
        return min;*/

        int start=0, end=nums.length-1, mid=(start+end)/2;

        if(nums.length == 1) {
            return nums[0];
        }
        while(mid > 0 && nums[mid-1] < nums[mid] && start != mid ) {
            if(nums[mid] > nums[end]) {
                start = mid;
                mid = (start+end)/2;
            } else {
                end=mid;
                mid=(start+end)/2;
            }
        }
        return nums[mid] < nums[mid+1] ? nums[mid] : nums[mid+1];
    }
    public static void main(String... args) {
        MinRotatedArray minRotatedArray = new MinRotatedArray();
        int[] nums1 = {7,0,1,2,3,4,5,6};
        int[] nums2 = {11,12,13,14,15,16};
        int[] nums3 = {5,6,7,8,9,1,2,3,4};
        int[] nums4 = {-100,-99,-98,-97};
        int[] nums5 = {-96,-95,-100,-99,-98,-97};
        int[] nums6 = {2,1};
        int[] nums7 = {2,3,1};
        int[] nums8 = {1};


        System.out.println("Expected : 0 | Actual : " + minRotatedArray.findMin(nums1));
        System.out.println("Expected : 11 | Actual : " + minRotatedArray.findMin(nums2));
        System.out.println("Expected : 1 | Actual : " + minRotatedArray.findMin(nums3));
        System.out.println("Expected : -100 | Actual : " + minRotatedArray.findMin(nums4));
        System.out.println("Expected : -100 | Actual : " + minRotatedArray.findMin(nums5));
        System.out.println("Expected : 1 | Actual : " + minRotatedArray.findMin(nums6)); //mid > 0 && nums[mid-1] < nums[mid]
        System.out.println("Expected : 1 | Actual : " + minRotatedArray.findMin(nums7)); //&& start != mid
        System.out.println("Expected : 1 | Actual : " + minRotatedArray.findMin(nums8)); //nums.length == 1
    }
}
