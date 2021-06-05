package TOP100;



import java.util.ArrayList;
import java.util.List;

/**
 * @author xushu
 * @create 5/25/21 4:28 PM
 * @desc
 */
public class Q94_InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode root, List<Integer> list){
        if(root != null){
            dfs(root.left, list);
            list.add(root.val);
            dfs(root.right, list);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
