/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> data = new HashSet<>();
        int result[] = new int[k];
        int max = Integer.MIN_VALUE;
        for(int i =0 ; i< nums.length ; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
            if(max< map.get(nums[i])){
                max =map.get(nums[i]);
            }
        }

        Queue<Integer> queue = new PriorityQueue<>((a,b)-> map.get(a) - map.get(b));

        for(int i : map.keySet()){
            queue.add(i);
            if(queue.size()>k){
                queue.poll();
            }
        }

        int index =0;
        for(int i : queue){
            result[index] = i;
            index++;
        }
        return result;
    }
}