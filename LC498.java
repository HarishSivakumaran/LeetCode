// 498. Diagonal Traverse

class Solution {
    int[][] dir = { { -1, 1 }, { 1, -1 } }; // TR, BL
    int d = 0; // TL

    public int[] findDiagonalOrder(int[][] mat) {
        int[] out = new int[mat.length * mat[0].length];
        int r = 0, c = 0;
        int i = 0;

        while (i < out.length) {
            out[i++] = mat[r][c];
            int[] next = getNextPos(r, c, mat);
            if (next == null)
                break;
            r = next[0];
            c = next[1];
        }

        return out;
    }

    public int[] getNextPos(int r, int c, int[][] mat) {
        int nextRow = r + dir[d][0];
        int nextCol = c + dir[d][1];
        int[] res = null;

        if (checkifBound(nextRow, nextCol, mat)) {
            return new int[] { nextRow, nextCol };
        }

        // check for right
        int[] right = new int[] { r, c + 1 };
        // check for down
        int[] down = new int[] { r + 1, c };

        if (d == 0) {
            if (checkifBound(right[0], right[1], mat)) {
                res = new int[] { right[0], right[1] };
            }

            if (res == null && checkifBound(down[0], down[1], mat)) {
                res = new int[] { down[0], down[1] };
            }
        } else {
            if (checkifBound(down[0], down[1], mat)) {
                res = new int[] { down[0], down[1] };
            }

            if (res == null && checkifBound(right[0], right[1], mat)) {
                res = new int[] { right[0], right[1] };
            }
        }
        d = (d + 1) % dir.length;

        return res;

    }

    public boolean checkifBound(int r, int c, int[][] m) {
        return c >= 0 && c < m[0].length && r >= 0 && r < m.length;

    }
}