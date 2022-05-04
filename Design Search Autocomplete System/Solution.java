/**
 * Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#').
 *
 * You are given a string array sentences and an integer array times both of length n where sentences[i] is a previously typed sentence and times[i] is the corresponding number of times the sentence was typed. For each input character except '#', return the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed.
 *
 * Here are the specific rules:
 *
 * The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
 * The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same hot degree, use ASCII-code order (smaller one appears first).
 * If less than 3 hot sentences exist, return as many as you can.
 * When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
 * Implement the AutocompleteSystem class:
 *
 * AutocompleteSystem(String[] sentences, int[] times) Initializes the object with the sentences and times arrays.
 * List<String> input(char c) This indicates that the user typed the character c.
 * Returns an empty array [] if c == '#' and stores the inputted sentence in the system.
 * Returns the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed. If there are fewer than 3 matches, return them all.
 *
 *
 * Example 1:
 *
 * Input
 * ["AutocompleteSystem", "input", "input", "input", "input"]
 * [[["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]], ["i"], [" "], ["a"], ["#"]]
 * Output
 * [null, ["i love you", "island", "i love leetcode"], ["i love you", "i love leetcode"], [], []]
 *
 * Explanation
 * AutocompleteSystem obj = new AutocompleteSystem(["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]);
 * obj.input("i"); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
 * obj.input(" "); // return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
 * obj.input("a"); // return []. There are no sentences that have prefix "i a".
 * obj.input("#"); // return []. The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
 * */

class AutocompleteSystem {

    TrieNode root;
    TrieNode curr;
    StringBuilder sb;


    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        curr = root;
        sb = new StringBuilder();
        for(int i =0 ; i< sentences.length ; i++){
            insert(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        if(c == '#'){
            curr =root;
            insert(sb.toString(),1);
            sb = new StringBuilder();
            return result;
        }
        sb.append(c);
        if(curr!= null){
            curr = curr.children.get(c);
        }

        if(curr == null){
            return result;
        }
        for(TrieNode node : curr.hotList){
            result.add(node.word);
        }

        return result;
    }

    private void insert(String word, int times){
        TrieNode node = root;
        List<TrieNode> list = new ArrayList<>();
        for(int i =0 ; i<word.length() ; i++){
            if(!node.children.containsKey(word.charAt(i))){
                node.children.put(word.charAt(i) , new TrieNode());
            }
            node = node.children.get(word.charAt(i));
            list.add(node);
        }
        node.word = word;
        node.times += times;
        for(TrieNode temp : list){
            temp.update(node);
        }
    }
}

class TrieNode implements Comparable<TrieNode>{
    Map<Character, TrieNode> children;
    String word;
    List<TrieNode> hotList;
    int times;
    public TrieNode(){
        children = new HashMap<>();
        word = null;
        hotList = new ArrayList<>();
        times =0;
    }

    public int compareTo(TrieNode node1){
        if(node1.times == this.times){
            return this.word.compareTo(node1.word);
        }else{
            return node1.times-this.times;
        }
    }

    public void update(TrieNode node){
        if(!hotList.contains(node)){
            hotList.add(node);
        }
        Collections.sort(hotList);
        if(hotList.size()>3){
            hotList.remove(hotList.size()-1);
        }
    }


}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */