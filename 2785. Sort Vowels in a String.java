class Solution {
    public String sortVowels(String s) {
        int[] count = new int[200];
        char[] chars = s.toCharArray();
        for(char c : chars) {
            if(isVowel(c)) count[c-65]++;
        }

        for(int i = 0; i < chars.length; i++) {
            if(isVowel(chars[i])) {
                chars[i] = getVowel(count);
            }
        }

        return new String(chars);

    }

    private boolean isVowel(char a) {
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' ||
               a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U'; 
    }

    private char getVowel(int[] count) {
            if (count['A'-65] > 0 ) {count['A'-65]--; return 'A';}
            if (count['E'-65] > 0 ){ count['E'-65]--; return 'E';}
            if (count['I'-65] > 0 ) { count['I'-65]--; return 'I'; }
            if (count['O'-65] > 0 ) { count['O'-65]--; return 'O'; }
            if (count['U'-65] > 0 ) { count['U'-65]--; return 'U'; }
            if (count['a'-65] > 0 ) { count['a'-65]--; return 'a'; }
            if (count['e'-65] > 0 ) { count['e'-65]--; return 'e'; }
            if (count['i'-65] > 0 ) { count['i'-65]--; return 'i'; }
            if (count['o'-65] > 0 ) { count['o'-65]--; return 'o'; }
            if (count['u'-65] > 0 ) { count['u'-65]--; return 'u'; }

            return '#';
    }
}