import java.util.HashMap;
import java.util.Arrays;

// Hashmap solution, this is fast but O(n) space used.

class twoSum {

    public int[] targetFinder(int[] input, int target) {
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();

        for(int i = 0; i < input.length; i++) {
            int remainder = target - input[i];
            if(dict.containsKey(remainder)) {
                return new int[]{i, dict.get(remainder)};
            } else {
                dict.put(input[i], i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        twoSum solution = new twoSum();
        int[] input = new int[]{2,7,11,15};
        int target = 17;
        System.out.println("The answer is:" + Arrays.toString(solution.targetFinder(input, target)));
    }
}