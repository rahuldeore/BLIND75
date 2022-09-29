package blind75.binary;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Note:
 *
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 *
 *
 * Example 1:
 *
 * Input: n = 00000010100101000001111010011100
 * Output:    964176192 (00111001011110000010100101000000)
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 * Example 2:
 *
 * Input: n = 11111111111111111111111111111101
 * Output:   3221225471 (10111111111111111111111111111111)
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
 *
 *
 * Constraints:
 *
 * The input must be a binary string of length 32
 * */
public class ReverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int mask = 1, result=0;
        int lsb;
        for (int i=0; i<31; i++) {
            lsb=n&mask;
            result|=lsb;
            result<<=1;
            n>>>=1;
        }
        lsb=n&mask;
        result|=lsb;
        return result;
    }

    public static void main(String... args) {
        ReverseBits rBits = new ReverseBits();
        System.out.println("Original bits: " + Integer.toBinaryString(15) + "\nReversed bits: " + Integer.toBinaryString(rBits.reverseBits(15)) + "\n-----\n");

        System.out.println("Original bits: " + Integer.toBinaryString(-3) + "\nReversed bits: " + Integer.toBinaryString(rBits.reverseBits(-3)) + "\n-----\n");

        System.out.println("31times left shift 1 " + (1<<31));
        System.out.println("31times left shift 1 in binary " + Integer.toBinaryString((1<<31)));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE>>>2));
        System.out.println("Original bits: " + Integer.toBinaryString(15) + "\nReversed bits: " + Integer.toBinaryString(rBits.reverseBits(15)) + "\n-----\n");
        System.out.println("Original bits: " + Integer.toBinaryString(21) + "\nReversed bits: " + Integer.toBinaryString(rBits.reverseBits(21)) + "\n-----\n");
        System.out.println("Original bits: " + Integer.toBinaryString(0) + "\nReversed bits: " + Integer.toBinaryString(rBits.reverseBits(0)) + "\n-----\n");
        System.out.println("Original bits: " + Integer.toBinaryString(Integer.MAX_VALUE - 200) + "\nReversed bits: " + Integer.toBinaryString(rBits.reverseBits(Integer.MAX_VALUE - 200)) + "\n-----\n");
        System.out.println("Original bits: " + Integer.toBinaryString(43261596) + "\nReversed bits: " + Integer.toBinaryString(rBits.reverseBits(43261596)) + "\n-----\n");
    }


}
