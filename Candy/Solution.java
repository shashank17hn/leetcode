/**
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 * Example 1:
 *
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * Example 2:
 *
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 * */

class Solution {
    public int candy(int[] ratings) {

        int leftPass[] = new int[ratings.length];
        int rightPass[] = new int[ratings.length];
        Arrays.fill(leftPass,1);
        Arrays.fill(rightPass,1);
        int count =0;
        // look for left
        for(int i =0 ; i<leftPass.length-1 ; i++){
            if(ratings[i+1]>ratings[i]){
                leftPass[i+1] = leftPass[i] +1;
            }
            // System.out.println("left " + leftPass[i+1] + " x " + ratings[i] + " " + ratings[i+1] );
        }

        // look for right
        for(int i = rightPass.length-2 ; i>=0 ; i--){
            if(ratings[i]>ratings[i+1]){
                rightPass[i] = rightPass[i+1] +1;
            }
            //  System.out.println(rightPass[i] );
        }


        for(int i =0 ; i<ratings.length; i++){
            count += Math.max(leftPass[i], rightPass[i]);
        }
        return count;
    }
}