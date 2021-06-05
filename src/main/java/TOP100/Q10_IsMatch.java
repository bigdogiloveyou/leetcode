package TOP100;

/**
 * @author xushu
 * @create 5/19/21 3:02 PM
 * @desc
 */
public class Q10_IsMatch {

    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }

        return dp(s, 0, p, 0);
    }

    private boolean dp(String s, int i, String p, int j){
        if(j == p.length()){
            return i == s.length();
        }

        boolean firstMath = i < s.length() && j < p.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
        boolean ans = false;
        if(j <= p.length() - 2 && p.charAt(j + 1) == '*'){
            ans =  dp(s, i, p, j + 2) || (firstMath && dp(s, i + 1, p, j));
        }else{
            ans =  firstMath && dp(s, i + 1, p, j + 1);
        }

        return ans;
    }


    public static void main(String[] args) {
        String s = "a", p = "aa";

        System.out.println(new Q10_IsMatch().isMatch(s, p));
    }
}
