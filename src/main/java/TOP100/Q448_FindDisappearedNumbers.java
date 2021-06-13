package TOP100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xushu
 * @create 6/6/21 1:59 PM
 * @desc
 */
public class Q448_FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        int[] res = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            int index = nums[i];
            res[index]++;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < res.length; i++) {
            if(res[i] == 0){
                list.add(res[i]);
            }
        }

        return list;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - 1) % nums.length;
            nums[index] = nums[index] + nums.length;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= nums.length){
                list.add(i + 1);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        new Q448_FindDisappearedNumbers().findDisappearedNumbers2(new int[]{4,3,2,7,8,2,3,1});
    }
}
