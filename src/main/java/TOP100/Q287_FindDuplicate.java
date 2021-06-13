package TOP100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xushu
 * @create 6/6/21 1:44 PM
 * @desc
 */
public class Q287_FindDuplicate {

    public int findDuplicate2(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) > 1){
                return nums[i];
            }
        }
        return -1;
    }

    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;

            int count = 0;
            for(int i = 0; i <= mid; i++){
                if(nums[i] <= nums[mid]){
                    count++;
                }
            }

            if(count > mid){
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(new Q287_FindDuplicate().findDuplicate(nums));
    }
}
