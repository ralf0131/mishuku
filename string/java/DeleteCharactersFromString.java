/**
 Given a char array A, remove all chars that appears in char array B.
 */

import java.util.HashMap;

public class DeleteCharactersFromString {

  public static void main(String[] args) {
    System.out.println(deleteChars("abcdefgh", "cd"));
  }

  /*
    test cases -> expected output
    null, null -> null
    empty array, null -> empty array
    "abc", null -> "abc"
    "simple test", "st" -> "imple e"
   */
  public static String deleteChars(String src, String toBeDelete) {
    if (null == src) return null;
    if (toBeDelete == null) return src;
    // convert toBeDelete to hash map
    HashMap<Character, Byte> toBeDeleteHashMap = new HashMap<Character, Byte>();
    for (int i = 0; i < toBeDelete.length(); i++) toBeDeleteHashMap.put(toBeDelete.charAt(i), null);
    StringBuilder sb = new StringBuilder();
    // iterate through arr and delete char in toBeDeleteHashMap
    for (int i = 0; i < src.length(); i++) {
      char c = src.charAt(i);
      if (!toBeDeleteHashMap.containsKey(c)) sb.append(c);
    }
    return sb.toString();
  }
}
