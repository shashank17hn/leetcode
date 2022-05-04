/**
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 *
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * */
class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> ref = new HashMap<>();
        int windowStart=0;
        int result = 0;
        int max =0;
        for(int windowEnd =0; windowEnd< s.length() ;windowEnd++){

            ref.put(s.charAt(windowEnd), ref.getOrDefault(s.charAt(windowEnd),0) + 1);
            max = Math.max(max ,ref.get(s.charAt(windowEnd)));

            if((windowEnd-windowStart +1) - max > k){
                ref.put(s.charAt(windowStart), ref.getOrDefault(s.charAt(windowStart),0) - 1);
                windowStart++;
            }
            System.out.println(ref);
            result = Math.max(result , windowEnd-windowStart +1);
        }

        return result;
    }

    // private int getMax (Map<Character, Integer> ref) {
    //    return Collections.max(ref.entrySet(), (e1,e2)-> e1.getValue()- e2.getValue()).getValue();
    // }
}