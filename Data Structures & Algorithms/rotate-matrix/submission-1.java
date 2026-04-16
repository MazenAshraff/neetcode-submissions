class Solution {
    public void rotate(int[][] matrix) {
        int lastIndex = matrix.length - 1;
        for(int i = 0;i<matrix.length/2;i++){
            for(int j = i; j<matrix.length-i-1;j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[lastIndex - j][i];
            matrix[lastIndex - j][i] = matrix[lastIndex - i][lastIndex - j];
            matrix[lastIndex - i][lastIndex - j] = matrix[j][lastIndex - i];
            matrix[j][lastIndex - i] = temp;
        }
    }
    }
}
