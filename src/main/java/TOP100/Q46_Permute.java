package TOP100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author xushu
 * @create 5/22/21 12:00 AM
 * @desc
 */
public class Q46_Permute {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return res;
        }

        boolean[] used = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), used);

        return res;
    }

    private void dfs(int[] nums, List<Integer> list, boolean[] used){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
