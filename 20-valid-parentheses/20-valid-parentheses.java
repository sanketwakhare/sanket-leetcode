class Solution {
    public boolean isValid(String s) {
        
        List<Character> list = new ArrayList<Character>();
        boolean isValid = true;
        
        for(int i=0; i<s.length(); i++) {
            char currChar = s.charAt(i);
            
            if(currChar == '(' || currChar == '{' || currChar == '[') {
                // insert into list
                list.add(currChar);
            } else if(currChar == ')') {
                if(list.size()>0 && list.get(list.size()-1) == '(') {
                    // valid
                    list.remove(list.size()-1);
                } else {
                    // invalid
                    isValid = false;
                    break;
                }
            } else if(currChar == '}') {
                if(list.size()>0 && list.get(list.size()-1) == '{') {
                    // valid
                    list.remove(list.size()-1);
                } else {
                    // invalid
                    isValid = false;
                    break;
                }
            } else if(currChar == ']') {
                if(list.size()>0 && list.get(list.size()-1) == '[') {
                    // valid
                    list.remove(list.size()-1);
                } else {
                    // invalid
                    isValid = false;
                    break;
                }
            }
        }
        
        if(list.size() > 0) isValid = false;
        
        return isValid;
    }
}