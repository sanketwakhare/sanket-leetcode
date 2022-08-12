class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> winners = new TreeMap<>();
        Map<Integer, Integer> loosers = new TreeMap<>();
        
        for(int[] match: matches) {
            int winner = match[0];
            int looser = match[1];
            
            int currFreqWinner = winners.getOrDefault(winner, 0);
            winners.put(winner, currFreqWinner + 1);
            
            int currFreqLoser = loosers.getOrDefault(looser, 0);
            loosers.put(looser, currFreqLoser + 1);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> unDefeated = new ArrayList<>();
        List<Integer> lostExactlyOneMatch = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : winners.entrySet()) {
            int winner = entry.getKey();
            int matchesWon = entry.getValue();
            if(!loosers.containsKey(winner)) {
                unDefeated.add(winner);
            } 
        }
        
        for(Map.Entry<Integer,Integer> entry : loosers.entrySet()) {
            int looser = entry.getKey();
            int matchesLost = entry.getValue();
            if(matchesLost == 1) {
                lostExactlyOneMatch.add(looser);
            }
        }
        result.add(unDefeated);
        result.add(lostExactlyOneMatch);
        return result;
    }
}