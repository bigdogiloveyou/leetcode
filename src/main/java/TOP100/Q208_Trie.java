package TOP100;

import com.example.demo.xushu.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xushu
 * @create 6/5/21 1:43 PM
 * @desc
 */
public class Q208_Trie {

    class TreeNode{
        char value;
        List<TreeNode> children;
        boolean end;

        public TreeNode() {
        }

        public TreeNode(char value, List<TreeNode> children, boolean end) {
            this.value = value;
            this.children = children;
            this.end = end;
        }
    }

    private TreeNode root;

    /** Initialize your data structure here. */
    public Q208_Trie() {
        this.root = new TreeNode('#', new ArrayList<>(), false);
    }

    /** 只找寻这一层是否有字母 c **/
    private TreeNode findNode(TreeNode node, char c) {
        if(node == null){
            return null;
        }
        for (TreeNode child : node.children) {
            if(child.value == c){
                return child;
            }
        }

        return null;
    }

    /**
     * 这种查找思路本质上还是使用的 bfs，即一层层遍历比较，为什么不是针对每个字母都是从第一层开始遍历，
     * 因为 trie 树中一个单词是连续的，都是先从第一层，然后到第二层......
     * 这样依次寻找。而如果每次都是从第一层开始寻找，那么便不能保证 trie 树的连续性。
     * 所以借用了 bfs 的思路，接力寻找。
     * @param word
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        TreeNode currentNode = this.root;
        for (char c : word.toCharArray()) {
            TreeNode node = findNode(currentNode, c);
            if(node == null){
                node = new TreeNode(c, new ArrayList<>(), false);
                currentNode.children.add(node);
            }
            currentNode = node;
        }
        currentNode.end = true;
    }


    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || word.length() == 0){
            return false;
        }

        TreeNode currentNode = this.root;
        for (char c : word.toCharArray()) {
            TreeNode node = findNode(currentNode, c);
            if(node == null){
                return false;
            }
            currentNode = node;
        }
        return currentNode.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0){
            return false;
        }

        TreeNode currentNode = this.root;
        for (char c : prefix.toCharArray()) {
            TreeNode node = findNode(currentNode, c);
            if(node == null){
                return false;
            }
            currentNode = node;
        }
        return true;
    }

    public static void main(String[] args) {
        Q208_Trie trie = new Q208_Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
