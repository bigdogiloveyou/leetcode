package TOP100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xushu
 * @create 5/28/21 10:40 PM
 * @desc
 */
public class Q139_WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return canBreak(0, s, set, memo);
    }

    private boolean canBreak(int start, String s, Set<String> set, Boolean[] memo) {
        if(start == s.length()){
            return true;
        }

        if(memo[start] != null){
            return memo[start];
        }

        for(int i = start + 1; i <= s.length(); i++){
            String prefix = s.substring(start, i);
            if(set.contains(prefix) && canBreak(i, s, set, memo)){
                memo[start] = true;
                return true;
            }
        }

        memo[start] = false;
        return false;
    }


    public static void main(String[] args) {
        String s = "aaaaab";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("aa");
        wordDict.add("ab");
        System.out.println(new Q139_WordBreak().wordBreak(s, wordDict));
    }
}
