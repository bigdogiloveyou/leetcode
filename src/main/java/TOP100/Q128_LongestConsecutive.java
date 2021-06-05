package TOP100;

import java.util.Arrays;

/**
 * @author xushu
 * @create 5/28/21 10:39 PM
 * @desc
 */
public class Q128_LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);
        int maxLength = 0, len = 1;
        for (int i = 1; i < nums.length; i++) {
            maxLength = Math.max(maxLength, len);

            if(nums[i] - nums[i - 1] == 1){
                len++;
            }else if(nums[i] - nums[i - 1] == 0){
                continue;
            }else {
                len = 1;
            }
        }

        return Math.max(maxLength, len);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1000, 0, 300, 2};
        System.out.println(new Q128_LongestConsecutive().longestConsecutive(nums));
    }
}
