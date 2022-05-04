/**
 * Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.
 *
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 * Example 2:
 *
 * Input: words = ["cat","dog","catdog"]
 * Output: ["catdog"]
 * */

class Solution {
    int min = Integer.MAX_VALUE;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet();
        for(int i =0 ; i< words.length; i++){
            if(words[i].length() ==0){
                continue;
            }
            set.add(words[i]);
            min = Math.min(words[i].length(),min);
        }

        for(int i = 0 ; i < words.length ; i++){
            if(canForm(words[i],set)){
                result.add(words[i]);
            }
        }

        return result;
    }

    private boolean canForm(String word , Set<String> set){
        for(int i= min ; i<= word.length()-min ; i++){
            String left = word.substring(0,i);
            String right = word.substring(i);
            if(set.contains(left)){
                if(set.contains(right)|| canForm(right,set))
                    return true;
            }
        }
        return false;
    }
}