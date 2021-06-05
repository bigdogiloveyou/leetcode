package TOP100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xushu
 * @create 5/28/21 10:40 PM
 * @desc
 */
public class Q136_SingleNumber {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int num = 0;
        for (Integer key : map.keySet()) {
            if(map.get(key) == 1){
                num = key;
                break;
            }
        }

        return num;
    }

    public int singleNumber2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res ^= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(new Q136_SingleNumber().singleNumber(nums));

        System.out.println(1 ^ 0);
    }
}
