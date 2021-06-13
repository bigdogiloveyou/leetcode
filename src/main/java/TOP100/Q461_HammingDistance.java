package TOP100;

/**
 * @author xushu
 * @create 6/6/21 2:00 PM
 * @desc
 */
public class Q461_HammingDistance {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        System.out.println(Integer.bitCount(1 ^ 3));
    }
}
