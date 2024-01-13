import java.util.*;
import java.util.stream.Collectors;

public class Remove_Duplicate_2 {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> dupMap = new HashMap<>();

        for (int num : nums) {
            if (dupMap.containsKey(num)) {
                int value = dupMap.get(num);
                value++;
                dupMap.put(num, value);
                continue;
            }
            dupMap.put(num, 1);
        }
        int count = 0;

        for (var key : dupMap.keySet().stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new))) {
            int value = dupMap.get(key);
            if (value <= 2) {
                for (int i = 0; i < value; i++) {
                    nums[count] = key;
                    count++;
                }
            } else {
                for (int i = 0; i < 2; i++) {
                    nums[count] = key;
                    count++;
                }
            }
        }
        return count;
    }
    public int remove(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).parallel()
                .forEach(num -> {
                    if (map.containsKey(num)) {
                        int value = map.get(num);
                        map.put(num, value+1);
                    } else {
                        map.put(num, 1);
                    }
                });

        final int[] count = {0};
        map.keySet().stream().sorted().parallel().forEach(num -> {
            int value = map.get(num);
            int range = Math.min(value, 2);
            for (int i = 0; i < range; i++) {
                nums[count[0]] = num;
                count[0]++;
            }
        });
        return count[0];
    }
}
