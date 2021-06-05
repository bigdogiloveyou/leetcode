package TOP100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xushu
 * @create 5/20/21 10:39 AM
 * @desc
 */
public class Q17_LetterCombinations {

    private List<String> res = new ArrayList<>();

    private Map<Integer, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }

        initMap();

        dfs(digits, "", 0);

        return res;
    }

    private void dfs(String digits, String str, int start) {
        if(start == digits.length()){
            res.add(str);
            return;
        }

        String dict = map.get(digits.charAt(start) - '0');
        for (int i = 0; i < dict.length(); i++) {
            dfs(digits, str + dict.charAt(i), start + 1);
        }
    }

    private void initMap() {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

//    class Solution {
//        public List<String> letterCombinations(String digits) {
//            if(digits==null || digits.length()==0) {
//                return new ArrayList<String>();
//            }
//            //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
//            //这里也可以用map，用数组可以更节省点内存
//            String[] letter_map = {
//                    " ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
//            };
//            List<String> res = new ArrayList<>();
//            //先往队列中加入一个空字符
//            res.add("");
//            for(int i=0;i<digits.length();i++) {
//                //由当前遍历到的字符，取字典表中查找对应的字符串
//                String letters = letter_map[digits.charAt(i)-'0'];
//                int size = res.size();
//                //计算出队列长度后，将队列中的每个元素挨个拿出来
//                for(int j=0;j<size;j++) {
//                    //每次都从队列中拿出第一个元素
//                    String tmp = res.remove(0);
//                    //然后跟"def"这样的字符串拼接，并再次放到队列中
//                    for(int k=0;k<letters.length();k++) {
//                        res.add(tmp+letters.charAt(k));
//                    }
//                }
//            }
//            return res;
//        }
//    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> res = new Q17_LetterCombinations().letterCombinations(digits);
        for (String re : res) {
            System.out.println(re);
        }
    }
}
