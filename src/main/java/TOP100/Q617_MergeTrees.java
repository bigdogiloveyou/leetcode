package TOP100;

/**
 * @author xushu
 * @create 6/6/21 2:09 PM
 * @desc
 */
public class Q617_MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }
        if(root1 == null || root2 == null){
            return root1 == null ? root2 : root1;
        }

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }

    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }

        TreeNode node = new TreeNode(0);
        if(root1 != null && root2 == null){
            node.val = root1.val;
            node.left = mergeTrees(root1.left, null);
            node.right = mergeTrees(root1.right, null);
        }else if(root1 != null && root2 != null){
            node.val = root1.val + root2.val;
            node.left = mergeTrees(root1.left, root2.left);
            node.right = mergeTrees(root1.right, root2.right);
        }else if(root1 == null && root2 != null){
            node.val = root2.val;
            node.left = mergeTrees(null, root2.left);
            node.right = mergeTrees(null, root2.right);
        }

        return node;
    }
}
