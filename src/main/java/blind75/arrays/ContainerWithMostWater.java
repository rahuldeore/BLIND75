package blind75.arrays;
/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *         |                   |
 *         |                   |       |
 *         |   |               |       |
 *         |   |       |       |       |
 *         |   |       |   |   |       |
 *         |   |       |   |   |   |   |
 *         |   |   |   |   |   |   |   |
 *     |   |   |   |   |   |   |   |   |
 *     ----------------------------------
 *     1   8   6   2   5   4   8   3   7
 *     1   2   3   4   5   6   7   8   9
 * */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE, length = height.length;
        int area = 0;

        for(int i=0; i<length; i++) {
            for (int j=i+1; j<length; j++) {
                area = (j-i) * Math.min(height[i], height[j]);
                if (area > maxArea)
                    maxArea=area;
            }
        }
        return maxArea;
    }

    /**
     * One Pass
     * */
    public int maxArea2(int[] height) {
        int maxArea = Integer.MIN_VALUE, currentArea=maxArea;
        int length=height.length;

        for (int i=0, j=length-1; i<j; ) {
            currentArea = (j-i) * Math.min(height[i], height[j]);
            maxArea = Math.max(currentArea, maxArea);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    public static void main (String... args){
        ContainerWithMostWater container = new ContainerWithMostWater();
        int[] height1 = {1,8,6,2,5,4,8,3,7};


        System.out.println("Expected: 49 | Output: " + container.maxArea(height1));
        System.out.println("Expected: 49 | Output: " + container.maxArea2(height1));

    }
}
