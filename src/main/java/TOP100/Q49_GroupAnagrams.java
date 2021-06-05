package TOP100;

import java.util.*;

/**
 * @author xushu
 * @create 5/22/21 12:01 AM
 * @desc
 */
public class Q49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }


        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(strs[i]);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = new Q49_GroupAnagrams().groupAnagrams(strs);
        for (List<String> re : res) {
            for (String s : re) {
                System.out.print(s + " : ");
            }
            System.out.println();
        }
    }
}
