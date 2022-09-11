package blind75.binary;

/**
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 *
 * Input: a = 2, b = 3
 * Output: 5
 *
 * Constraints:
 *
 * -1000 <= a, b <= 1000
 * */
public class SumOfTwoInts {
    public int getSum(int a, int b) {
        int result, carry;
        carry = a & b; // carry gets generated only after AND operation
        result = a ^ b; // result is always XOR operation of two numbers

        while (carry != 0) {
            int shiftedCarry = carry << 1;
            carry =  result & shiftedCarry;
            result = result ^ shiftedCarry;
        }
    return result;
    }

    /*
    * More optimized solution in terms of memory. From leetcode.
    *
    public int getSum(int a, int b) {

        while(b != 0) {
            int carry = a&b;
            a = a^b;
            b = carry << 1;
        }

        return a;

    }
    *
    * */

    public static void main(String... args) {
        SumOfTwoInts sum = new SumOfTwoInts();
        System.out.println(sum.getSum(1,2));
        System.out.println(sum.getSum(3,20));
        System.out.println(sum.getSum(10,10));
        System.out.println(sum.getSum(10,-10));
        System.out.println(sum.getSum(10,0));
        System.out.println(sum.getSum(53,29));
        System.out.println(sum.getSum(-10,-10));

    }
}
/*

0000 0000 - 0
0000 0001 - 1
0000 0010 - 2
0000 0011 - 3
0000 0100 - 4
0000 0101 - 5
0000 0110 - 6
0000 0111 - 7
0000 1000 - 8
0000 1001 - 9
0000 1010 - 10
0000 1011 - 11
0000 1100 - 12
0000 1101 - 13
0000 1110 - 14
0000 1111 - 15

0001 0000 - 16
0001 0001 - 17
0001 0010 - 18
0001 0011 - 19
0001 0100 - 20
0001 0101 - 21
0001 0110 - 22
0001 0111 - 23

20 + 20
0001 0100
0001 0100


*/

