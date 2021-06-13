package TOP100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xushu
 * @create 6/6/21 1:59 PM
 * @desc
 */
public class Q438_FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0 || p == null || p.length() == 0){
            return new ArrayList<>();
        }

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, valid = 0;
        List<Integer> list = new ArrayList<>();
        while (right < s.length()){
            char c = s.charAt(right);
            right++;

            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while(right - left >= p.length()){
                if(valid == need.size()){
                    list.add(left);
                }
                char c1 = s.charAt(left);
                left++;

                if(need.containsKey(c1)){
                    if(window.get(c1).equals(need.get(c1))){
                        valid--;
                    }
                    window.put(c1, window.get(c1) - 1);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        String s = "abaacbabc", p = "abc";
        List<Integer> res = new Q438_FindAnagrams().findAnagrams(s, p);
        for (Integer re : res) {
            System.out.println(re);
        }
    }
}
