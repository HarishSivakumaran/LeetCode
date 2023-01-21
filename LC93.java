// 93. Restore IP Addresses

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> out = new ArrayList();

        if(s.length() < 4 || s.length() > 12) return out;  

        getIPAddr(s, out, 0, 0, new StringBuilder());     

        return out;
      
    }

    public void getIPAddr(String s, List<String> out, int i, int dots, StringBuilder str){
        if(i >= s.length()){
            if(dots >= 4) out.add(str.substring(0,str.length()-1)); // remove the last dot
            return;
        }

        if(dots >= 4) return;
        
        for(int j = i; j < i+3; j++){
            if(j >= s.length()) continue;
            String subStr = s.substring(i, j+1);
            int pos = str.length();
            if(validatePart(subStr)){
                str.append(subStr).append(".");
                dots++;
                getIPAddr(s, out, j+1, dots , str);
                str.replace(pos, str.length(), "");
                dots--;
            }
        }
    }

    public boolean validatePart(String s){
        if(s.length() == 1) return true;

        if(s.charAt(0) == '0' || Integer.parseInt(s) > 255) return false;
        
        for(int i = 0; i < s.length(); i++){
            if((s.charAt(i)-'0') > 9) return false;
        }

        return true;
    }
}