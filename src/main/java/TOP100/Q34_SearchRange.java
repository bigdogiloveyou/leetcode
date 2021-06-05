package TOP100;

/**
 * @author xushu
 * @create 5/21/21 11:59 PM
 * @desc
 */
public class Q34_SearchRange {

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }

        int mid = binarySearch(nums, target);
        if(mid == -1){
            return new int[]{-1, -1};
        }

        int left = mid, right = mid;
        while((left - 1 >= 0 && nums[left - 1] == nums[left]) || (right + 1 <= nums.length - 1 && nums[right] == nums[right + 1])){
            if(left - 1 >= 0 && nums[left - 1] == nums[left]){
                left--;
            }
            if(right + 1 <= nums.length && nums[right] == nums[right + 1]){
                right++;
            }
        }

        return new int[]{left, right};
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right){
            int mid = (right - left) / 2 + left;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        int[] res = new Q34_SearchRange().searchRange(nums, target);
        System.out.println(res[0] + ":" + res[1]);
    }
}
