package TOP100;

/**
 * @author xushu
 * @create 5/18/21 10:41 PM
 * @desc
 */
public class Q5_LongestPalindrome {

    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String left = getPalindrom(s, i, i);
            String right = getPalindrom(s, i, i + 1);

            max = max.length() > left.length() ? max : left;
            max = max.length() > right.length() ? max : right;
        }

        return max;
    }

    private String getPalindrom(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }

        return s.substring(i + 1, j);
    }

    public static void main(String[] args) {
        String s = "ac";
        System.out.println(new Q5_LongestPalindrome().longestPalindrome(s));
    }
}
