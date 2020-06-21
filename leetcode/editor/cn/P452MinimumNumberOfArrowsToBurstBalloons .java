//在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x
//坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在104个气球。
//
// 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足 xstart ≤
// x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量
//。
//
// Example:
//
//
//输入:
//[[10,16], [2,8], [1,6], [7,12]]
//
//输出:
//2
//
//解释:
//对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
//
// Related Topics 贪心算法

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//Java：用最少数量的箭引爆气球
class P452MinimumNumberOfArrowsToBurstBalloons{
    public static void main(String[] args) {
        Solution solution = new P452MinimumNumberOfArrowsToBurstBalloons().new Solution();
        // TO TEST
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinArrowShots(int[][] points) {
        //计算 "最多" 能组成的不重叠区间个数，也就是射出箭的个数
        if (points.length == 0) {
            return 0;
        }
        //按区间的结尾进行排序
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        //每次选择结尾最小，并且和前一个区间不重叠的区间。(贪心算法)
        int cnt = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                //和前一个区间重叠 属于重叠区间
                continue;
            }
            //不重叠，不重叠区间个数加1，区间结尾指向下一个
            cnt++;
            end = points[i][1];
        }
        return cnt;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
