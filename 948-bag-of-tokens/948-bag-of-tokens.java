class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        
        Arrays.sort(tokens);
        
        int start = 0;
        int end = tokens.length - 1;
        int points = 0;
        int max = 0;
        
        while(start <= end && (power >= tokens[start] || points > 0)) {
            
            while(start <= end && power >= tokens[start]) {
                power -= tokens[start];
                start++;
                points++;
            }
            
            max = Math.max(max, points);
            
            if(start <= end && points > 0) {
                power += tokens[end];
                end--;
                points--;
            }
        }
        
        return max;
        
    }
    
    // return f(tokens.length - 1, power, tokens);
    
//     public int f(int index, int power, int[] tokens) {
        
//         if(index < 0) {
//             return 0;
//         }
        
//         int pick = 0;
//         int faceUp = 0;
//         int faceDown = 0;
//         int dontPlay = 0;
//         // if(power > tokens[index]) {
//             // face-up
//             faceUp =  1 + f(index - 1, power - tokens[index], tokens);
//         // } else {
//             // face-down
//             faceDown = -1 + f(index - 1, power + tokens[index], tokens);            
//         // }
//         pick =  Math.max(faceUp, faceDown);
//         int dontPick = 0 + f(index - 1, power, tokens);
        
//         return Math.max(pick, dontPick);
//     }
}

// play
    // face-up - score++, power -= tokens[i]
    // face-down - score--, power += tokens[i] 
    // dont play
// cant play