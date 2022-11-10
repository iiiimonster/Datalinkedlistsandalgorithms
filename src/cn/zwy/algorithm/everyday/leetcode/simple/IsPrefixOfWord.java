package cn.zwy.algorithm.everyday.leetcode.simple;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/">1455. 检查单词是否为句中其他单词的前缀</a><BR/>
 * &#064;author:  zwy<BR/>
 * &#064;date:  2022年08月24日 17:22<BR/>
 */
public class IsPrefixOfWord {

    /**
     * 思路一：双指针
     * 1.先判断是否越界
     * 2.
     *
     * @param sentence   总的字符串
     * @param searchWord 需要判断的字符串
     * @return 返回在 总的字符串第几位
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        int index = 1, start = 0, end = 0;
        int length = sentence.length();
        while (start < length) {
            if (end < length && sentence.charAt(end) != ' ') {
                end++;
            }
            if (isPrefix(start, end, sentence, searchWord)) {
                return index;
            }
            index++;
            end++;
            start = end;
        }
        return -1;
    }

    public boolean isPrefix(int start, int end, String sentence, String searchWord) {
        for (int i = 0; i < searchWord.length(); i++) {
            if (start + i >= end || searchWord.charAt(i) != sentence.charAt(start + i)) {
                return false;
            }
        }
        return true;
    }

}
