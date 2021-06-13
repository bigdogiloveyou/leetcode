package TOP100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xushu
 * @create 6/6/21 1:45 PM
 * @desc
 */
public class Q297_Codec {

    private String codeStr;

    private int inOrderIndex = 0;

    /**
     * 使用前序 + 中序遍历的形式构造二叉树，所以 string 应该为前序数组 # 中序数组
     * @param root
     * @return
     */
    public String serialize2(TreeNode root) {
        codeStr = "";
        inOrder(root);
        codeStr += "#";
        midOrder(root);
        return codeStr;
    }

    private void inOrder(TreeNode root) {
        if(root == null){
            return;
        }
        codeStr += root.val + ",";
        inOrder(root.left);
        inOrder(root.right);
    }

    private void midOrder(TreeNode root) {
        if(root == null){
            return;
        }

        midOrder(root.left);
        codeStr += root.val + ",";
        midOrder(root.right);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        String[] str = data.split("#");
        String[] inOrder = str[0].split(",");
        String[] midOrder = str[1].split(",");

        int[] in = new int[inOrder.length];
        for (int i = 0; i < inOrder.length; i++) {
            in[i] = Integer.parseInt(inOrder[i]);
        }
        int[] mid = new int[midOrder.length];
        for (int i = 0; i < midOrder.length; i++) {
            mid[i] = Integer.parseInt(midOrder[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mid.length; i++) {
            map.put(mid[i], i);
        }

        return dfs(in, mid, 0, midOrder.length - 1, map);
    }

    private TreeNode dfs(int[] inOrder, int[] midOrder, int left, int right, Map<Integer, Integer> map) {
        if(inOrderIndex == inOrder.length){
            return null;
        }

        if(left > right){
            return null;
        }

        int rootValue = inOrder[inOrderIndex];
        TreeNode root = new TreeNode(rootValue);
        inOrderIndex++;
        root.left = dfs(inOrder, midOrder, left, map.get(rootValue) - 1, map);
        root.right = dfs(inOrder, midOrder, map.get(rootValue) + 1, right, map);

        return root;
    }


    public String serialize(TreeNode root) {
        if(root == null){
            return "#";
        }

        String left = serialize(root.left);
        String right = serialize(root.right);

        return root.val + "," + left + "," + right;
    }

    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0){
            return null;
        }
        String[] str = data.split(",");
        List<String> list = new ArrayList<>();
        for (String s : str) {
            list.add(s);
        }

        return buildTree(list);
    }

    private TreeNode buildTree(List<String> list) {
        if(list.isEmpty()){
            return null;
        }
        String rootVal = list.remove(0);
        if(rootVal.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        root.left = buildTree(list);
        root.right = buildTree(list);

        return root;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        Q297_Codec code = new Q297_Codec();

        String str = code.serialize(node1);

        TreeNode root2 = code.deserialize(str);
        System.out.println(str);
    }
}
