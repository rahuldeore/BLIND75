package blind75.binary;

import java.util.Random;

public class NumberOfOneBits {

    /*
    * Converts the num to binary string, then to char array of previous binary string and then counts 1's
    * */
    public int hammingWeightNew(int n) {
        int ones=0;

        char[] binaryNumChar = Integer.toBinaryString(n).toCharArray();

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
        int mask = 1;
        for (int i = 0; i <= 31; i++) {
            if ((n & mask) > 0)
                ones++;
            n = n >>> 1;
        }
        return ones;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while(n != 0) {
            int mask = 1;
            if((n & mask) != 0) count++;
            n >>>= 1;
        }

        return count;
    }

    public static void main(String... args) {


        NumberOfOneBits oneBits = new NumberOfOneBits();
        /*System.out.println(Integer.toBinaryString(num));


        System.out.println(Integer.toBinaryString(num >>> 1));
        System.out.println(Integer.toBinaryString(num >> 1));*/
        //System.out.print(oneBits.hammingWeight2(-3) + "\n");


        int iterations = 100;

        while (iterations > 0) {
            int randomNum = new Random().nextInt();
            if (oneBits.hammingWeight(randomNum) != oneBits.hammingWeightNew(randomNum)) {
                System.out.println("Failed to find hamming weight for: " + randomNum);
                return;
            }
            iterations--;
        }

        System.out.print("Hamming weight calculation successfully completed !");
    }
}
