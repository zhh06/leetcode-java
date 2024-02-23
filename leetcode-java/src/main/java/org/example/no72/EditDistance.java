package org.example.no72;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();
        int[][] dp = new int[word1Length + 1][word2Length + 1];
        for (int i = 0; i <= word1Length; i++) {
            for (int j = 0; j <= word2Length; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Integer.min(dp[i - 1][j], Integer.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }

            }
        }
        return dp[word1Length][word2Length];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(new EditDistance().minDistance(word1, word2));
    }

}
