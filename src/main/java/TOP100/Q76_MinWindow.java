package TOP100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xushu
 * @create 5/25/21 4:16 PM
 * @desc
 */
public class Q76_MinWindow {

    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, length = Integer.MAX_VALUE, valid = 0, leftStr = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;

            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while (valid == need.size()){
                if(right - left < length){
                    length = right - left;
                    leftStr = left;
                }

                char c1 = s.charAt(left);
                left++;
                if(need.containsKey(c1)){
                    // 什么条件下，valid 会减少？进入此 if 条件意味着要将字符的频次减1，所以是字符在 window 与 need 的频次
                    // 减少时会减。如果记不住，那就记住减少是加的逆过程即可。
                    if(window.get(c1).equals(need.get(c1))){
                        valid--;
                    }
                    window.put(c1, window.getOrDefault(c1, 0) - 1);
                }
            }
        }

        return length ==Integer.MAX_VALUE ? "" :  s.substring(leftStr, leftStr + length);
    }

    public static void main(String[] args) {
        String s = "A", t = "AA";
        System.out.println(new Q76_MinWindow().minWindow(s, t));
    }
}
