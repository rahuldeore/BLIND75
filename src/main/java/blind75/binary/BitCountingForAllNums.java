package blind75.binary;
/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * Example 2:
 *
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 *
 * Constraints:
 *
 * 0 <= n <= 105
 *
 *
 * Follow up:
 *
 * It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
 * Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
 *
 *
 * */
public class BitCountingForAllNums {
    /*
    * Worst solution. n.log n time.
    * */
    public int[] countBits(int n) {
        int res[] = new int[n+1];
        for (int i=0; i<=n; i++) {
            res[i] = getBits(i);
        }
        return res;
    }

    /*
     * Worst solution. n.log n time.
     * */
    public int[] countBits2(int n) {
        int res[] = new int[n+1];
        for (int i=0; i<=n; i++) {
            res[i] = popCount(i);
        }
        return res;
    }

    /*
    * From Leetcode solution section
    * uses the bit trickery for index. Elegant but do not see how can this occur in the mind at first place
    * */
    public int[] countBits3(int n) {
        int[] res = new int[n+1];

        for (int i=1; i<=n; i++) {
            res[i] = res[i & (i-1)] + 1;
        }
        return res;
    }

    /*
    * From leetcode best submission but slower than countBits3 leetcode elegant solution
    * */
    public int[] countBits4(int n) {
        int[] result = new int[n+1];
        countBits(n, 1, 1, result);
        return result;
    }

    static void countBits(int n, int start, int count, int[] result)
    {
        if (start > n) return;
        result[start] = count;
        start <<= 1;
        countBits(n, start, count, result);
        countBits(n, start + 1, count + 1, result);
    }

    /*
    * Bit masking subroutine
    * */
    public int getBits (int n) {
        int count=0, mask = 1;

        for (int i=0; i<32; i++) {
            if ((mask & n) > 0)
                count++;
            n >>>= 1;
        }
        return count;
    }

    /*
    * Bit counting
    * The idea here is that bitwise and'ing of number(n) and its predecessor (n-1) changes the least significant
    * 1 bit to 0
    * */
    public int popCount (int n) {

        int count=0;
        while (n != 0) {
            count++;
            n &= n-1;
        }
        return count;
    }

    public static void main (String... args) {
        BitCountingForAllNums counting = new BitCountingForAllNums();

        int n=1000;
        long startTime = System.nanoTime();
        int res[] = counting.countBits(n);
        long endTime = System.nanoTime();
        long perf1 = endTime-startTime;

        startTime = System.nanoTime();
        int res2[] = counting.countBits2(n);
        endTime = System.nanoTime();
        long perf2 = endTime-startTime;

        startTime = System.nanoTime();
        int[] res3 = counting.countBits3(n);
        endTime = System.nanoTime();
        long perf3 = endTime-startTime;

        startTime = System.nanoTime();
        int[] res4 = counting.countBits4(n);
        endTime = System.nanoTime();
        long perf4 = endTime-startTime;

        System.out.println("Performance of bit masking: " + perf1);
        System.out.println("Performance of bit counting2: " + perf2);
        System.out.println("Performance of bit counting3: " + perf3);
        System.out.println("Performance of bit counting4: " + perf4);

        for (int i=0; i<=100; i++) {
            if (res[i] != res2[i]) {
                System.out.println("The number " + i + " do not have same result from bitCount2 method");
                return;
            }
            if (res[i] != res3[i]) {
                System.out.println("The number " + i + " do not have same result from bitCount3 method");
                return;
            }
            if (res[i] != res4[i]) {
                System.out.println("The number " + i + " do not have same result from bitCount4 method");
                return;
            }
            System.out.print(res[i] + " ");
        }
        System.out.println("\nCounting bits completed successfully !");
    }
}
