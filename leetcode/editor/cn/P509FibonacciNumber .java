//斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
//
// F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
//
//
// 给定 N，计算 F(N)。
//
//
//
// 示例 1：
//
// 输入：2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
//
//
// 示例 2：
//
// 输入：3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
//
//
// 示例 3：
//
// 输入：4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
//
//
//
//
// 提示：
//
//
// 0 ≤ N ≤ 30
//
// Related Topics 数组

package leetcode.editor.cn;
//Java：斐波那契数
class P509FibonacciNumber{
    public static void main(String[] args) {
        Solution solution = new P509FibonacciNumber().new Solution();
//        int result = solution.fib(20);
//        System.out.println(result);
        // TO TEST
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int N) {
        if (N==0) return 0;
//        int [] dp = new int[N+1];
//        dp[1] = dp[2] = 1;
//        for (int i = 3;i<=N;i++){
//            dp[i] = dp[i-1] +dp[i-2];
//        }
//        return dp[N];
        if (N ==2 || N ==1) return 1;
        int prev = 1,curr =1;
        for (int i = 3;i<=N;i++){
            int sum = prev +curr;
//            dp[i-2] = dp[i-1]
            prev = curr;
//            dp[i-1] = dp[i]
            curr = sum;
        }
        return curr;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
