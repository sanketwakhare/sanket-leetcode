class Solution {
    public int maxProduct(String[] words) {
        
        // step 1: Build Map of character set for every word
        Map<String, Set<Character>> map = new HashMap<>();
        for(int i=0; i < words.length; i++) {
            String word = words[i];
            Set<Character> set = new HashSet<Character>();
            for(int j=0; j< word.length(); j++) {
                set.add(word.charAt(j));
            }
            map.put(word, set);
        }
        // System.out.println(map);
        
        int maxProd = 0;
        // Compare every word with another
        for(int i=0; i< words.length-1; i++) {
            String word1 = words[i];
            Set<Character> word1Chars = map.get(word1);
            for(int j=i+1;j<words.length; j++) {
                
                String word2 = words[j];
                Set<Character> word2Chars = map.get(word2);
                
                boolean characterMatch = false;
                for(Character ch : word2Chars) {
                    if(word1Chars.contains(ch)) {
                        // if any of the character is matching, do not consier this pair
                        characterMatch = true;
                        break;
                    }
                }
                if(characterMatch) continue;
                 // consider this pair
                maxProd = Math.max(maxProd, word1.length() * word2.length());
                // System.out.println(word1);
                // System.out.println(word2);
                // System.out.println(word1.length() * word2.length());
            }
        }
        return maxProd;
        
    }
}