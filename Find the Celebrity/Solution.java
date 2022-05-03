/**
 * You are given a helper function bool knows(a, b) that tells you whether A knows B. Implement a function int findCelebrity(n). There will be exactly one celebrity if they are at the party.
 *
 * Return the celebrity's label if there is a celebrity at the party. If there is no celebrity, return -1.
 *
 * Input: graph = [[1,1,0],[0,1,0],[1,1,1]]
 * Output: 1
 * Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j, otherwise graph[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 because both 0 and 2 know him but 1 does not know anybody.
 *
 * Input: graph = [[1,0,1],[1,1,0],[0,1,1]]
 * Output: -1
 * Explanation: There is no celebrity.
 * **/

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        System.out.println("n " + n);
        int possible = 0;
        for(int i =0 ;i< n ;i++){
            if(i!=possible && knows(possible, i)){
                possible = i;
            }
        }
        System.out.println("possible " + possible);
        return isCelebrity(n, possible);
    }
    private int isCelebrity( int n ,int possible){
        for(int i =0 ; i<n ; i++){
            System.out.println("possible " + knows(i, possible));
            if(i == possible) continue;
            else if(knows(possible, i)||!knows(i, possible)){
                return -1;
            }
        }
        return possible;
    }
}