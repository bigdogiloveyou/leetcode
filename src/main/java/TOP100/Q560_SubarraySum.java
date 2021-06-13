package TOP100;

/**
 * @author xushu
 * @create 6/6/21 2:07 PM
 * @desc
 */
public class Q560_SubarraySum {

    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] prefix = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++){
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        int count = 0;
        for(int i = 1; i < prefix.length; i++){
            for(int j = 0; j < i; j++){
                if(prefix[i] - prefix[j] == k){
                    count++;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(new Q560_SubarraySum().subarraySum(new int[] {1,1,1}, 2));
    }
}
