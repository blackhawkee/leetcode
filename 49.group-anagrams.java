import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> oLists = new ArrayList<>();
        for (String string : strs) {
            char[] stringArr = string.toCharArray();
            Arrays.sort(stringArr);
            String sortedString = String.valueOf(stringArr);

            if (map.containsKey(sortedString)) {
                List<String> tempList = new ArrayList<>(map.get(sortedString));

                tempList.add(string);
                map.put(sortedString, tempList);
            } else {
                map.put(sortedString, List.of(string));
            }
        }

        for (var entry : map.entrySet()) {
            oLists.add(entry.getValue());
        }

        return oLists;
    }
}

// @lc code=end
