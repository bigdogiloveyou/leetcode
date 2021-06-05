package TOP100;

/**
 * @author xushu
 * @create 5/17/21 10:52 PM
 * @desc
 */
public class Q4_FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int length = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for(int i = 0; i <= length / 2; i++){
            left = right;
            if(aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])){
                right = nums1[aStart];
                aStart++;
            }else if(bStart < n && (aStart >= m || nums1[aStart] >= nums2[bStart])){
                right = nums2[bStart];
                bStart++;
            }
        }

        if(length % 2 == 0){
            return (left + right) / 2.0;
        }

        return right;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2}, num2 = {1, 2};
        System.out.println(new Q4_FindMedianSortedArrays().findMedianSortedArrays(num1, num2));
    }
}
