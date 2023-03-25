// 881. Boats to Save People

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int l = 0, r = people.length - 1, res = 0;

        Arrays.sort(people);

        while (l <= r) {
            if (people[r] > limit) {
                r--;
                continue;
            }
            if (people[r] + people[l] <= limit) {
                res++;
                l++;
                r--;
            } else if (people[r] <= limit) {
                res++;
                r--;
            }
        }

        return res;

    }
}