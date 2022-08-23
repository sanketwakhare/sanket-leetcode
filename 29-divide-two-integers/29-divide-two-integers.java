class Solution {
    public int divide(int dividend, int divisor) {
        
        if(dividend == Integer.MAX_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        if(dividend == Integer.MAX_VALUE && divisor==1)
            return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor==1)
            return Integer.MIN_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        return dividend/divisor;
        
        // boolean isNegative = false;
        // isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        // long dividendLong = dividend < 0 ? Long.valueOf(dividend) * -1 : Long.valueOf(dividend);
        // long divisorLong = divisor < 0 ? Long.valueOf(divisor) * -1 : Long.valueOf(divisor);
        // long count = 0;
        // while(dividendLong >= divisorLong) {
        //     dividendLong -= divisorLong;
        //     count++;
        // }
        // return isNegative ? (int)(-1 * count) : (int)count;
    }
}