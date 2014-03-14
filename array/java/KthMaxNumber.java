/**
 * Problem statement:
 * Find the k-th max element in an unordered array
 * example array: 4, 6, 2, 8, 5, 9, 3
 * the 4th max number is 5
 * Solution: using divide and conquer concept.
 */

public class KthMaxNumber {

  public static void main(String[] args) {
    try {
      int[] arr = new int[]{4, 6, 2, -8, 5, 9, 3};
      System.out.println(findKthMax(arr, 0, arr.length-1, 4));
      System.out.println(findKthMax(arr, 0, arr.length-1, 1));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static int findKthMax(int[] arr, int start, int end, int kth) throws Exception {
    if (start < 0 || end < 0 || start > end || kth <= 0 || end - start < kth - 1) { 
      throw new Exception("invalid input: " + start + ", " + end + ", " + kth);
    }
    int mid = partition(arr, start, end);
    if (mid - start == kth - 1) return arr[mid]; // mid is the kth max number
    if (mid - start > kth - 1) return findKthMax(arr, start, mid-1, kth); // kth max number in left side
    return findKthMax(arr, mid+1, end, kth-mid-1); // kth max number in right side
  }

  public static int partition(int[] arr, int start, int end) {
    int pivot = arr[start];
    int i = start;
    int j = end;
    while (i < j) {
      while (arr[j] >= pivot && i < j) j--;
      while (arr[i] <= pivot && i < j) i++;
      if (i >= j) break;
      // exchange arr[i] and arr[j]
      swap(arr, i, j); 
    }
    swap(arr, start, j);
    return j;
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;
  }
}
