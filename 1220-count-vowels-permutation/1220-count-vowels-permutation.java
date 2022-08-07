class Solution {
    public int countVowelPermutation(int n) {
        
        // base case
        if(n == 1) return 5;
        
        Map<Character, List<Character>> charMap = new HashMap<>();
        Map<Character, Integer> countMap = new HashMap<>();
        
        // build charMap based on conditions given in questions
        charMap.put('a',List.of('e'));
        charMap.put('e',List.of('a', 'i'));
        charMap.put('i',List.of('a', 'e', 'o', 'u'));
        charMap.put('o',List.of('i', 'u'));
        charMap.put('u',List.of('a'));
        
        // initialize countMap
        countMap.put('a', 1);
        countMap.put('e', 1);
        countMap.put('i', 1);
        countMap.put('o', 1);
        countMap.put('u', 1);
        
        long p = 1000000007;
        
        for(int i=2; i<=n; i++) {
            
            Map<Character, Integer> tempCountMap = new HashMap<>();
            tempCountMap.put('a', 0);
            tempCountMap.put('e', 0);
            tempCountMap.put('i', 0);
            tempCountMap.put('o', 0);
            tempCountMap.put('u', 0);
            
            for(Map.Entry<Character, List<Character>> entry : charMap.entrySet()) {
                char ch = entry.getKey();
                List<Character> values = entry.getValue();
                for(Character currCh : values) {
                    long newCount = (countMap.get(ch) % p + tempCountMap.get(currCh) % p ) % p;
                    tempCountMap.put(currCh, (int)newCount);
                }
            }
            countMap = tempCountMap;
        }
        long answer = 0;
        
        for(Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            char ch = entry.getKey();
            Integer value = entry.getValue();
            answer = ( answer % p + value % p ) % p;
            // System.out.println(ch + "->" + value);
        }
        
        return (int)answer;
    }
}