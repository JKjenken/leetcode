//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。 
//
// 示例 1: 
//
// 
//输入:
//"tree"
//
//输出:
//"eert"
//
//解释:
//'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// 
//
// 示例 2: 
//
// 
//输入:
//"cccaaa"
//
//输出:
//"cccaaa"
//
//解释:
//'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
// 
//
// 示例 3: 
//
// 
//输入:
//"Aabb"
//
//输出:
//"bbAa"
//
//解释:
//此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
// 
// Related Topics 堆 哈希表

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Java：根据字符出现频率排序
class P451SortCharactersByFrequency {
    public static void main(String[] args) {
        Solution solution = new P451SortCharactersByFrequency().new Solution();
        // TO TEST
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String frequencySort(String s) {
            HashMap<Character, Integer> map = new HashMap<>();

//            for (char c : s.toCharArray()) {
//                if (map.containsKey(c)) {
//                    map.put(c, map.get(c) + 1);
//                } else {
//                    map.put(c, 1);
//                }
//            }
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            List<Character>[] bucket = new ArrayList[s.length() + 1];

            map.forEach((key, val) -> {
                if (bucket[val] == null) {
                    bucket[val] = new ArrayList<>();
                }
                bucket[val].add(key);
            });
            StringBuffer str = new StringBuffer();
            for (int i = bucket.length - 1; i >= 0; i--) {
                if (bucket[i] == null) {
                    continue;
                }
                for (char c : bucket[i]) {
                    for (int j = 0; j < i; j++) {
                        str.append(c);
                    }
                }
            }

            return str.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}