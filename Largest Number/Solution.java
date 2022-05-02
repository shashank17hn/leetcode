/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 *
 * Since the result may be very large, so you need to return a string instead of an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * */
class Solution {
    public String largestNumber(int[] nums) {

        String arr[] = new String[nums.length];
        for(int i =0; i< nums.length ; i++){
            arr[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(arr, (a,b)->{
            String order1 = a+b;
            String order2 = b+a;
            return order2.compareTo(order1);
        });

        if(arr[0].equals("0")){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i< arr.length ; i++){
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}