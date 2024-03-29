//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干
//的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满
//足越多数量的孩子，并输出这个最大数值。 
//
// 注意： 
//
// 你可以假设胃口值为正。 
//一个小朋友最多只能拥有一块饼干。 
//
// 示例 1: 
//
// 
//输入: [1,2,3], [1,1]
//
//输出: 1
//
//解释: 
//你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
//虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
//所以你应该输出1。
// 
//
// 示例 2: 
//
// 
//输入: [1,2], [1,2,3]
//
//输出: 2
//
//解释: 
//你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
//你拥有的饼干数量和尺寸都足以让所有孩子满足。
//所以你应该输出2.
// 
// Related Topics 贪心算法

package leetcode.editor.cn;

import java.util.Arrays;

//Java：分发饼干
class P455AssignCookies{
    public static void main(String[] args) {
        Solution solution = new P455AssignCookies().new Solution();
        // TO TEST
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //贪心算法
        //1.给一个孩子的饼干应当尽量小并且又能满足该孩子，这样大饼干才能拿来给满足度比较大的孩子。
        //2.因为满足度最小的孩子最容易得到满足，所以先满足满足度最小的孩子。
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi <= si && gi < g.length && si < s.length) {
            //给满足度最小的小孩一块最小的饼干
            if (g[gi] <= s[si]) {
                //满足
                gi++;
            }
            //不满足的话，再拿一块更大的
            si++;
        }
        return gi;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}