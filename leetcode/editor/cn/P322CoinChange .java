//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。
//
// 你可以认为每种硬币的数量是无限的。
//
//
//
// 示例 1：
//
//
//输入：coins = [1, 2, 5], amount = 11
//输出：3
//解释：11 = 5 + 5 + 1
//
// 示例 2：
//
//
//输入：coins = [2], amount = 3
//输出：-1
//
// 示例 3：
//
//
//输入：coins = [1], amount = 0
//输出：0
//
//
// 示例 4：
//
//
//输入：coins = [1], amount = 1
//输出：1
//
//
// 示例 5：
//
//
//输入：coins = [1], amount = 2
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104
//
// Related Topics 动态规划
// 👍 945 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：零钱兑换
class P322CoinChange {
    public static void main(String[] args) {
        Solution solution = new P322CoinChange().new Solution();
        // TO TEST
//        solution.coinChange()
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //明确「状态」 -> 定义 dp 数组/函数的含义 -> 明确「选择」-> 明确 base case。
        //动态规划三要素：重叠子问题、最优子结构、状态转移方程
        public int coinChange(int[] coins, int amount) {
//            return dp(coins, amount);

//            Map<Integer, Integer> memo = new HashMap<>();
//            return dp(coins,amount,memo);

            //dp数组的迭代解法(自底向上)
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 0; i < dp.length; i++) {
                for (int coin : coins) {
                    if (i - coin < 0) continue;
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];

        }

        /**
         * 暴力递归解法
         *
         * 但凡遇到需要递归的问题，最好都画出递归树，这对你分析算法的复杂度，寻找算法低效的原因都有巨大帮助。
         */
        private int dp(int[] coins, int amount) {
            if (amount == 0) return 0;
            if (amount < 0) return -1;
            int res = amount + 1;
            for (int coin :
                    coins) {
                int subProblem = dp(coins, amount - coin);
                if (subProblem == -1) continue;
                res = Math.min(res, 1 + subProblem);
            }
            return res == amount + 1 ? -1 : res;
        }

        /**
         * 带备忘录的递归解法
         * <p>
         * 很显然「备忘录」大大减小了子问题数目，完全消除了子问题的冗余，
         * 所以子问题总数不会超过金额数 n，即子问题数目为 O(n)。
         * 处理一个子问题的时间不变，仍是 O(k)，所以总的时间复杂度是 O(kn)
         */
        private int dp(int[] coins, int amount, Map<Integer, Integer> memo) {
            // 查备忘录，避免重复计算
            if (memo.containsKey(amount)) {
                return memo.get(amount);
            }
            if (amount == 0) return 0;
            if (amount < 0) return -1;
            int res = amount + 1;
            for (int coin :
                    coins) {
                int subProblem = dp(coins, amount - coin, memo);
                if (subProblem == -1) continue;
                res = Math.min(res, 1 + subProblem);
            }
            //记入备忘录
            if (res != amount + 1) {
                memo.put(amount, res);
            } else {
                memo.put(amount, -1);
            }
            return memo.get(amount);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
