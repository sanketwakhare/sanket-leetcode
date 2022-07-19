class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList();
        
        result.add(List.of(1));
        for(int i=1; i< numRows; i++) {
            
            List<Integer> curr = new ArrayList();
            List<Integer> prev = result.get(result.size()-1);
            
            for(int index=0; index< prev.size(); index++) {
                if(index == 0) {
                    curr.add(prev.get(index));
                } else {
                    curr.add(prev.get(index-1) + prev.get(index));
                }
            }            
            curr.add(1);
            result.add(curr);
        }
        return result;        
    }
}