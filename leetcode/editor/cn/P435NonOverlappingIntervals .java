//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。 
//
// 注意: 
//
// 
// 可以认为区间的终点总是大于它的起点。 
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 
// 
//
// 示例 1: 
//
// 
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
// Related Topics 贪心算法

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//Java：无重叠区间
class P435NonOverlappingIntervals{
    public static void main(String[] args) {
        Solution solution = new P435NonOverlappingIntervals().new Solution();
        // TO TEST
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //先计算 "最多" 能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
        //在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，
        // 那么后面能够选择的区间个数也就越大。
        if (intervals.length == 0) {
            return 0;
        }

        //按区间的结尾进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        //每次选择结尾最小，并且和前一个区间不重叠的区间。(贪心算法)
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                //和前一个区间重叠
                continue;
            }
            //不重叠，不需要移除，区间结尾指向下一个
            end = intervals[i][1];
            //不重叠区间个数+1
            cnt++;
        }
        return intervals.length - cnt;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}