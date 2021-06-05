package TOP100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xushu
 * @create 5/28/21 10:37 PM
 * @desc
 */
public class Q114_Flatten {


    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while(p.right != null){
            p = p.right;
        }
        p.right = right;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(1);
    }
}
