package blind75.binary;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
 * Example 3:
 *
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * All the numbers of nums are unique.
 *
 * */
public class MissingNumber {
    /*
    * Trivial solution. Since the array will be 0 to n, get the sum of all numbers until n and start subtracting each
    * number from nums array from the totalSum. The leftover is the missing number.
    * */
    public int missingNumber(int[] nums) {

        int sumUntilN = 0, length=nums.length;
        for (int n=1; n<=nums.length; n++) {
            sumUntilN += n;
        }
        System.out.println(sumUntilN);
        System.out.println(length * ((length/2)+1));
        for (int n : nums) {
            sumUntilN -= n;
        }
        return sumUntilN;
    }

    /*
    * Same as above just the sumUntilN is mathematically calculated. This is fastest for java platform.
    * */
    public int missingNumber2(int[] nums) {
        int sumUntilN = 0, length=nums.length;
        sumUntilN = ((length * (length+1) )/ 2);

        for (int n : nums) {
            sumUntilN -= n;
        }
        return sumUntilN;
    }

    /*
    * using XOR bit manipulation. Slower on java platform.
    * */
    public int missingNumber3(int[] nums) {

        int missing=nums.length;
        for(int i=0; i<nums.length; i++) {
            missing = missing ^ i;
            System.out.print(missing + " ");
            missing = missing ^ nums[i];
            System.out.println(missing);
        }
        return missing;
    }

    public static void main (String... args) {
        long startTime, endTime, totalTimeTaken;
        int result;

        MissingNumber mNumber = new MissingNumber();

        int[] nums = {9,6,4,2,3,5,7,0,1};

        startTime = System.nanoTime();
        result = mNumber.missingNumber(nums);
        endTime = System.nanoTime();
        System.out.println("Result is: " + result + ". It took total time of: " + (endTime-startTime) + " nanoseconds");
        startTime = System.nanoTime();
        result = mNumber.missingNumber2(nums);
        endTime = System.nanoTime();
        System.out.println("Result is: " + result + ". Optimized method took total time of: " + (endTime-startTime) + " nanoseconds");


        int[] nums2 = {9,6,4,2,3,5,7,0,1,8,10,11,12,13,15};

        startTime = System.nanoTime();
        result = mNumber.missingNumber(nums2);
        endTime = System.nanoTime();
        System.out.println("Result is: " + result + ". It took total time of: " + (endTime-startTime) + " nanoseconds");
        startTime = System.nanoTime();
        result = mNumber.missingNumber2(nums2);
        endTime = System.nanoTime();
        System.out.println("Result is: " + result + ". Optimized method took total time of: " + (endTime-startTime) + " nanoseconds");

        int[] nums3 = {0,1};

        startTime = System.nanoTime();
        result = mNumber.missingNumber2(nums3);
        endTime = System.nanoTime();
        System.out.println("Result is: " + result + ". Optimized method took total time of: " + (endTime-startTime) + " nanoseconds");

        result = mNumber.missingNumber3(nums2);
        endTime = System.nanoTime();
        System.out.println("Result is: " + result + ". Optimized method took total time of: " + (endTime-startTime) + " nanoseconds");

    }
}
