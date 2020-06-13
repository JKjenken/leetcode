//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
//
// 你可以假设 nums1 和 nums2 不会同时为空。
//
//
//
// 示例 1:
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
//
//
// 示例 2:
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
//
// Related Topics 数组 二分查找 分治算法

package leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

//Java：寻找两个正序数组的中位数
class P4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
        // TO TEST
        int[] nums1 = new int[]{1, 4, 5, 6, 7, 8};
        int[] nums2 = new int[]{3, 5, 8, 8, 9, 11, 12};
        double middle = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(middle);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            //提炼规则->利用规则设置判定条件->判定是确认所使用的常用算法原理
            //数组1： [蓝框(最后一位是A),橘框]； 数组2： [蓝框(最后一位是B),橘框]
            //蓝框是中位数左边的数（包括中位数），而橘框则为中位数右边的数。
            //4个显然的规则： 1.两个数组的蓝框总个数=(数字总个数+1)/2; 2.所有蓝框内的数都小于橘框内的数
            //3.中位数为蓝框中最大的那一位（即数组1蓝框最后一位A，或数组2蓝框最后一位B） 4。当总个数为偶数时，中位数为 蓝框中最大的那一位与它的下一项相加并除以2

            // 使nums1成为较短数组,不仅可以提高检索速度,同时可以避免一些边界问题
            if (nums1.length > nums2.length) {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
            }

            int len1 = nums1.length;
            int len2 = nums2.length;
            int leftLen = (len1 + len2 + 1) / 2; //两数组合并&排序后,左半边的长度

            // 对数组1进行二分检索
            int start = 0;
            int end = len1;
            while (start <= end) {
                //数组1的A的左边蓝框个数
                int count1 = start + ((end - start) / 2);
                //数组2的蓝框个数
                int count2 = leftLen - count1;
                if (count1 > 0 && nums1[count1 - 1] > nums2[count2]) {
                    //A比B的next还要大,往左二分
                    end = count1 - 1;
                } else if (count1 < len1 && nums2[count2 - 1] > nums1[count1]) {
                    //B比A的next还要大,往右二分
                    start = count1 + 1;
                } else {
                    //满足规则2，根据规则3获取中位数(使用三元运算符替代if-else if的操作)
                    int result = (count1 == 0) ? nums2[count2 - 1] : (count2 == 0) ? nums1[count1 - 1] : Math.max(nums1[count1 - 1], nums2[count2 - 1]);
                    if (isOdd(len1 + len2)) {
                        //奇数直接返回结果
                        return result;
                    }
                    //根据规则4 处理偶数的情况
                    //获取下一项
                    int nextValue = (count1 == len1) ? nums2[count2] :
                            (count2 == len2) ? nums1[count1] :
                                    Math.min(nums1[count1], nums2[count2]);
                    return (result + nextValue) / 2.0;
                }
            }
            return Integer.MIN_VALUE;
        }

        // 奇数返回true,偶数返回false
        private boolean isOdd(int x) {
            return (x & 1) == 1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
