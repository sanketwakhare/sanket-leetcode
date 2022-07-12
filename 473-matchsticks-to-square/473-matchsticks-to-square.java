class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        // edge case: when there are less than 4 matchsticks, we can not form square
        if(matchsticks.length <=3) return false;
        
        // find total sum of lengths of every matchsticks
        int sum = 0;
        for(int matchStick: matchsticks) {
            sum += matchStick;
        }
        
        // each side of square will have target length 
        // as we have to consider all the matchsticks to be part of square
        int target = sum / 4;
        // if sum can not be formed with 4 equal sides
        if(sum % 4 != 0) return false;
        
        // maintain the array of 4 sides
        int[] sides = new int[4];
        
        //sort array and start from max element to fail fast
        Arrays.sort(matchsticks);
        // apply backtracking
        return backtrack(matchsticks.length-1, matchsticks, target, sides);
        
    }
    
    public boolean backtrack(int index, int[] matchsticks, int target, int[] sides) {
        
        // if all matchsticks are considered, return true
        if(index < 0) return true;
        
        // consider every single matchstick to be part of each side
        for(int i=0; i<4; i++) {
            if(matchsticks[index] + sides[i] <= target) {
                sides[i] += matchsticks[index];
                if(backtrack(index - 1, matchsticks, target, sides)) return true;
                sides[i] -= matchsticks[index];
            }
        }
        return false;
    }
}

// 2 5 3 1 4 1 4 = 20 /4 = 5
    
// 2 3
// 5
    
    
// 1 1 2 2 2 2 2 3 5
    
    
// 2 2 2 2 2 2 2 2 = 16 /4 = 4
    
// 4 = sum 

// 1,1,2,2,2

//     0,0,0,0,2
//     0,0,0,2,0
//     0,0,0,2,2
//     0,0,2,0,0
//     0,0,2,2,0
    
//         1 2 3
        
//         0 0 0 
//         0 0 1 => 3
//         0 1 0    2   
//         0 1 1    5
//         1 0 0
//         1 0 1
//         1 1 0
//         1 1 1
        
        
        
        
        
        
        
        
        
        
        

    
