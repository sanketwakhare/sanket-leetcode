class Solution {
    public List<String> removeAnagrams(String[] words) {
        
        List<String> result = new ArrayList<String>();
        Map<String, String> map = new HashMap<String, String>();
        
        char[] temp = words[0].toCharArray();
        Arrays.sort(temp);
        String nStr = new String(temp);
        map.put(nStr, words[0]);
        result.add(words[0]);
        
        for(int i=1; i<words.length; i++) {
            
            temp = words[i].toCharArray();
            Arrays.sort(temp);
            nStr = new String(temp);
            
            char[] tempPrev = words[i-1].toCharArray();
            Arrays.sort(tempPrev);
            String nStrPrev = new String(tempPrev);
            
            if(!nStrPrev.equals(nStr))
                    map.remove(nStrPrev);
                        
            if(!map.containsKey(nStr)) {                
                map.put(nStr, words[i]);
                result.add(words[i]);
            }
        }
        
        return result;
        
    }
}