/**
 * Let the function f(s) be the frequency of the lexicographically smallest character in a non-empty string s. For example, if s = "dcce" then f(s) = 2 because the lexicographically smallest character is 'c', which has a frequency of 2.
 *
 * You are given an array of strings words and another array of query strings queries. For each query queries[i], count the number of words in words such that f(queries[i]) < f(W) for each W in words.
 *
 * Return an integer array answer, where each answer[i] is the answer to the ith query.
 *
 *
 *
 * Example 1:
 *
 * Input: queries = ["cbd"], words = ["zaaaz"]
 * Output: [1]
 * Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
 * Example 2:
 *
 * Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * Output: [1,2]
 * Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
 * */

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int result[] = new int[queries.length];

        // Map<String, Integer> countMap = new HashMap<>();
        // for(int j =0 ; j<words.length ; j++){
        //     countMap.put(words[j], getMinCount(words[j].toCharArray()));
        // }

        for(int i =0 ; i< queries.length ; i++){
            int count =0;
            char[] mainWord = queries[i].toCharArray();
            // Arrays.sort(mainWord);
            int querieCount = getMinCount(mainWord); //   getCount(mainWord[0], mainWord);
            // for(int wordCount : countMap.values()){
            //      if(wordCount > querieCount) {
            //         count++;
            //     }
            // }
            for(int j =0 ; j<words.length ; j++){

                char[] listWord = words[j].toCharArray();
                // Arrays.sort(listWord);
                int wordCount = getMinCount(listWord); // getCount(listWord[0], listWord);
                //System.out.println(queries[i] + " " + words[j]  + " " + querieCount + " " +  wordCount);
                if(wordCount > querieCount) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }

    private int getCount( char c , char[] word){
        int count =0;
        for(int i = 0 ; i< word.length ; i++){
            if(word[i] == c){
                count++;
            }
        }
        return count;
    }

    private int getMinCount(char[] word){
        char min = word[0];
        int freq =1;
        for(int i = 1 ; i< word.length ; i++){
            //   System.out.println(word[i]  + " " + min +" " + freq);
            if(min > word[i] ){
                min = word[i];
                freq =1;
            }else if(min == word[i]){
                freq++;
            }
        }
        //System.out.println("return " +  min +" " + freq);
        return freq;
    }
}



