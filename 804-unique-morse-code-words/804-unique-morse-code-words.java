class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        String[] dictionary = new String[] {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        Set<String> set = new HashSet<>();
        for(String word: words) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< word.length(); i++) {
                sb.append(dictionary[word.charAt(i) - 'a']);
            }
            String key = sb.toString();
            set.add(key);
        }
        
        return set.size();
        
    }
}