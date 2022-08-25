class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< magazine.length(); i++)  {
            char ch = magazine.charAt(i);
            int freq = map.getOrDefault(ch, 0);
            map.put(ch, freq + 1);
        }
        for(int i=0; i< ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            int freq = map.getOrDefault(ch, 0);
            if(freq == 0) {
                return false;
            }
            map.put(ch, freq - 1);
        }
        return true;
    }
}