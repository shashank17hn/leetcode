/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 * A substring is a contiguous sequence of characters within the string.
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * */

class Solution {
    public String minWindow(String s, String t) {
        if(t.length()> s.length()){
            return "";
        }
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Integer> current = new HashMap<>();
        int need = 0;
        int have =0;
        int[] resultIndex = {0,0};
        int min = Integer.MAX_VALUE;
        for(int i =0; i< t.length() ; i++){
            count.put(t.charAt(i), count.getOrDefault(t.charAt(i),0)+1);
            need++;
        }
        int left=0;
        for(int i =0 ; i< s.length() ; i++){
            // System.out.println("before "+ current + " " + have + " " + need);
            if(count.containsKey(s.charAt(i)) && count.get(s.charAt(i)) > current.getOrDefault(s.charAt(i), 0)){
                current.put(s.charAt(i), current.getOrDefault(s.charAt(i),0)+1);
                have++;
            }else if(count.containsKey(s.charAt(i))){
                current.put(s.charAt(i), current.getOrDefault(s.charAt(i),0)+1);
            }
            //  System.out.println("before "+ current + " " + have + " " + need);
            while(need == have){
                //   System.out.println("comp "+ left + " " + i);
                if(min > i-left+1){
                    min = i-left+1;
                    resultIndex[0] = left;
                    resultIndex[1] = i;
                }
                if(current.containsKey(s.charAt(left))){
                    current.put(s.charAt(left), current.getOrDefault(s.charAt(left),0)-1);
                    if(count.get(s.charAt(left)) > current.getOrDefault(s.charAt(left), 0))
                        have--;
                }
                left++;
            }
            // System.out.println("after "+ resultIndex[0] + " "+ resultIndex[1] + " " + min);

        }

        StringBuilder sb = new StringBuilder();
        System.out.println("resultIndex "+ resultIndex[0] + " "+ resultIndex[1] + " " +min);
        if(min < Integer.MAX_VALUE){
            for(int i = resultIndex[0] ; i<= resultIndex[1] ; i++){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}