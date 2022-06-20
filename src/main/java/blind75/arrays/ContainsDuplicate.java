package blind75.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * */
public class ContainsDuplicate {

    /*
    * Not very efficient, sorting takes most time
    * */
    public boolean containsDuplicate_1(int nums[]) {
        Arrays.sort(nums);

        for(int i=1; i<nums.length; i++) {
            if(nums[i-1] == nums[i]){
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate(int nums[]) {
        var hashedNums = new HashSet<Integer>();
        for (int i=0; i<nums.length; i++) {
            if (hashedNums.contains(nums[i])) {
                return true;
            } else {
                hashedNums.add(nums[i]);
            }
        }
        return false;
    }
}
