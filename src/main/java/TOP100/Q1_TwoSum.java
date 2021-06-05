package TOP100;

import java.util.Arrays;

/**
 * @author xushu
 * @create 5/17/21 10:56 AM
 * @desc
 */
public class Q1_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] array = Arrays.copyOf(nums, nums.length);
        Arrays.sort(array);

        int left = 0, right = array.length - 1;
        while(left < right){
            int sum = array[left] + array[right];

            if(sum < target){
                left++;
            }else if(sum > target){
                right--;
            }else {
                break;
            }
        }

        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(array[left] == nums[i]){
                res[0] = i;
                break;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(array[right] == nums[i] && i != res[0]){
                res[1] = i;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 5, 11};
        int target = 10;
        for (int i : new Q1_TwoSum().twoSum(nums, target)) {
            System.out.println(i);
        }
    }
}