class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        String[] dictionary = new String[] {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        Map<String, Integer> map = new HashMap<>();
        for(String word: words) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< word.length(); i++) {
                sb.append(dictionary[word.charAt(i) - 'a']);
            }
            String key = sb.toString();
            int currFreq = map.getOrDefault(key, 0);
            map.put(key, currFreq + 1);
        }
        
        return map.size();
        
    }
}