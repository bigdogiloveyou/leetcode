package TOP100;

/**
 * @author xushu
 * @create 5/22/21 7:47 PM
 * @desc
 */
public class Q53_MaxSubArray {

    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(max, sum);
            if(sum < 0){
                sum = 0;
            }
        }


        return max;
    }


}
