// 345. Reverse Vowels of a String

class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int l = 0, r = s.length()-1;

        StringBuilder str = new StringBuilder(s);

        while(l < r){
            while(l < r && !vowels.contains(s.charAt(l)))l++;
            while(l < r && !vowels.contains(s.charAt(r)))r--;

            if(l >= r) break;

            char temp = s.charAt(l);
            str.setCharAt(l, s.charAt(r));
            str.setCharAt(r, temp);
            l++;
            r--;
        }

        return str.toString();
        
    }
}