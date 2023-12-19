class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] newImg = new int[img.length][img[0].length];
        int[][] dir = { {0,0}, { -1,0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1} };
        for(int r = 0; r < img.length; r++) {
            for(int c = 0; c < img[0].length; c++) {
                int co = 0, s = 0;
                for(int[] d : dir) {
                    int nextR = r + d[0], nextC = c + d[1];
                    if(nextR >= 0 && nextR < img.length && nextC >= 0 && nextC < img[0].length) {
                        co++;
                        s += img[nextR][nextC];
                    }
                }

                newImg[r][c] = s/co;
            }
        }

        return newImg;
    }
}