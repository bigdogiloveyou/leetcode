package TOP100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xushu
 * @create 5/28/21 10:37 PM
 * @desc
 */
public class Q105_BuildTree {

    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0){
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            map.put(preorder[i], i);
        }

        return dfs(preorder, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int left, int right, Map<Integer, Integer> map) {
        if(preIndex == preorder.length){
            return null;
        }

        if(left > right){
            return null;
        }

        int rootValue = preorder[preIndex];
        TreeNode root = new TreeNode(rootValue);
        preIndex++;

        root.left = dfs(preorder, inorder, left, map.get(rootValue) - 1, map);
        root.right = dfs(preorder, inorder,map.get(rootValue) + 1, right, map);

        return root;
    }
}
