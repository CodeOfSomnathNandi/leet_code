import java.util.HashMap;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 */
public class AnagramFinder {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> sCharCount = new HashMap<>();
        HashMap<Character, Integer> tCharCount = new HashMap<>();
        Integer value;
        char sc, tc;


        for (int i = 0; i < s.length(); i++) {
            sc = s.charAt(i);
            tc = t.charAt(i);

            if (!sCharCount.containsKey(sc)) {
                sCharCount.put(sc, 1);
            } else {
                value = sCharCount.get(sc);
                sCharCount.put(sc, value+1);
            }

            if (!tCharCount.containsKey(tc)) {
                tCharCount.put(tc, 1);
            } else {
                value = tCharCount.get(tc);
                tCharCount.put(tc, value+1);
            }
        }

        return sCharCount.equals(tCharCount);
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        AnagramFinder finder = new AnagramFinder();
        boolean is = finder.isAnagram(s, t);
        System.out.println(is);
    }
}
