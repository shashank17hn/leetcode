/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Map<Integer,Integer> map = new TreeMap(Collections.reverseOrder());
        List<Integer> list = new ArrayList<>();
        int counter =0;
        int prev =0;
        for(int i=0 ; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            counter++;
            if(counter==k){
                //   System.out.println("befor " + map);
                for(int key : map.keySet()){
                    list.add(key);
                    break;
                }
                map.put(nums[prev], map.get(nums[prev])-1);
                if(map.get(nums[prev]) == 0){
                    map.remove(nums[prev]);
                }
                prev++;
                counter--;
                //    System.out.println("after " + map);
            }
        }

        int[] ans = new int[list.size()];
        for(int i=0 ;i< list.size(); i++){
            ans[i] =list.get(i);
        }

        return ans;

    }
}