// 1431. Kids With the Greatest Number of Candies

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;

        for (int c : candies) {
            max = Math.max(max, c);
        }

        List<Boolean> res = new ArrayList();

        for (int i = 0; i < candies.length; i++) {
            res.add(candies[i] + extraCandies >= max);
        }

        return res;
    }
}