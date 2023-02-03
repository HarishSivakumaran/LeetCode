// 482. License Key Formatting
// // 
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String str = String.join("", s.split("-"));
        StringBuilder out = new StringBuilder();

        int rem = str.length() % k;
        if (rem != 0) {
            out.append(str.substring(0, rem));
        }

        for (int i = rem; i < str.length(); i += k) {
            out.append(i > 0 ? "-" : "").append(str.substring(i, i + k));
        }

        return out.toString().toUpperCase();

    }
}