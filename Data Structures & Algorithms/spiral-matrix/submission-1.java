class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int size = n * m;
        int endRight = m;
        int endBottom = n;
        int endLeft = -1;
        int endTop = 0;
        int i = 0, j = 0;
        while (ans.size() < size) {
            while (j < endRight) {
                ans.add(matrix[i][j]);
                j++;
            }
            endRight--;
            i++;
            j--;
            while (i < endBottom && ans.size() < size) {
                ans.add(matrix[i++][j]);
            }
            endBottom--;
            i--;
            j--;
            while (j > endLeft && ans.size() < size) {
                ans.add(matrix[i][j--]);
            }
            i--;
            j++;
            endLeft++;
            while (i > endTop && ans.size() < size) {
                ans.add(matrix[i--][j]);
            }
            i++;
            j++;
            endTop++;
        }
        return ans;
    }
}
