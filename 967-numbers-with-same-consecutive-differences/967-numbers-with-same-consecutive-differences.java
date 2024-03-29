class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> result = new LinkedHashSet<>();
        for (int i = 1; i < 10; i++)
            backtrack(i, n, k, result);
        return result.stream().mapToInt(i -> i).toArray();
    }

    public void backtrack(int val, int n, int k, Set<Integer> result) {

        // convert to string value
        String nValue = String.valueOf(val);

        // when required number is formed, add it to result adn return
        if (nValue.length() == n) {
            // add
            result.add(val);
            return;
        }

        // compare last 2 digits of the new number
        int oldDigit = val % 10;
        for (int i = 0; i < 10; i++) {
            int newNumber = (val * 10 + i);
            int lastDigit = i;
            // consider only when difference is matching
            if (oldDigit - lastDigit == k) {
                backtrack(newNumber, n, k, result);
            }
            if (lastDigit - oldDigit == k) {
                backtrack(newNumber, n, k, result);
            }
        }
    }
}