package TOP100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xushu
 * @create 6/6/21 1:54 PM
 * @desc
 */
public class Q337_Rob {

    public int rob(TreeNode root) {
        return dfs(root, new HashMap<TreeNode, Integer>());
    }

    private int dfs(TreeNode root, Map<TreeNode, Integer> memo) {
        if(root == null){
            return 0;
        }

        if(memo.containsKey(root)){
            memo.get(root);
        }

        int rob = root.val + (root.left != null ? dfs(root.left.left, memo) + dfs(root.left.right, memo) : 0) + (root.right != null ? dfs(root.right.left, memo) + dfs(root.right.right, memo) : 0);
        int notRob = dfs(root.left, memo) + dfs(root.right, memo);

        int value = Math.max(rob, notRob);
        memo.put(root, value);

        return value;
    }
}
