class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = List.of(1);
        List<Integer> curr = new ArrayList();
        
        for(int i=1; i <= rowIndex; i++) {
            
            for(int index=0; index< prev.size(); index++) {
                if(index == 0) {
                    curr.add(prev.get(index));
                } else {
                    curr.add(prev.get(index-1) + prev.get(index));
                }
            }            
            curr.add(1);
            
            prev = new ArrayList();
            prev.addAll(curr);
            curr = new ArrayList();
        }
        return prev; 
    }
}