/**
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 * */

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        // if(set.contains(beginWord)) return 0;
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<String> queue =new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        int change = 1;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0 ; i<size ; i++){

                String word = queue.poll();
                if(word.equals(endWord)) return change;

                for(int j=0 ; j< word.length() ; j++){


                    for(int k ='a'; k<='z'; k++){
                        char[] wordArr = word.toCharArray();
                        wordArr[j] = (char) k;
                        String newWord = new String(wordArr);

                        if(set.contains(newWord) && !visited.contains(newWord)){
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            change++;
        }

        return 0;

    }
}