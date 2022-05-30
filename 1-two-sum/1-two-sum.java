class Solution {
    public int[] twoSum(int[] A, int target) {
        // Build HashMap on the Fly
        // HashMap<Element, Index>
        int[] output = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int firstEle = A[i];
            int secondEle = target - firstEle;
            if (map.containsKey(secondEle)) {
                output[0] = i;
                output[1] = map.get(secondEle);
                break;
            }
            map.put(firstEle, i);
        }

        return output;
    }
}