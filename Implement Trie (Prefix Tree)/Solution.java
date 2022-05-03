/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 *
 * Example 1:
 *
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 *
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 * */

class Trie {

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;
        String word;

        public TrieNode(){
            children =  new HashMap<>();
            isWord =false;
        }
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i< word.length() ; i++){
            if(node.children.containsKey(word.charAt(i))){
                node = node.children.get(word.charAt(i));
            }else {
                TrieNode newNode = new TrieNode();
                node.children.put(word.charAt(i),newNode);
                node = newNode;
            }
        }
        node.isWord = true;
        node.word = word;
        System.out.println("insert "+node.word);
    }

    public boolean search(String word) {
        TrieNode node = helper(word);
        System.out.println("search 1 " + node);
        if(node!=null && node.isWord){
            System.out.println("search " + node.word);
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        return helper(prefix)!= null ? true : false;
    }

    private TrieNode helper(String word){
        TrieNode node = root;
        System.out.println(node.children);
        for(int i=0; i< word.length(); i++){
            if(node.children.containsKey(word.charAt(i))){
                node = node.children.get(word.charAt(i));
            }else {
                return null;
            }
        }
        return node;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */