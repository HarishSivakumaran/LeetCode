// 904. Fruit Into Baskets

class Solution {
    public int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> lastChangeIndex = new HashMap();
        int start = 0, res = 0;
        for (int i = 0; i < fruits.length; i++) {
            if (lastChangeIndex.size() == 2 && !lastChangeIndex.containsKey(fruits[i])) {
                int oldKey = -1, newkey = fruits.length + 1;
                for (Map.Entry<Integer, Integer> curr : lastChangeIndex.entrySet()) {
                    if (oldKey == -1 || curr.getValue() < lastChangeIndex.get(oldKey)) {
                        newkey = oldKey;
                        oldKey = curr.getKey();
                    } else {
                        newkey = curr.getKey();
                    }
                }
                res = Math.max(res, i - start);
                start = lastChangeIndex.get(newkey);
                lastChangeIndex.remove(oldKey);
            }

            if (i == 0 || fruits[i - 1] != fruits[i]) {
                lastChangeIndex.put(fruits[i], i);
            }
        }

        res = Math.max(res, fruits.length - start);

        return res;

    }
}