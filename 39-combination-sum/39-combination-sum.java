class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        Set<List<Integer>> result = new LinkedHashSet<>();
        int sum = 0;
        List<Integer> temp = new ArrayList<>();
        backtrack(0, candidates, target, sum, result, temp);
        
        // convert set to list
        List<List<Integer>> output = new ArrayList<>();
        for(List<Integer> entry: result) {
            output.add(entry);
        }
        return output;
    }
    
    public void backtrack(int index, int[] A, int target, int sum, Set<List<Integer>> result, List<Integer> temp) {
        
        if(index == A.length) {
            return;
        }
        if(sum > target) {
            return;
        }
        if(sum == target) {
            Collections.sort(temp);
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=index; i< A.length; i++) {
            
            temp.add(A[i]);
            sum += A[i];
            backtrack(i, A, target, sum, result, temp);
            sum -= A[i];
            temp.remove(temp.size()-1);
            
        }
    }
}