/**
 * Given a character array s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.
 * Your code must solve the problem in-place, i.e. without allocating extra space.
 * Example 1:
 *
 * Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * Example 2:
 *
 * Input: s = ["a"]
 * Output: ["a"]
 * */
class Solution {
    public void reverseWords(char[] s) {
        int i =0;
        int j = s.length-1;
        while(i<j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }

        i=0;
        j=0;
        // System.out.println(s);
        while(i<s.length){
            while(j<s.length && s[j]!= ' '){
                j++;
            }
            int k =j-1;
            while(i<k){
                char temp = s[i];
                s[i] = s[k];
                s[k] = temp;
                i++;
                k--;
            }
            i=j;
            i++;
            j++;
        }
    }
}