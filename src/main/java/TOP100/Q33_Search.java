package TOP100;

/**
 * @author xushu
 * @create 5/21/21 11:58 PM
 * @desc
 */
public class Q33_Search {

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;

            if(nums[mid] == target){
                return mid;
            }

            // mid 落在左边，但只有 [left, mid] 能确定，其他情况要继续判断
            if(nums[mid] >= nums[left]){
                if(nums[left] <= target && target <= nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else if(nums[mid] < nums[left]){ // mid 落在右边，但只有 [mid, right] 能去定，其他情况要继续判断
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
