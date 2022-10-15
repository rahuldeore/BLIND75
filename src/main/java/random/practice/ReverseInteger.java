package random.practice;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 *
 *
 * Constraints:
 *
 * -2^31 <= x <= 2^31 - 1
 * */
public class ReverseInteger {
    public int reverse(int x) {
        int numCopy = x;
        int result=0;
        long temp;
        boolean sign = numCopy < 0;
        if (sign) {
            numCopy*=-1;
        }
        while (numCopy > 0) {
            temp = (long)result*10;
            if (temp > Integer.MAX_VALUE) return 0;
            result*=10;
            result+=(numCopy%10);
            numCopy/=10;
        }
        if(sign){
            result*=-1;
        }
        return result;
    }
    public static void main(String... args) {
        ReverseInteger rInt = new ReverseInteger();
        System.out.println("Reverse of 123 is: " + rInt.reverse(123));
        System.out.println("Reverse of -123 is: " + rInt.reverse(-123));
        System.out.println("Reverse of " + Integer.MIN_VALUE + " is: " + rInt.reverse(Integer.MIN_VALUE));
        System.out.println("Reverse of -2147483648 is: " + rInt.reverse(-2147483646));
        System.out.println("Reverse of 1534236469 is: " + rInt.reverse(1534236469));

    }
}
