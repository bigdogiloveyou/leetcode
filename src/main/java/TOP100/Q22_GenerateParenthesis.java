package TOP100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xushu
 * @create 5/21/21 11:05 AM
 * @desc
 */
public class Q22_GenerateParenthesis {

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String s) {
        if(left == 0 && right == 0){
            res.add(s);
            return;
        }

        if(left > right){
            return;
        }

        if(left > 0){
            dfs(left - 1, right, s + "(");
        }

        if(right > 0){
            dfs(left, right - 1, s + ")");
        }
    }

    public static void main(String[] args) {
        List<String> res = new Q22_GenerateParenthesis().generateParenthesis(3);
        for (String re : res) {
            System.out.println(re);
        }
    }
}
