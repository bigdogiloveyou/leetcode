package TOP100;


/**
 * @author xushu
 * @create 5/25/21 4:32 PM
 * @desc
 */
public class Q104_MaxDepth {

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
