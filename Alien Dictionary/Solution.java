/**
 * There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.
 *
 * You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted lexicographically by the rules of this new language.
 *
 * Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.
 *
 * A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s comes before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same, then s is smaller if and only if s.length < t.length.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 * Example 2:
 *
 * Input: words = ["z","x"]
 * Output: "zx"
 * Example 3:
 *
 * Input: words = ["z","x","z"]
 * Output: ""
 * Explanation: The order is invalid, so return "".
 * */

class Solution {
    Map<Character, Integer> indegree = new HashMap<>();
    public String alienOrder(String[] words) {
        Queue<Character> queue = new LinkedList<>();
        Map<Character, Set<Character>> map= new HashMap<>();
        StringBuilder sb = new StringBuilder();
        createGraph(words, map);

        for(char key : map.keySet()){
            if(indegree.get(key).equals(0)){
                queue.add(key);
            }
        }
        System.out.println(map);
        System.out.println("before " +  indegree);
        while(!queue.isEmpty()){

            char c = queue.poll();
            System.out.println(c + " " + indegree);
            sb.append(c);
            for(char child : map.get(c)){
                indegree.put(child, indegree.get(child) - 1);
                if(indegree.get(child).equals(0)){
                    queue.add(child);
                }
            }

        }
        System.out.println(sb.toString());

        if(sb.length() < indegree.size()){
            return "";
        }
        return sb.toString();


    }

    private void createGraph(String[] words , Map<Character, Set<Character>> map){
        for(String word : words){
            for(char c: word.toCharArray()){
                indegree.put(c,0);
                map.put(c, new HashSet<>());
            }
        }

        for(int i=1 ; i<words.length; i++){
            String first = words[i-1];
            String second = words[i];
            int len = Math.min(first.length(), second.length());
            for(int j =0; j<len ; j++){
                if(first.charAt(j)!= second.charAt(j)){
                    map.get(first.charAt(j)).add(second.charAt(j));
                    indegree.put(second.charAt(j), indegree.get(second.charAt(j)) + 1);
                    break;
                }

            }
        }
    }
}