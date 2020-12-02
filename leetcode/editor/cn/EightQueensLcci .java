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
// 👍 52 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：八皇后
class EightQueensLcci{
    public static void main(String[] args) {
        Solution solution = new EightQueensLcci().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        String[][] res = new String[0][];
    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][];
        Arrays.fill(board,".");
//        backtrack(n)
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
