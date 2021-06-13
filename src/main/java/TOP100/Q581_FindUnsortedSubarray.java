package TOP100;

import java.util.Arrays;

/**
 * @author xushu
 * @create 6/6/21 2:08 PM
 * @desc
 */
public class Q581_FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] arrays = nums.clone();
        Arrays.sort(arrays);

        int start = nums.length, end = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != arrays[i]){
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }

        return end - start >= 0 ? end - start + 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(new Q581_FindUnsortedSubarray().findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
    }
}
