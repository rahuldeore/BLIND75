package random.practice;

import java.util.Random;

/**
 * From Algorithmic Toolbox @ Coursera
 * Week1 - Problem 1
 * Note: does not handle negative numbers
 * */
public class MaxPairwiseProduct {

    public long maxPairwiseProduct(int[] nums) {
        long maxProduct = -1;
        int length = nums.length;
        for(int i=0; i<length; i++) {
            for (int j=i+1; j<length; j++) {
                long product = (long)nums[i] * (long)nums[j];
                if (maxProduct < product) {
                    maxProduct = product;
                }
            }
        }
        return maxProduct;
    }

    public long maxPairwiseProduct_Optimized(int[] nums) {
        long max1=Integer.MIN_VALUE, max2=max1, min1 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }
        return max1*max2;
    }

    public static void main(String... args) {

        MaxPairwiseProduct product = new MaxPairwiseProduct();
        /*int[] nums1 = {3, 2, 1, 9};
        System.out.println("Expected: " + product.product(nums1) +
                " | Actual: " + product.maxPairwiseProcuct(nums1));
        */

        /* Stress testing the solution */
        int testCases=1000, arrLength=1000;
        int[] nums = new int[arrLength];
        // Run these many test cases
        while (testCases > 0) {
            // initialize nums array for each test case
            testCases--;
            for (int i=0; i<arrLength; i++) {
                nums[i]= new Random().nextInt(100000); //number of digits for each number is multiple of 10
            }
            long output1 = product.maxPairwiseProduct(nums);
            long output2 = product.maxPairwiseProduct_Optimized(nums);
            if ( output1 != output2) {
                System.out.println("Error ||| Basic Solution: " + output1 + " | Optimized Solution: " + output2);
                for(int num : nums) {
                    System.out.print(num + " ");
                }
                return;
            }
        }
        System.out.println("\nAll tests pass !");
    }
}
