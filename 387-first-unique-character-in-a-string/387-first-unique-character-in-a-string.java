class Solution {
    public int firstUniqChar(String s) {
        
        // build map
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< s.length(); i++) {
            char ch = s.charAt(i);
            int currFreq = map.getOrDefault(ch, 0);
            map.put(ch, currFreq + 1);
        }
        
        // find first non repeating character
        for(int i=0; i< s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) return i;
        }
        // return -1 if no non repeating character found
        return -1;
    }
}