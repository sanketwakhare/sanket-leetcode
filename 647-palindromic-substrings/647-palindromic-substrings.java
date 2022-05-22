class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        // max odd length palindrome
        for (int i = 0; i < s.length(); i++) {
            int cnt = expand(s, i, i);            
            count += cnt;
        }

        // max odd length palindrome
        for (int i = 0; i < s.length() - 1; i++) {
            int cnt = expand(s, i, i + 1);            
            count += cnt;
        }

        return count;
    }
    
    private int expand(String S, int start, int end) {
        int count = 0;
        while (start >= 0 && end < S.length() && S.charAt(start) == S.charAt(end)) {
            start--;
            end++;
            count++;
        }
        StringBuilder subString = new StringBuilder();
        for (int i = start + 1; i < end; i++) {
            subString.append(S.charAt(i));
        }
        return count;
    }
}