/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 * */

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0,new ArrayList<>());
        return result;
    }

    private void helper(String s , int index, List<String> list){

        if(index>s.length()) return;

        if(index ==s.length()){
            System.out.println(index + " ADD" + list);
            result.add(new ArrayList<>(list));
        }

        for(int i=index ; i<s.length() ; i++){
            String temp = s.substring(index,i+1);
            System.out.println(index + " " +temp);
            boolean flag = false;
            if(isPalindrome(temp)){
                list.add(temp);
                helper(s, i+1,list);
                list.remove(list.size()-1);
            }

        }

    }

    private boolean isPalindrome(String s){
        int start =0;
        int end = s.length()-1;

        while(start<end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;

    }
}