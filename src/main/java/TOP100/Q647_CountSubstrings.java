package TOP100;

/**
 * @author xushu
 * @create 6/6/21 2:10 PM
 * @desc
 */
public class Q647_CountSubstrings {

    public int countSubstrings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += paran(s, i, i);
            count += paran(s, i, i + 1);
        }

        return count;
    }

    private int paran(String s, int left, int right) {
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }

        return count;
    }
}
