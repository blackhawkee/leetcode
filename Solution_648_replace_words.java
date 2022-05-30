import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
 * @lc app=leetcode id=648 lang=java
 *
 * [648] Replace Words
 */

// @lc code=start
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] arr = sentence.split(" ");

        int i = 0;
        for (String str : arr) {
            Iterator<String> iter = dictionary.iterator();
            String temp = null;
            while (iter.hasNext()) {
                String iterVal = iter.next();
                if (str.startsWith(iterVal) && (temp != null && iterVal.length() < temp.length())) {
                    temp = iterVal;
                }
            }
            if (temp != null) {
                arr[i] = temp;
            }
            i++;
        }

        StringBuffer sBuffer = new StringBuffer();
        for (String str : arr) {
            sBuffer.append(str).append(" ");
        }

        return sBuffer.toString().trim();
    }

}

/**
 * Solution_648_replace_words
 */
public class Solution_648_replace_words {

    public static void main(String[] args) {
        Solution obj = new Solution();
        String[] arr = { "cat", "bat", "rat" };
        System.out.println(obj.replaceWords(Arrays.asList(arr), "the cattle was rattled by the battery"));
    }
}

// @lc code=end
