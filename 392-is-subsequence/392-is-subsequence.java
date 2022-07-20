class Solution {
    public boolean isSubsequence(String s, String t) {
        int lastIndex = -1;
        for(int index = 0; index< s.length(); index++) {
            if(lastIndex == t.length()-1) return false;
            boolean found = false;
            for(int j=lastIndex+1; j< t.length(); j++) {
                if(s.charAt(index) == t.charAt(j)) {
                    lastIndex = j;
                    found = true;
                    break;
                }
            }
            if(found == false) return false;
        }
        return true;
    }
}