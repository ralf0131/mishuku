/**
 given a non-empty zero-indexed array A consisting of N integers, returns the leader of array A.
 The leader of this array is the value that occurs in more than half of the elements of A.  
 Best Solutions: http://www.cs.utexas.edu/users/moore/best-ideas/mjrty/index.html
 */

public class FindMajorityNumber {

  public static void main(String[] args) {
    int[] arr1 = {4, 2, 2, 3, 2, 4, 2, 2, 6, 4};
    int[] arr2 = {100, 1, 1, 5, 1};
    System.out.println(findMajorityNumber(arr1));
    System.out.println(findMajorityNumber(arr2)); 
    System.out.println(myFindMajorityNumber(arr1));
    System.out.println(myFindMajorityNumber(arr2));
  }

  // need to modify input arr
  public static int myFindMajorityNumber(int[] arr) {
    assert(arr != null && arr.length > 0);
    int i = 0;
    for ( ; i < arr.length; i++) {
      if (arr[i] < 0) continue;
      int j = i + 1;
      while (j < arr.length && (arr[j] < 0 || arr[j] == arr[i])) j++;
      if (j == arr.length) break;
      arr[i] = -1;
      arr[j] = -1;
    }
    if (i < arr.length) return arr[i];
    else return -1;
  }
  
  // test cases -> expected output
  // 1. null -> invalid
  // 2. empty array -> invalid
  // 3. {4, 2, 2, 3, 2, 4, 2, 2, 6, 4} -> -1
  // 4. {100, 1, 1, 5, 1} -> 1
  // O(n) time, O(1) space
  public static int findMajorityNumber(int[] arr) {
    assert(arr != null && arr.length > 0);
    int candidate = -1;
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (candidate == -1) {
        candidate = arr[i];
        count++;
      }
      else if (candidate == arr[i]) count++;
      else {
        count--;
        if (count == 0) { 
          candidate = -1;
        }
      }
    }
    return candidate;
  }
}
