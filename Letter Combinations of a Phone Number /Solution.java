/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * */

class Solution {

    List<String> result = new ArrayList<>();
    Map<Character, String> dict = new HashMap<>(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");

    }};
    char[] curr;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return result;
        }
        Stack<Character> stack = new Stack<>();
        curr = digits.toCharArray();
        letterCombination(0, stack);
        return result;

    }

    private void letterCombination(int index, Stack<Character> stack){
        if(index == curr.length){
            result.add(convertStackToString(stack));
            return;
        }

        char[] subCur = dict.get(curr[index]).toCharArray();
        for(Character c : subCur){
            stack.push(c);
            letterCombination(index+1, stack);
            stack.pop();
        }

    }

    private String convertStackToString(Stack<Character> stack){
        Iterator iterator = stack.iterator();
        StringBuilder result = new StringBuilder();
        while(iterator.hasNext()){
            result.append(iterator.next());
        }
        return result.toString();
    }

}