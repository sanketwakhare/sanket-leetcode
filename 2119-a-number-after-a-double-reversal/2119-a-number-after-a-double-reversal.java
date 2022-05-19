class Solution {
    public boolean isSameAfterReversals(int num) {
        
        int tempNum = num;
        // reverse num
        int reversed1 = reverse(tempNum);
        int reversed2 = reverse(reversed1);
        
        System.out.println(reversed1);
        System.out.println(reversed2);
        return reversed2 == num;
        
    }
    
    public int reverse(int tempNum) {
        int reversed1 = 0;
        int cnt = 0;
        while(tempNum > 0) {
            int lastDigit = tempNum % 10;
            tempNum = tempNum / 10;
            reversed1 = (reversed1 * 10) + lastDigit;
        }
        return reversed1;
    }
}