import java.util.Arrays;
import java.util.LinkedList;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.stream(nums).forEach(list::add);
        for (int i = 0; i < k; i++) {
            var ele = list.removeLast();
            list.addFirst(ele);
        }
        var arr = Arrays.stream(list.toArray(Integer[]::new)).mapToInt(Integer::intValue).toArray();
        System.arraycopy(arr, 0, nums, 0, arr.length);
    }
}
