//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
//
// 说明:
//
//
// 返回的下标值（index1 和 index2）不是从零开始的。
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
//
//
// 示例:
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
// Related Topics 数组 双指针 二分查找

package leetcode.editor.cn;

//Java：两数之和 II - 输入有序数组
class P167TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new P167TwoSumIiInputArrayIsSorted().new Solution();
        // TO TEST
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            if (numbers == null) return null;
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                if (numbers[left] + numbers[right] == target){
                    return new int[]{left + 1, right + 1};
                }else if (numbers[left] + numbers[right] > target) {
                    right--;
                }else {
                    left++;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
