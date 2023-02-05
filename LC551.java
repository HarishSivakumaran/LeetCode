// 551. Student Attendance Record I

class Solution {
    public boolean checkRecord(String s) {
        int countA = 0, countL = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                countL++;
                if (countL == 3)
                    return false;
                continue;
            }
            if (s.charAt(i) == 'A') {
                countA++;
                if (countA > 1)
                    return false;
            }
            countL = 0;
        }

        return true;

    }
}