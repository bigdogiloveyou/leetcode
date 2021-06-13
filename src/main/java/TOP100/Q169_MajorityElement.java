package TOP100;

/**
 * @author xushu
 * @create 6/5/21 1:40 PM
 * @desc
 */
public class Q169_MajorityElement {

    public int majorityElement(int[] nums) {
        int num = nums[0], frequency = 1;
        for (int i = 1; i < nums.length; i++) {
            if(frequency == 0){
                num = nums[i];
                frequency = 1;
                continue;
            }
            if(num == nums[i]){
                frequency++;
            }else {
                frequency--;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(new Q169_MajorityElement().majorityElement(nums));
    }
}
