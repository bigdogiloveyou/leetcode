package TOP100;

/**
 * @author xushu
 * @create 6/6/21 1:55 PM
 * @desc
 */
public class Q338_CountBits {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for(int i = 0; i <= n; i++){
            res[i] = Integer.bitCount(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] res = new Q338_CountBits().countBits(5);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
