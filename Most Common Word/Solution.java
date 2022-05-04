/**
 * Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.
 *
 * The words in paragraph are case-insensitive and the answer should be returned in lowercase.
 *
 *
 *
 * Example 1:
 *
 * Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 * Example 2:
 *
 * Input: paragraph = "a.", banned = []
 * Output: "a"
 * */
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> ref = new HashMap<>();
        String [] para = paragraph.replaceAll("[^a-zA-Z0-9]"," ").split(" ");

        Set<String> ban = new HashSet<>();
        int max = Integer.MIN_VALUE;
        String result = "";
        for(int i =0 ; i< banned.length; i++){
            ban.add(banned[i].toLowerCase());
        }

        for(int i =0 ; i<para.length ;i++){
            String word = para[i].trim().toLowerCase();
            if(!ban.contains(word) && word.length()>0){
                if(ref.containsKey(word)){
                    ref.put(word, ref.get(word)+1);
                }else {
                    ref.put(word, 1);
                }

            }
        }

        for(String key : ref.keySet()){
            System.out.println(key + " " +ref.get(key) );
            if(ref.get(key) > max){
                max = ref.get(key) ;
                result = new String(key);
            }

        }
        return result;

    }
}