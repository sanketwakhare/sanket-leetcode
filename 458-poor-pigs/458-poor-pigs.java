class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        
        int pigs = 0;
        while(Math.pow(minutesToTest / minutesToDie + 1, pigs) < buckets ) {
            pigs++;
        }
        return pigs;
    }
}

// 60/15 = 4 + 1
    
//     2 => 2^0 = 1
    
//     2 0 = 1
//     2 1 = 2
//     2 2 = 4
    
//     1 2 
//     3 4