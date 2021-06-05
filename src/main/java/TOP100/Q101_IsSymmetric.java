package TOP100;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xushu
 * @create 5/25/21 4:30 PM
 * @desc
 */
public class Q101_IsSymmetric {

    public boolean isSymmetric2(TreeNode root) {
        if(root == null){
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode leftNode = queue.poll();
                TreeNode rightNode = queue.poll();

                if(leftNode == null && rightNode == null){
                    continue;
                }

                if(leftNode == null || rightNode == null){
                    return false;
                }

                if(leftNode.val != rightNode.val){
                    return false;
                }

                queue.add(leftNode.right);
                queue.add(rightNode.left);
                queue.add(leftNode.left);
                queue.add(rightNode.right);
            }
        }

        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }

        if(left == null || right == null){
            return false;
        }

        if(left.val != right.val){
            return false;
        }

        return dfs(left.right, right.left) && dfs(left.left, right.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(3);

        t1.left = t2;t1.right = t3;

        t2.left = t4;t2.right = t5;

        t3.left = t6;t3.right = t7;

        System.out.println(new Q101_IsSymmetric().isSymmetric(t1));
    }
}
