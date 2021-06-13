package TOP100;

/**
 * @author xushu
 * @create 6/6/21 1:42 PM
 * @desc
 */
public class Q240_SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int m = matrix.length, n = matrix[0].length;

        int left = 0, right = n - 1, mid = 0;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(matrix[0][mid] == target){
                return true;
            }else if(matrix[0][mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        mid = left - 1;

        for(int i = mid; i >= 0; i--){
            mid = 0;
            left = 0;
            right = m - 1;
            while (left <= right){
                mid = left + (right - left) / 2;
                if(matrix[mid][i] == target){
                    return true;
                }else if(matrix[mid][i] > target){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }

        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int row = 0, column = matrix[0].length - 1;
        while(row < matrix.length && column >= 0){
            if(matrix[row][column] == target){
                return true;
            }else if(matrix[row][column] > target){
                column--;
            }else if(matrix[row][column] < target){
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(new Q240_SearchMatrix().searchMatrix2(matrix, 5));
    }
}
