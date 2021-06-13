package TOP100;

/**
 * @author xushu
 * @create 6/6/21 1:44 PM
 * @desc
 */
public class Q283_MoveZeroes {

    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }

        int less = -1, L = 0;
        while(L < nums.length){
            if(nums[L] < 0 || nums[L] > 0){
                swap(nums, L++, ++less);
            }else {
                L++;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new Q283_MoveZeroes().moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
