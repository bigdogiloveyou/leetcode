package TOP100;



/**
 * @author xushu
 * @create 5/22/21 7:51 PM
 * @desc
 */
public class Q72_MinDistance {

    public int minDistance(String word1, String word2) {
        return dp(word1, word1.length() - 1, word2, word2.length() - 1);
    }


    private int dp(String S1, int i, String S2, int j){
        if(i == -1){
            return j + 1;
        }
        if(j == -1){
            return i + 1;
        }

        if(S1.charAt(i) == S2.charAt(j)){
            return dp(S1, i - 1, S2, j - 1); // 啥也不做
        }else {
            return min(
                    dp(S1, i, S2, j - 1) + 1, // 插入
                    dp(S1, i - 1, S2, j) + 1, // 删除
                    dp(S1, i - 1, S2, j - 1) + 1 // 替换
            );
        }

    }

    private int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }




    public static void main(String[] args) {
        System.out.println(new Q72_MinDistance().minDistance("red", "apple"));
    }
}
