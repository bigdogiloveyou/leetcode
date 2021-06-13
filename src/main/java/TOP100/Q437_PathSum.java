package TOP100;

/**
 * @author xushu
 * @create 6/6/21 1:58 PM
 * @desc
 */
public class Q437_PathSum {

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }


        return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int dfs(TreeNode root, int target) {
        if(root == null){
            return 0;
        }
        if(target < 0){
            return 0;
        }
        target -= root.val;

        return (target == 0 ? 1 : 0) + dfs(root.left, target) + dfs(root.right, target);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(-3);
        node1.left = node2;node1.right = node3;

        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(11);
        node2.left = node4;node2.right = node5;
        node3.right = node6;

        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(-2);
        TreeNode node9 = new TreeNode(1);
        node4.left = node7; node4.right = node8;
        node5.right = node9;

        System.out.println(new Q437_PathSum().pathSum(node1, 8));
    }
}
