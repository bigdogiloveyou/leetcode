package TOP100;

/**
 * @author xushu
 * @create 6/6/21 1:41 PM
 * @desc
 */
public class Q238_ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }

        int p = 1, q = 1;
        int[] res = new int[nums.length];

        // 上三角的遍历
        for (int i = 0; i < nums.length; i++) {
            res[i] = p;
            p = p * nums[i];
        }

        for(int i = nums.length - 1; i >= 0; i--){
            res[i] = res[i] * q;
            q = q * nums[i];
        }


        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] res = new Q238_ProductExceptSelf().productExceptSelf(nums);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
