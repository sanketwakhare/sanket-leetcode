class Solution {
    public int romanToInt(String s) {
        
        // build map
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        
        // initialize answer
        String[] strings = s.split("");
        int n = strings.length;
        int answer = map.get(strings[n-1]);
        
        // compare 2 adjacent values from end
        for(int i=n-2; i>=0; i--) {
            int value = map.get(strings[i]);
            int nextValue = map.get(strings[i+1]);
            if(nextValue > value) {
                // subtract
                answer = answer - value;
            } else {
                // add
                answer = answer + value;
            }
        }
        return answer;
    }
}

// M C M X C I V
// 1000 100 1000 10 100 1 5
    
//     1994

//     III
//     IV
    
//     1994
