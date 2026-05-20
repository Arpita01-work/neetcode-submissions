class Solution {
    public boolean isValidSudoku(char[][] board) {
       int[] row = new int[9];
       int[] col = new int[9];
       int[] box = new int[9];

       for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j] == '.') continue;

                int val = board[i][j] - '1';

                if((row[i] & (1 << val)) > 0 || 
                   (col[j] & (1 << val)) > 0 || 
                   (box[(i / 3) * 3 + (j / 3)] & (1 << val)) > 0)
                {
                    return false;
                } 

                row[i] |= (1 << val);
                col[j] |= (1 << val);
                box[(i / 3) * 3 + (j / 3)] |= (1 << val);
            }
       }
       return true;
    }
}
