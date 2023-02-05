// 657. Robot Return to Origin

class Solution {
    int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public boolean judgeCircle(String moves) {
        int[] pos = { 0, 0 };
        for (int i = 0; i < moves.length(); i++) {
            int[] move = getPoints(moves.charAt(i));
            pos[0] += move[0];
            pos[1] += move[1];
        }

        return pos[0] == 0 && pos[1] == 0;

    }

    public int[] getPoints(char a) {
        switch (a) {
            case 'U':
                return dir[0];
            case 'D':
                return dir[1];
            case 'L':
                return dir[2];
            case 'R':
                return dir[3];
        }

        return new int[] { 0, 0 };
    }
}