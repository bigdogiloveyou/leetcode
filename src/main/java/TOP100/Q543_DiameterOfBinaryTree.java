package TOP100;

/**
 * @author xushu
 * @create 6/6/21 2:07 PM
 * @desc
 */
public class Q543_DiameterOfBinaryTree {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);

        return max;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}
