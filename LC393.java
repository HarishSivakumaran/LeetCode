// 393. UTF-8 Validation

class Solution {
    public boolean validUtf8(int[] data) {
        for(int i = 0; i < data.length; i++){
            int bytes = this.getBytes(data[i]);
            if(bytes == -1 || bytes > 3) return false;
            if(i + bytes >= data.length) return false;
            int j = i + 1;
            for(; j <= i + bytes; j++){
                if(!checkStart(data[j])) return false;
            }
            i = i + bytes;
        }

        return true;
        
    }

    public int getBytes(int n){
        for(int i = 0; i < 8; i++){
            int j = n & (int)Math.pow(2,7-i);
            if(j == 0){
                if(i == 0) return 0;
                if(i == 1) return -1;
                return i - 1;
            }
        }

        return 7;
    }

    public boolean checkStart(int n){
        return (n & 192) == 128;
    }

    
}