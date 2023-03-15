// 983. Minimum Cost For Tickets

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        return getMinAmount(days, costs, 0, new HashMap());
    }

    public int getMinAmount(int[] days, int[] costs, int i, HashMap<Integer, Integer> cache) {
        if (i >= days.length)
            return 0;

        if (cache.containsKey(i))
            return cache.get(i);

        int amt = Integer.MAX_VALUE;

        amt = Math.min(amt, costs[0] + getMinAmount(days, costs, i + 1, cache));

        int j = i;

        while (j < days.length && days[j] <= days[i] + 6) {
            j++;
        }

        amt = Math.min(amt, costs[1] + getMinAmount(days, costs, j, cache));

        while (j < days.length && days[j] <= days[i] + 29) {
            j++;
        }

        amt = Math.min(amt, costs[2] + getMinAmount(days, costs, j, cache));

        cache.put(i, amt);

        return amt;

    }
}