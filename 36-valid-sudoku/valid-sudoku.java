import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                
                // Skip empty cells
                if (number != '.') {
                    // Try to add the digit with its row, column, and block markers
                    // If add() returns false, it means the string is already in the set
                    if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in col " + j) ||
                        !seen.add(number + " in block " + i/3 + "-" + j/3)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
