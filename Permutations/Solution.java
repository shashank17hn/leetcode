/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 * */

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        boolean visited[] = new boolean[nums.length];
        helper(nums, 0, visited , new ArrayList<Integer>());
        return result;
    }

    private void helper(int nums[], int index , boolean visited[] , List<Integer> list){

        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
        }

        System.out.println(list);
        for(int i=0; i<nums.length ; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(nums[i]);
                System.out.println("added " + list);
                helper(nums, i+1, visited, list);
                visited[i] = false;
                list.remove(list.size()-1);
                System.out.println("remove " + list);
            }
        }
    }

//    using swap method
//     public List<List<Integer>> permute(int[] nums) {
//         result = new ArrayList<>();
//         List<Integer> list = new ArrayList();
//         for(int num : nums){
//             list.add(num);
//         }
//          //  System.out.println(list);
//          helper(0, list);
//         return result;
//     }

//     private void helper(int index , List<Integer>nums ){
//         if(index>nums.size()) {
//             return;
//         }
//         if(index== nums.size()){
//               result.add(new ArrayList<>(nums));
//         }
//         for(int i= index; i<nums.size(); i++){

//             Collections.swap(nums,index,i);
//             System.out.println(index + " - " +nums);
//             helper(index+1, nums);
//             Collections.swap(nums,index,i);
//         }
//                  System.out.println(index + "END");
//     }

}