/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * */
class Solution {
    public String decodeString(String s) {

        char words[] = s.toCharArray();
        Stack<Integer> nums = new Stack<>();
        Stack<String> result = new Stack<>();
        for(int i =0 ; i< words.length ; i++){
            System.out.println("words " + words[i]);
            System.out.println("nums " + nums);
            System.out.println("result "+result);
            if(Character.isDigit(words[i])){
                StringBuilder digit = new StringBuilder();
                while(Character.isDigit(words[i])){
                    digit.append(words[i]);
                    i++;
                }
                i--;
                nums.push(Integer.parseInt(digit.toString()));
            }else if(words[i] == '['){
                result.push(String.valueOf(words[i]));
            }else if(words[i] == ']'){
                StringBuilder sb = new StringBuilder();
                Stack<String> fix = new Stack<>();
                while(!result.peek().equals("[")){
                    fix.push(result.pop());

                }
                while(!fix.isEmpty()){
                    sb.append(fix.pop());
                }
                //  System.out.println("string " + sb.toString() + " " + result.peek());
                result.pop();
                StringBuilder temp = new StringBuilder();
                int limit = nums.pop();
                for(int j =0 ; j<limit; j++){
                    temp.append(sb.toString());
                }
                System.out.println("computation " +limit + " "  + sb.toString() + " " );
                result.push(temp.toString());
            }else{
                result.push(String.valueOf(words[i]));
            }
            System.out.println("after nums " + nums);
            System.out.println("after result "+result);
            System.out.println("---------");
        }

        StringBuilder sb = new StringBuilder();
        for(String str : result){
            sb.append(str);
        }
        return sb.toString();

    }
}