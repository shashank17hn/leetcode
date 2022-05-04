/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 *
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 *
 * Input: s = "aabb"
 * Output: -1
 * */
class Solution {
    public int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap<>();

        int k =0;

        for(int i =0; i< s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i) ,map.get(s.charAt(i))+1);
                if(s.charAt(k) == s.charAt(i)){
                    while(k<=i && map.get(s.charAt(k)) != 1){
                        k++;
                    }
                }
            }else{
                map.put(s.charAt(i) ,1);
            }
        }
        if(k == s.length()){
            return -1;
        }
        return k;

    }
}