/**
 * Problem statement:
 * Find the k-th max element in the union of two ordered array
 * example: 
 * A: 2, 4, 5, 9
 * B: 3, 6, 8
 * Output: the 4th max number is 5
 * Assume there is no duplicates.
 */

public class KthMinNumberInUnionOfTwoSortedArrays {

  public static void main(String[] args) {
    try {
      int[] A = new int[]{2, 5, 6};
      int[] B = new int[]{1, 3, 4, 7, 8};
      System.out.println(findKthMin1(A, B, 4));
      System.out.println(findKthMin1(A, B, 1));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // using merge sort like concept without copying the data, O(k) time, O(1) space.
  public static int findKthMin1(int[] A, int[] B, int k) throws Exception {
    if (A.length == 0 || B.length == 0 || k <= 0 || k > A.length + B.length) {
      throw new Exception("Invalid input.");
    }
    int lenA = A.length;
    int lenB = B.length;
    int i = 0, j = 0, count = 0, nthMax = 0;
    while (i < lenA && j < lenB && count < k) {
      if (A[i] > B[j]) {
        nthMax = B[j];
        j++;
      } else {
        nthMax = A[i];
        i++;
      }
      count++;
    }
    if (count == k) return nthMax;
    if (i == lenA) return B[k-i-1];
    else return A[k-j-1]; 
  }

}
