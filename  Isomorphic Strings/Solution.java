/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 * */

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Character> refMap = new HashMap<>();
        Map<Character, Character> crossMap = new HashMap<>();
        for(int i=0 ; i< s.length() ; i++){

            if(refMap.containsKey(s.charAt(i))){
                if(crossMap.containsKey(t.charAt(i)) &&
                        refMap.get(s.charAt(i)) == t.charAt(i) && crossMap.get(t.charAt(i)) == s.charAt(i)){
                    continue;
                }else{
                    return false;
                }
            }else if(crossMap.containsKey(t.charAt(i))){
                return false;
            }else{
                refMap.put(s.charAt(i), t.charAt(i));
                crossMap.put(t.charAt(i), s.charAt(i));

            }
            System.out.println(refMap);
            System.out.println(crossMap);
        }


        return true;

    }
}