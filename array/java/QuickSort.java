/**
 * Implementation of in place quick sort
 * use the start index as pivot
 * partition the array into two: 
 * all elements in left are less than pivot,
 * and all elements in right are larger than pivot.
 */

public class QuickSort {

  public static void main(String[] args) {
    int[] arr = {1, 8, 7, 3, 4, 6, 2, 5};
    for (int i=0; i < arr.length; i++) System.out.print(arr[i] + ", ");
    System.out.println();
    
    quicksort(arr);
    for (int i=0; i < arr.length; i++) System.out.print(arr[i] + ", ");
    System.out.println();
  }

  public static void quicksort(int[] arr) {
    sort(arr, 0, arr.length-1);
  }

  public static void sort(int[] arr, int start, int end) {
    if (start > end) return;
    int mid = partition(arr, start, end);
    sort(arr, start, mid - 1);
    sort(arr, mid + 1, end);
  }

  public static int partition(int[] arr, int start, int end) {
    int pivot = arr[start];
    int i = start;
    int j = end;
    while (i < j) {
      while (arr[j] >= pivot && i < j) j--; // find element less than pivot
      while (arr[i] <= pivot && i < j) i++; // find element larger than pivot
      if (i < j) swap(arr, i, j); // exchange the two elements
    }
    // after the loop, j points to the last elements that less that pivot
    swap(arr, start, j); // exchange j and pivots
    return j; // for each k > j, arr[k] > arr[j] 
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
