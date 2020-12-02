//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法
// 👍 1024 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：全排列
class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
        solution.permute(new int[]{1,2,3});

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        public List<List<Integer>> permute(int[] nums) {
            // 记录「路径」
            LinkedList<Integer> track = new LinkedList<>();
            backtrack(nums, track);
            return res;
        }
        // 路径：记录在 track 中
        // 选择列表：nums 中不存在于 track 的那些元素
        // 结束条件：nums 中的元素全都在 track 中出现
        private void backtrack(int[] nums, LinkedList<Integer> track) {
            if (track.size() == nums.length){
//                res.add(new LinkedList<>(track));
                res.add(new LinkedList<>(track));
                return;
            }
            for (int num : nums) {
                // 排除不合法的选择
                if (track.contains(num))
                    continue;
                // 做选择
                track.add(num);
                // 进入下一层决策树
                backtrack(nums, track);
                // 取消选择
                track.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
