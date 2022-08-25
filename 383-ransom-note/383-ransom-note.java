class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // build frequency map with magazine word
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< magazine.length(); i++)  {
            char ch = magazine.charAt(i);
            int freq = map.getOrDefault(ch, 0);
            map.put(ch, freq + 1);
        }
        // iterate over ransomeNote word and check if it can be formed by characters in magazine word
        for(int i=0; i< ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            int freq = map.getOrDefault(ch, 0);
            // if current character can not be formed, return false
            if(freq == 0) {
                return false;
            }
            map.put(ch, freq - 1);
        }
        // ransomWord can be formed by using characters in magazine
        return true;
    }
}