/**
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 *
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * */
class Solution {
    int count = 0;
    public int countSubstrings(String s) {

        for(int i =0 ; i < s.length() ; i++){
            isPalindrome(i,i ,s );
            isPalindrome(i,i+1,s );
        }
        return count;
    }

    private void isPalindrome(int start, int end ,String s){
        int left = start;
        int right = end;
        while(left>=0 && right< s.length() && s.charAt(left)  == s.charAt(right)){
            if(s.charAt(left)  == s.charAt(right)){
                count++;
                left--;
                right++;
            }
        }
    }
}