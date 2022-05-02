class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result =nums[0];
        int start= 0;
        int tempStart = 0;
        int end =0;
        for(int i =1 ; i< nums.length ; i++){
            int tempMax= 0;

            // added in if block , just to track start and keep on storing tempstart and as result changes will resplace start value with
            // temp start value
            if(nums[i] > Math.max(nums[i] * max , nums[i]* min)){
                tempMax = nums[i];
                tempStart =i;
            }else{
                tempMax = Math.max(nums[i] * max , nums[i]* min);
            }

            int tempMin= Math.min(nums[i], Math.min(nums[i] * max , nums[i]* min));
            max = tempMax;
            min = tempMin;
            if(result < max){
                result = max;
                end =i;
                start = tempStart;
            }
        }
        System.out.println("cord " +  nums[start] + "," + nums[end]);
        return result;
    }

}