class Solution {
    public boolean validUtf8(int[] data) {
        int i = 0;
        while(i < data.length) {            
            if ((data[i]>>7) == 0) i++;
            else if((data[i]>>5) == 6  && i+1 < data.length && (data[i+1]>>6) == 2) i += 2;
            else if((data[i]>>4) == 14 && i+2 < data.length && (data[i+1]>>6) == 2 && (data[i+2]>>6) == 2) i += 3;
            else if((data[i]>>3) == 30 && i+2 < data.length && (data[i+1]>>6) == 2 && (data[i+2]>>6) == 2 && (data[i+3]>>6) == 2) i += 4;
            else return false;
        }    
        return true; 
    }
}