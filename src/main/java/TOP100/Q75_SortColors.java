package TOP100;

/**
 * @author xushu
 * @create 5/22/21 7:51 PM
 * @desc
 */
public class Q75_SortColors {

    public void sortColors(int[] nums) {
        int L = 0, R = nums.length - 1;
        if(L >= R){
            return;
        }

        int index = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == 1){
                index = i;
                break;
            }
        }
        swap(nums, index, nums.length - 1);

        partition(nums, L, R);
    }

    private void partition(int[] nums, int L, int R) {
        int less = L - 1, more = R, sentinel = nums[R];
        while(L < more){
            if(nums[L] < sentinel){
                swap(nums, L++, ++less);
            }else if(nums[L] > sentinel){
                swap(nums, L, --more);
            }else {
                L++;
            }
        }
        swap(nums, L, R);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        new Q75_SortColors().sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
