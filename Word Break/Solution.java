class Solution {
    // TrieNode root;
    // Map<String, Boolean> ref = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
//         root = new TrieNode();
//         insert(wordDict);
//         return traverse(s);


        // first approach using dp
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        for(int i =1 ; i<=s.length() ; i++){
            for(int j=0 ; j<i ; j++){
                System.out.println(s.substring(j,i));
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];


    }

 // Using tries
//     private boolean traverse(String word){
//         if(ref.containsKey(word)) return ref.get(word);

//         if(search(word)) return true;

//         for(int i=0 ; i<word.length() ; i++){
//             if(search(word.substring(0,i))){
//                 if(traverse(word.substring(i))){
//                     ref.put(word.substring(i), true);
//                 }
//             }
//         }

//         ref.put(word,false);
//         return false;

//     }

//     private boolean search(String word){
//         TrieNode node = root;
//         for(int i=0 ; i<word.length() ; i++){
//             if(node.children.containsKey(word.charAt(i))){
//                      node = node.children.get(word.charAt(i));
//             }else{
//                     return false;
//                 }
//             }
//         return node.isWord;

//     }

//     private void insert(List<String> words){
//         for(String word : words){
//             TrieNode node = root;
//             for(int i =0 ; i<word.length() ; i++){
//                 if(!node.children.containsKey(word.charAt(i))){
//                     node.children.put(word.charAt(i), new TrieNode());
//                 }
//                 node = node.children.get(word.charAt(i));
//             }
//             node.isWord = true;
//         }

//     }


// }

// class TrieNode{
//     Map<Character,TrieNode> children;
//     boolean isWord;
//     public TrieNode(){
//        children =  new HashMap();
//         isWord = false;
//     }
}