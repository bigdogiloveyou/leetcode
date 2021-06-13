package TOP100;

import java.util.Arrays;

/**
 * @author xushu
 * @create 6/5/21 1:43 PM
 * @desc
 */
public class Q215_FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k > nums.length){
            return -1;
        }

        Arrays.sort(nums);

        return nums[nums.length - k];
    }
}
