package TOP100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xushu
 * @create 5/19/21 10:58 PM
 * @desc
 */
public class Q15_ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return threeSumTarget(nums, 0);
    }

    private List<List<Integer>> threeSumTarget(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < n; i++){
            List<Integer> list = twoSumTarget(nums, target - nums[i]);
            if(list.size() > 0){
                list.add(nums[i]);
                res.add(list);
            }

            while(i < n - 1 && nums[i] == nums[i + 1]){
                i++;
            }
        }

        return res;
    }

    private List<Integer> twoSumTarget(int[] nums, int target){
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int left = 0, right = n - 1;

        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum < target){
                left++;
            }else if(sum > target){
                right--;
            }else{
                list.add(nums[left]);
                list.add(nums[right]);
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
