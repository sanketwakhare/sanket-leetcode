class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // combine words2 into single map or array of 26 characters
        Map<Character, Integer> words2Map = new HashMap<>();
        for (String word : words2) {
            getCharacterIntegerMap(word, words2Map);
        }

        List<String> result = new ArrayList<String>();
        // for every word in word1, create map and compare with words2Map
        for (String word : words1) {
            boolean isSubset = true;
            Map<Character, Integer> map1 = getCount(word);
            for (Map.Entry<Character, Integer> entry : words2Map.entrySet()) {
                char ch = entry.getKey();
                int freq = entry.getValue();
                if (!map1.containsKey(ch) || map1.get(ch) < freq) {
                    isSubset = false;
                    break;
                }
            }
            if (isSubset) {
                result.add(word);
            }
        }

        return result;
    }
    
    private Map<Character, Integer> getCount(String word) {
        Map<Character, Integer> map = new HashMap<>();
        return getCharacterIntegerMap(word, map);
    }

    private Map<Character, Integer> getCharacterIntegerMap(String word, Map<Character, Integer> map) {
        char[] chars = word.toCharArray();
        Map<Character, Integer> tempMap = new HashMap<>();
        for (char ch : chars) {
            if (tempMap.containsKey(ch)) {
                int currFreq = tempMap.get(ch);
                tempMap.put(ch, currFreq + 1);
            } else {
                tempMap.put(ch, 1);
            }
            if (map.containsKey(ch) && tempMap.get(ch) > map.get(ch)) {
                map.put(ch, tempMap.get(ch));
            } else if (!map.containsKey(ch)) {
                map.put(ch, tempMap.get(ch));
            }
        }
        return map;
    }
}