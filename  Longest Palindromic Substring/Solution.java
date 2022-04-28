/**
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 * */

class Solution {

    int  resultLength;
    int  resultStart;

    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        for(int start=0; start < s.length() ; start++){
            expand(s,start,start);
            expand(s,start,start+1);
        }
        // System.out.println(resultStart + " " + resultLength + " " +  resultStart+ resultLength);
        return s.substring(resultStart, resultStart+ resultLength);
    }


    public void expand(String givenString , int start , int end){
        while(start>=0 && end<givenString.length() && givenString.charAt(start) == givenString.charAt(end)){
            start--;
            end++;
        }
        if(resultLength < end-start-1){
            resultStart = start+1;
            resultLength =  end-start-1;
        }
    }
}