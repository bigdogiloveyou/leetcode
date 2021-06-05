package TOP100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xushu
 * @create 5/21/21 11:59 PM
 * @desc
 */
public class Q39_CombinationSum {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return res;
        }

        dfs(candidates, target, 0, new ArrayList<>());

        return res;
    }

    private void dfs(int[] candidates, int target, int index, List<Integer> list){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < candidates.length; i++){
            if(target - candidates[i] < 0){
                continue;
            }
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }
    }
}
