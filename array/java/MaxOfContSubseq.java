/** Problem statement:
 * maximum value of contiguous subsequence
 * sample input: 1, -2, 3, 10, -4, 7, 2, -5
 * sample output: 18 (subsequence: 3, 10, -4, 7, 2)
 */

public class MaxOfContSubseq {

  public static void main(String []args) {
    int[] A = {-2, 11, -4, 13, -5, 2};
    int[] B = {-15, 29, -36, 3, -22, 11, 19, -5};
    int[] C = {1, -2, 3, 10, -4, 7, 2, -5};
    int[] D = {-3, -4, -1, -2}; 
    System.out.println(maxSubseqSum(A));
    System.out.println(maxSubseqSum(B));
    System.out.println(maxSubseqSum(C));
    System.out.println(maxSubseqSum(D));
    System.out.println(maxSubseqSum2(A));
    System.out.println(maxSubseqSum2(B));
    System.out.println(maxSubseqSum2(C));
    System.out.println(maxSubseqSum2(D));
    System.out.println(maxSubseqSum3(A));
    System.out.println(maxSubseqSum3(B));
    System.out.println(maxSubseqSum3(C));
    System.out.println(maxSubseqSum3(D));
  }

  public static int maxSubseqSum(int []arr) {
    if (arr.length == 0) return 0;
    int max = 0;
    int index = 0;
    int temp = 0;
    while (index < arr.length) {
      // loop until negative number
      while (index < arr.length && arr[index] >= 0) {
        temp += arr[index];
        index++;
      }
      // compare with current max
      if (temp > max) max = temp;
      if (index >= arr.length) break;
      temp += arr[index];
      // reset temp to 0 if it becomes negative.
      if (temp < 0) temp = 0;
      index++;
    }
    return max;
  }

  // max[j] = max{ max[j-1], A[j] }
  public static int maxSubseqSum2(int []arr) {
    if (arr.length == 0) return 0;
    int max = 0;
    int temp = 0;
    for (int i=0; i<arr.length; i++) {
      if (arr[i] > 0) {
        temp += arr[i];
      } else if (temp + arr[i] > 0){
        temp += arr[i];
      } else {
        temp = 0;
      }
      if (temp > max) max = temp;
    }
    return max;
  }

  // simplied version
  public static int maxSubseqSum3(int []arr) {
    if (arr.length == 0) return 0;
    int max = arr[0]; // deal with all negative case
    int temp = arr[0];
    for (int i=0; i<arr.length; i++) {
      if (temp > 0) {
        temp += arr[i];
      } else {
        temp = arr[i];
      }
      if (temp > max) max = temp;
    }
    return max;
  } 
}
