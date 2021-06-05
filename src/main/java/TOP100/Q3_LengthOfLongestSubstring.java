package TOP100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xushu
 * @create 5/17/21 9:43 PM
 * @desc
 */
public class Q3_LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0, length = 0;
        while(right < s.length()){
            char c1 = s.charAt(right);
            right++;
            window.put(c1, window.getOrDefault(c1, 0) + 1);

            while (window.get(c1) > 1){
                char c2 = s.charAt(left);
                left++;
                window.put(c2, window.getOrDefault(c2, 0) - 1);
            }

            length = Math.max(length, right - left);
        }

        return length;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(new Q3_LengthOfLongestSubstring().lengthOfLongestSubstring(s));
    }
}
