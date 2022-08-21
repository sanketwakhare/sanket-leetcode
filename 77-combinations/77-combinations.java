class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(1, n, k, result, temp);
        return result;
    }
    
    public void backtrack(int curr, int n, int k, List<List<Integer>> result, List<Integer> temp) {
        if(temp.size() == k) {
            result.add(new ArrayList<>(temp));
           return;
        }
        
       for(int i= curr; i <= n; i++) {
           temp.add(i);
           backtrack(i+1, n, k, result, temp);
           temp.remove(temp.size() - 1);
       }
    }
}