class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> freqMap = new HashMap<>();
        Set<String> bannedWords = new HashSet<>();

        for(String word: banned) {
            bannedWords.add(word);
        }

        String mostFrequentWord = "";
        int maxFreq = 0;
        String[] words = paragraph
            .replaceAll("[^a-zA-Z0-9 ]", " ").split("\\s+");
        System.out.println(Arrays.toString(words));
        for(String word: words) {
            word = word.toLowerCase();
            if(!bannedWords.contains(word)) {
                int currFreq = freqMap.getOrDefault(word, 0) + 1;
                freqMap.put(word, currFreq);
                if(currFreq > maxFreq) {
                    mostFrequentWord = word;
                    maxFreq = currFreq;
                }
            }
        }
        return mostFrequentWord.toLowerCase();
    }
}