//设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整
//个棋盘的那两条对角线。 
//
// 注意：本题相对原题做了扩展 
//
// 示例: 
//
//  输入：4
// 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// 解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics 回溯算法 
// 👍 54 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：Eight Queens LCCI
//面试题 08.12
class PEightQueensLcci{
    public static void main(String[] args) {
        Solution solution = new PEightQueensLcci().new Solution();
        solution.solveNQueens(2);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<String>> res = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            char[][] chess = new char[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    chess[i][j] = '.';
            backtrack(chess, 0);
            return res;
        }

        private void backtrack(char[][] board, int row) {
            if (row == board.length) {
                res.add(construct(board));
                return;
            }
            int n = board[row].length;
            for (int col = 0; col < n; col++) {
                if (!isValid(board, row, col)) continue;
                board[row][col] = 'Q';
                backtrack(board, row + 1);
                board[row][col] = '.';
            }


        }

        private boolean isValid(char[][] board, int row, int col) {
            int n = board.length;
            for (int i = 0; i < row; i++) {
                if (board[i][col] == 'Q')
                    return false;
            }

            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (board[i][j] == 'Q')
                    return false;
            }

            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q')
                    return false;
            }
            return true;
        }

        //把数组转为list
        private List<String> construct(char[][] chess) {
            List<String> path = new ArrayList<>();
            for (char[] chars : chess) {
                path.add(new String(chars));
            }
            return path;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}