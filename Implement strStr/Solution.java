/**
 * Implement strStr().
 *
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * */

class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 && needle.length() == 0){
            return 0;
        }
        if(haystack.length() == 0){
            return -1;
        }
        if(needle.length() == 0){
            return 0;
        }
        if(needle.length()> haystack.length() ){
            return -1;
        }
        int result=-1;
        for(int i =0; i< haystack.length() ; i++){
            if(haystack.charAt(i) == needle.charAt(0) && haystack.substring(i,haystack.length()).length() >= needle.length()){
                result = i;
                //System.out.println("change "+ haystack.substring(i,i+needle.length()) + " "+needle);
                if(haystack.substring(i,i+needle.length()).equals(needle)){
                    result =i;
                }else{
                    result =-1;

                }
                if(result>=0){
                    return result;
                }
            }else{
                result = -1;
            }
        }
        return result;
    }
}