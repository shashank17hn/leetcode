/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 * **/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> data = new HashMap<>();
        for(int i =0; i< strs.length ; i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String key = String.valueOf(temp);
            if(!data.containsKey(key)){
                data.put(String.valueOf(key), new ArrayList<>());
            }
            data.get(key).add(strs[i]);
        }

        List<List<String>> result = new ArrayList<>();
        data.entrySet().stream().forEach(e ->{
            result.add(e.getValue());
        });

        return result;

    }
}