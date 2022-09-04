package blind75.binary;

import java.util.Random;

public class NumberOfOneBits {

    /*
    * Converts the num to binary string, then to char array of previous binary string and then counts 1's
    * */
    public int hammingWeightNew(int num) {
        int ones=0;

        char[] binaryNumChar = Integer.toBinaryString(num).toCharArray();

        for(char c : binaryNumChar) {
            if (c == '1') {
                ones++;
            }
        }

        return ones;
    }

    /*
    * Uses bit masking to find number of 1's
    * */
    public int hammingWeight(int n) {
        int ones = 0;
        int mask;
        for (int i = 31; i >= 0; i--) {
            mask = 1 << i;
            if ((n & mask) > 0)
                ones++;
        }
        return ones;
    }

    public static void main(String... args) {

        NumberOfOneBits oneBits = new NumberOfOneBits();
        //System.out.print(oneBits.hammingWeight(75));

        int iterations = 100;

        while (iterations > 0) {
            int randomNum = new Random().nextInt(100000);
            if (oneBits.hammingWeight(randomNum) != oneBits.hammingWeightNew(randomNum)) {
                System.out.println("Failed to find hamming weight for: " + randomNum);
                break;
            }
            iterations--;
        }

        System.out.print("Hamming weight calculation successfully completed !");
    }
}
