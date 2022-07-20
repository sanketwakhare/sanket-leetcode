class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        // build map
        Map<Character, List<Integer>> map = new HashMap();
        for (char i = 'a'; i <= 'z'; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            map.get(currChar).add(i);
        }

        int count = 0;
        // for every word
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            int prevIndex = -1;
            boolean isFound = true;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                List<Integer> list = map.get(ch);
                int nextIndex = ceil(list, prevIndex);
                if (nextIndex == -1) {
                    isFound = false;
                    break;
                }
                prevIndex = nextIndex;
            }
            if (isFound) {
                count++;
            }
        }
        return count;
    }
    
    public int ceil(List<Integer> list, int prevIndex) {

        int start = 0;
        int end = list.size() - 1;

        int answer = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) <= prevIndex) {
                start = mid + 1;
            } else {
                answer = list.get(mid);
                end = mid - 1;
            }
        }
        return answer;
    }
}

// 250000 => 2.5 * 10^5
// 5 * 10^4 => log N


// a 0
// b 1
// c 2
// d 3
// e 4
    

// map
// <char, []>
// d 0
// s 1
// a [2 7]
// h 3
// j [4 6]
// p 5
// u 8
// f 9
    
// ptr = 7
    
// ahjpja
// ==============================
// a -> []
// b -> ["b"]
// c -> []
// d -> []
// e -> []
// ...
// z -> []

// cnt = 3
// a  b  c  d  e
// ==============================













