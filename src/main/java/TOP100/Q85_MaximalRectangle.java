package TOP100;

/**
 * @author xushu
 * @create 5/25/21 4:27 PM
 * @desc
 */
public class Q85_MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    heights[j] += 1;
                }else {
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights){
        if(heights == null || heights.length == 0){
            return 0;
        }

        int m = heights.length;
        int[] leftMemo = new int[m];
        leftMemo[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            int left = i - 1;
            while(left >= 0 && heights[left] >= heights[i]){
                left = leftMemo[left];
            }

            leftMemo[i] = left;
        }

        int[] rightMemo = new int[m];
        rightMemo[m - 1] = m;
        for (int i = m - 2; i >= 0; i--) {
            int right = i + 1;
            while(right < m && heights[right] >= heights[i]){
                right = rightMemo[right];
            }
            rightMemo[i] = right;
        }

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, (rightMemo[i] - leftMemo[i] - 1) * heights[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(new Q85_MaximalRectangle().maximalRectangle(matrix));
    }
}
