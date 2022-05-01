/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input: s = "aa", p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 *
 * Input: s = "cb", p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * */

class Solution {
    public boolean isMatch(String s, String p) {

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i=1 ; i< dp[0].length; i++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = true;
            }else break;
        }
        //System.out.println("test");
        for(int i=1 ; i<dp.length ; i++){
            for(int j=1; j<dp[i].length ; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if( p.charAt(j-1)  == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j] = false;
                }
                // System.out.println(s.charAt(i-1)+ " : " + p.charAt(j-1)  +  " "+ dp[i][j]);
            }
        }
        return dp[s.length()][p.length()];
    }
}