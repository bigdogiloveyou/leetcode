package TOP100;

/**
 * @author xushu
 * @create 5/28/21 10:38 PM
 * @desc
 */
public class Q124_MaxPathSum {

    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        oneSideMax(root);

        return res;
    }

    private int oneSideMax(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftValue = oneSideMax(root.left);
        int rightValue = oneSideMax(root.right);

        leftValue = leftValue < 0 ? 0 : leftValue;
        rightValue = rightValue < 0 ? 0 : rightValue;

        res = Math.max(res, root.val + leftValue + rightValue);

        return Math.max(leftValue, rightValue) + root.val;
    }


}
