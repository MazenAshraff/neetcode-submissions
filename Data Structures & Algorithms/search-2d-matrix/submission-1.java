class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        if(row == -1) return false;
        return findColumn(matrix, target, row) != -1;
    }

    private int findRow(int [][] matrix, int target){
        int low = 0;
        int high = matrix.length - 1;
        int ans = -1;
        while(low<= high){
            int mid = low + (high - low)/2;
            if(matrix[mid][matrix[0].length - 1] >= target){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    private int findColumn(int [][] matrix, int target, int row){
        int low = 0;
        int high = matrix[0].length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(matrix[row][mid] > target){
                high = mid -1;
            }
            else{
                if(matrix[row][mid] < target){
                    low = mid + 1;
                }
                else{
                    return mid;
                }
            }
        }

        return -1;
    }
}
