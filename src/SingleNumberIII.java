import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.
 * <p>
 * You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
 * <p>
 *
 *
 * Example 1:
 * <p>
 * Input: nums = [1,2,1,3,2,5]
 * Output: [3,5]
 * Explanation:  [5, 3] is also a valid answer.
 * Example 2:
 * <p>
 * Input: nums = [-1,0]
 * Output: [-1,0]
 * Example 3:
 * <p>
 * Input: nums = [0,1]
 * Output: [1,0]
 * <p>
 *
 * Constraints:
 * <p>
 * 2 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * Each integer in nums will appear twice, only two integers will appear once.
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        // XOR all numbers to find the XOR of the two single numbers
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }

        // Find the rightmost set bit in the XOR result
        int rightmostSetBit = 1;
        while ((rightmostSetBit & xorResult) == 0) {
            rightmostSetBit <<= 1;
        }

        // Use the rightmost set bit to partition the array into two groups
        int group1 = 0, group2 = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) == 0) {
                group1 ^= num;
            } else {
                group2 ^= num;
            }
        }

        return new int[]{group1, group2};
    }

    public static void main(String[] args) {
        int[] a = {1,2,1,3,2,5};
        var num = new SingleNumberIII().singleNumber(a);
        System.out.println(Arrays.toString(num));
    }

}
