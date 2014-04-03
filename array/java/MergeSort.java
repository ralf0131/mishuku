/**
 * Implementation of merge sort
 */

public class MergeSort {

  public static void main(String[] args) {
    int[] arr = {1, 8, 7, 3, 4, 6, 2, 5};
    for (int i=0; i < arr.length; i++) System.out.print(arr[i] + ", ");
    System.out.println();
    
    int[] sorted = mergesort(arr, 0, arr.length-1);
    for (int i=0; i < arr.length; i++) System.out.print(sorted[i] + ", ");
    System.out.println();
  }

  // this method use too much extra space
  // need to be improved later.
  public static int[] mergesort(int[] arr, int start, int end) {
    assert (start >= 0 && end >= 0 && start >= end && arr.length > 0);
    if (start == end) {
      int[] res = new int[1];
      res[0] = arr[start];
      return res;
    }
    int mid = start + (end - start) / 2;
    int[] A = mergesort(arr, start, mid);
    int[] B = mergesort(arr, mid+1, end);
    return merge(A, B);
  }

  public static int[] merge(int[] A, int[] B) {
    int i = 0;
    int j = 0;
    int k = 0;
    int[] res = new int[A.length+B.length];
    while (i < A.length && j < B.length) {
      if (A[i] < B[j]) {
        res[k++] = A[i++];
      } else {
        res[k++] = B[j++];
      }
    }
    if (i >= A.length) {
      while (j < B.length) res[k++] = B[j++];      
    } else {
      while (i < A.length) res[k++] = A[i++];
    }
    return res;
  }

}
