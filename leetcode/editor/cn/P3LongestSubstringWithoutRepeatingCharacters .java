//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

package leetcode.editor.cn;


//Java：无重复字符的最长子串
class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
        int result = solution.lengthOfLongestSubstring("abcdhbs");
        System.out.println(result);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int[] temp = new int[96];
            int left = 0;
            int right = -1;
            int result = 0;
            int size = s.length();
            while (left < size) {
                if (right + 1 < size && temp[s.charAt(right + 1) - 32] == 0) {
                    right++;
                    temp[s.charAt(right) - 32]++;
                } else {
                    temp[s.charAt(left) - 32]--;
                    left++;
                }
                if (right - left + 1 > result) {
                    result = right - left + 1;
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}