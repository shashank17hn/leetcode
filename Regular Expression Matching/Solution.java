/**
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * */

class Solution {

    public boolean isMatch(String s, String p) {
        return isMatch(0,0,s,p);
    }

    private boolean isMatch(int i , int j , String s , String p){
        System.out.println(i + " " +  j);
        if(i >= s.length() && j >= p.length()){
            return true;
        }
        if(j >= p.length()){
            return s.isEmpty();
        }
        System.out.println(s.charAt(i) + " " +  p.charAt(j));

        boolean match = (i < s.length() && (s.charAt(i) == p.charAt(j) ||  p.charAt(j) == '.'));

        if(j+1 < p.length()-1 && p.charAt(j+1) == '*'){
            return (isMatch(i , j+2 , s, p) || (match && isMatch(i+1 , j , s, p)));

        }

        if(match) {
            return isMatch(i+1 , j+1 , s, p);
        }
        if(p.charAt(j) == '*'){
            return true;

        }
        else {
            return false;
        }
    }
}


//  **** Dynamic Programic Solution *** (might not work)
//     public boolean isMatch(String s, String p) {
//         boolean[][] dp = new boolean[s.length()+1][p.length()+1];
//         dp[0][0] = true;
//         for(int i=2 ; i< dp[0].length; i++){
//             if(p.charAt(i-1) == '*' && p.charAt(i-2)!= '*'){
//                 dp[0][i] = true;
//             }
//         }
//         //System.out.println("test");
//         for(int i=1 ; i<dp.length ; i++){
//             for(int j=1; j<dp[i].length ; j++){
//                 if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
//                     dp[i][j] = dp[i-1][j-1];
//                 }else if( p.charAt(j-1)  == '*'){
//                     dp[i][j] = dp[i-1][j] || dp[i][j-1];
//                 }else{
//                     dp[i][j] = false;
//                 }
//                // System.out.println(s.charAt(i-1)+ " : " + p.charAt(j-1)  +  " "+ dp[i][j]);
//             }
//         }
//         return dp[s.length()][p.length()];
//     }