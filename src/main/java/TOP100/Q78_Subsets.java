package TOP100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xushu
 * @create 5/25/21 4:25 PM
 * @desc
 */
public class Q78_Subsets {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return res;
        }

        dfs(nums, 0, new ArrayList<>());

        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> list){
        res.add(new ArrayList<>(list));

        for(int i = index; i < nums.length; i++){
            list.add(nums[i]);
            dfs(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
