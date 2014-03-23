/**
 * Problem statement: 
 * given two integer arrays val[0..n-1] and wt[0..n-1],
 * which represent values and weights associated with n items respectively.
 * Also given an integer W which represents knapsack capacity,
 * find out the maximum value subset of val[]
 * such that sum of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 * Solution: 0-1 knapsack problem.
 * using dyanamical programming.
 * resuisive formual:
 * let M[i][j] be the max value for choosing the 1..i items to fit into j weight knapsack.
 * then M[i][j] = 0 if i = 0 or j = 0
 *              = M[i-1][j] if weight[i] > j, the i-th item can not be put into j weight knapsack.
 *              = max(M[i-1][j], M[i-1][j-weight[i]]+val[i]) if weight[i] <= j,
 * in the last case, M[i][j] is max of:
 * 1) not including the i-th item
 * 2) including the i-th item
 */


public class ZeroOneKnapsack {

  public static void main(String []args) {
    int[] val = {3, 2, 1, 4};
    int[] weights = {2, 1, 3, 2};
    System.out.println(findMaxValue(val, weights, 5));
  }

  public static int findMaxValue(int[] val, int[] weights, int W) {
    if (val.length != weights.length || W <= 0) return 0;
    int n = val.length;
    int[][] maxTable = new int[n+1][W+1];
    
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= W; j++) {
         if (i == 0 || j == 0) maxTable[i][j] = 0;
         // note that val and weights start from 0
         else if (weights[i-1] > j) maxTable[i][j] = maxTable[i-1][j];
         else maxTable[i][j] = Math.max(maxTable[i-1][j], maxTable[i-1][j-weights[i-1]]+val[i-1]);
      }
    }
    return maxTable[n][W];
  }
}
