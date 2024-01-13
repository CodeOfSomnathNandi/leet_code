import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class MajorityElementFinder {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> dupMap = new HashMap<>();
        Arrays.stream(nums).parallel().forEach(num -> {
            dupMap.merge(num, 1, Integer::sum);
        });
        int max_value = Collections.max(dupMap.values());
        int return_key = 0;
        for (var key : dupMap.keySet()) {
            Integer value = dupMap.get(key);
            if (value == max_value) {
                return_key = key;
            }
        }
        return return_key;
    }
}
