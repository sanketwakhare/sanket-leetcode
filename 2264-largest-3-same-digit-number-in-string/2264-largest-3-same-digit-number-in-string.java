class Solution {
    public String largestGoodInteger(String num) {
        StringBuilder output = new StringBuilder();
        char prevChar = num.charAt(0);
        int count = 1;
        for(int i=1; i<num.length(); i++) {
            char currChar = num.charAt(i);
            if(currChar != prevChar) {
                // if previous and current digits are different, reset count to 1
                prevChar = currChar;
                count = 1;
            } else {
                // if previous and current digit/character is same, increase the count
                count++;
            }
            if(count == 3) {
                // possible answer
                if("".equals(output.toString())) {
                    output = output.append(currChar);
                    output = output.append(currChar);
                    output = output.append(currChar);
                } else {
                    if(output.charAt(0) < currChar) {
                        // update answer when current digit > previous digit answer
                        output = new StringBuilder();
                        output = output.append(currChar);
                        output = output.append(currChar);
                        output = output.append(currChar);
                    }
                }                
            }
        }
        return output.toString();
    }
}