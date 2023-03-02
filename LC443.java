// 443. String Compression

class Solution {
    public int compress(char[] chars) {
        int insertPos = 0;
        Integer[] pair = new Integer[2];
        for (int j = 0; j <= chars.length; j++) {
            char a = j < chars.length ? chars[j] : (char) (chars[j - 1] + 100);

            if (pair[0] != null) {
                char toCheck = (char) (pair[0] + 'a');
                if (toCheck == a) {
                    pair[1]++;
                    continue;
                } else {
                    chars[insertPos] = toCheck;
                    if (pair[1] > 1) {

                        for (char b : Integer.toString(pair[1]).toCharArray()) {
                            chars[++insertPos] = b;
                        }
                    }
                    pair[0] = null;
                    insertPos++;
                }
            }

            pair[0] = a - 'a';
            pair[1] = 1;
        }

        return insertPos;
    }
}