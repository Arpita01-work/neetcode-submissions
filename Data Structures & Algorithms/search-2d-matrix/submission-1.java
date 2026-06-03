class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0; i<rows; i++){
            if(target >= matrix[i][0] && target <= matrix[i][cols - 1]){
                int left = 0;
                int right = cols - 1;
                while(left <= right){
                    int mid = left + (right - left) /2;

                    if(target == matrix[i][mid]){
                        return true;
                    }else if(target > matrix[i][mid]){
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
