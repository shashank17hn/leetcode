/**
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 * Example 1:
 *
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * Example 2:
 *
 * Input: n = 0
 * Output: 0
 * Example 3:
 *
 * Input: n = 1
 * Output: 0
 *
 * */
class Solution {
    public int countPrimes(int n) {
        if(n<2) return 0;
        int count =0;
        boolean prime[] = new boolean[n];
        Arrays.fill(prime,true);
        for(int i=2 ; i<=(int)Math.sqrt(n) ; i++){
            if(prime[i]){
                for(int j=i*i ; j<n ; j += i){
                    prime[j] =false;
                }
            }
        }

        for(int i=2 ; i< prime.length ; i++){
            if(prime[i]){
                count++;
            }
        }
        return count;
    }
}