//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来
//重建这个队列。
//
// 注意：
//总人数少于1100人。
//
// 示例
//
//
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
//
// Related Topics 贪心算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：根据身高重建队列
class P406QueueReconstructionByHeight{
    public static void main(String[] args) {
        Solution solution = new P406QueueReconstructionByHeight().new Solution();
        // TO TEST
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //为了使插入操作不影响后续的操作，身高较高的学生应该先做插入操作，否则身高较小的学生原先正确插入的第 k 个位置可能会变成第 k+1 个位置。
        //身高 h 降序、个数 k 值升序，将某个学生插入队列的第 k 个位置中。
        //输入:
        //[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
        // 操作步骤:
        // 排序 [7,0] [7,1] [6,1] [5,0] [5,2] [4,4]
        //逐个插入
        // [7,0]
        // [[7,0],[7,1]]
        // [[7,0],[6,1],[7,1]]
        // [[5,0],[7,0],[6,1],[7,1]]
        // [[5,0],[7,0],[5,2],[6,1],[7,1]]
        // [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
        //空数组校验
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        //排序（身高 h 降序、个数 k 值升序）
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> list = new ArrayList<>(people.length);
        for (int[] p : people){
            //插入到第k个位置
            list.add(p[1],p);
        }
//        int[][] ret = new int[people.length][2];
//        for(int i = 0; i < people.length; i++) {
//            ret[i][0] = list.get(i)[0];
//            ret[i][1] = list.get(i)[1];
//        }
//        return ret;
        return list.toArray(new int[list.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
