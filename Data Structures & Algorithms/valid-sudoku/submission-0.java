class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for(int i=0; i<n; i++){
            Set<Character> rowSet = new HashSet<>();
            for(int j=0; j<n; j++){
                char num = board[i][j];
                if(num == '.') continue;

                if(rowSet.contains(num)){
                    return false;
                }
                rowSet.add(board[i][j]);
            }
        }
        
        for(int j=0; j<n; j++){
            Set<Character> columnSet = new HashSet<>();
            for(int i=0; i<n; i++){
                char num = board[i][j];
                if(num == '.') continue;

                if(columnSet.contains(num)){
                    return false;
                }
                columnSet.add(num);
            }
        }

        for(int row=0; row<n; row+=3){
            for(int col=0; col<n; col+=3){
                Set<Character> boxSet = new HashSet<>();
                for(int i=row; i<row+3; i++){
                    for(int j=col; j<col+3; j++){
                        char num = board[i][j];
                        if(num == '.') continue;

                        if(boxSet.contains(num)){
                            return false;
                        }
                        boxSet.add(num);
                    }
                }
            }
        }
        return true;
    }
}
