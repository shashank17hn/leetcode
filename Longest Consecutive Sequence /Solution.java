/**
 *Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * */

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length ==0) return 0;
        Set<Integer> set = new HashSet<>();
        int max =1;
        for(int i =0 ; i<nums.length ; i++){
            set.add(nums[i]);
        }
        int current =0 ;
        int count =0;
        for(int key : set){
            if(!set.contains(key-1)){
                current = key;
                count =1;
                while(set.contains(current+1)){
                    current = current+1;
                    count++;
                }
            }
            max = Math.max(count, max);

        }

        return max;
    }
}