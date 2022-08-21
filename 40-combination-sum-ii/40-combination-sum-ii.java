class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        Set<List<Integer>> set = new LinkedHashSet<>();
        List<Integer> temp = new ArrayList<>();
        
        backtrack(0, candidates, target, 0, set, temp);
        
        List<List<Integer>> result = new LinkedList<>();
        for(List<Integer> entry: set) {
            result.add(entry);
        }
        return result;
    }
    
    public void backtrack(int index, int[] A, int target, int sum, Set<List<Integer>> set, List<Integer> temp) {
        
        if (sum == target) {
            set.add(new ArrayList<>(temp));
            return;
        }
        if (index == A.length) {
            return;
        }

        for (int i = index; i < A.length; i++) {
            // stop when same adjacent element is present
            if(i > index && A[i] == A[i-1]) continue;
            // stop when sum + A[i](pick value) will be > target
            if (sum + A[i] > target) {
                break;
            }
            // pick
            temp.add(A[i]);
            sum += A[i];
            backtrack(i + 1, A, target, sum, set, temp);
            sum -= A[i];
            temp.remove(temp.size() - 1);
        }
    }
}