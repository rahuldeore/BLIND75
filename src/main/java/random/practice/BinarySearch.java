package random.practice;

import java.util.*;

/**
 * Solve this so that you can refer to this in later problem as needed.
 * */

public class BinarySearch {
    // Assume nums array is sorted
    public int binarySearch(int[] nums, int target) {
        int length=nums.length, low=0, high=length-1, mid;
        while  (low <= high) {
            mid = (low+high)/2;
            if (target == nums[mid]) {
                return mid;
            } else {
                if (target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public int linearSearch (int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public int[] randomArray() {
        Random random = new Random();
        int numsSize = random.nextInt(8);
        int[] nums = new int[numsSize];

        for (int i=0; i<numsSize; i++) {
            nums[i] = random.nextInt(10);
        }
        nums = removeDupes(nums); // removes duplicate elements and sort the array
        return nums;
    }

    public int[] removeDupes (int[] nums) {
        int length = nums.length;
        SortedSet<Integer> numSet = new TreeSet<>();
        for (int num : nums) {
            int newNum = num;
            if (numSet.contains(newNum)) {
                newNum = new Random().nextInt(10);
                while (numSet.contains(newNum)) {
                    newNum = new Random().nextInt(10);
                }
            }
            numSet.add(newNum);
        }
        Object[] obj = numSet.toArray();
        for (int i=0; i<length; i++) {
            nums[i] = (int)obj[i];
        }
        return nums;
    }
    public static void main (String... args){
        BinarySearch bsearch = new BinarySearch();

        int numTests = 100;
        while (numTests > 0) {
            int[] nums = bsearch.randomArray();
            int length = nums.length, target = new Random().nextInt(10);
            System.out.println("\nArray length: " + length + " | Target: " + target);
            for (int num : nums) {
                System.out.print(num + " ");
            }

            System.out.println();

            if (bsearch.binarySearch(nums, target) != bsearch.linearSearch(nums, target)) {
                System.out.println("===========FAILED THIS TEST CASE===========");
                return;
            }

            numTests--;
        }
        System.out.println("\nAll test passed !!!!");
    }
}
