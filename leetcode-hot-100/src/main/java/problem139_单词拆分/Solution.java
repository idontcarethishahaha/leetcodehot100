package problem139_单词拆分;

import java.util.*;

public class Solution {

    // 字典树节点
    static class TrieNode {
        // 子节点
        Map<Character, TrieNode> children;
        // 是否是一个单词的结尾
        boolean isEnd;

        public TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    // 插入单词到字典树
    private void insert(String word, TrieNode root) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEnd = true;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // 构建字典树
        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            insert(word, root);
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            if (!dp[i]) {
                continue;
            }
            // 从位置 i 开始，在字典树中查找所有可能的单词
            TrieNode node = root;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (!node.children.containsKey(c)) {
                    // 字典树中没有这个字符，后面的子串也不可能匹配，直接跳出
                    break;
                }
                node = node.children.get(c);
                if (node.isEnd) {
                    // 找到一个完整的单词，更新 dp[j+1]
                    dp[j + 1] = true;
                }
            }
        }

        return dp[n];
    }
}
