class Solution {
	HashMap<String, Integer> map = new HashMap();

	public int maxScore(int[] nums) {
		int gcd = 0;
		List<int[]> list = new ArrayList();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				gcd = getGcd(nums[i], nums[j]);
				list.add(new int[] { i, j, gcd });
			}
		}

		return getMax(list, new char[nums.length], 1);
	}

	public int getMax(List<int[]> nums, char[] lookup, int level) {
		int count = 0;
		String key = new String(lookup) + "-" + level;
		if (map.containsKey(key))
			return map.get(key);
		for (int i = 0; i < nums.size(); i++) {
			int[] curr = nums.get(i);
			if (lookup[curr[0]] == 1 || lookup[curr[1]] == 1)
				continue;
			lookup[curr[0]] = 1;
			lookup[curr[1]] = 1;
			count = Math.max(count, level * nums.get(i)[2] + getMax(nums, lookup, level + 1));
			lookup[curr[0]] = 0;
			lookup[curr[1]] = 0;
		}
		map.put(key, count);

		return count;
	}

	public int getGcd(int i, int j) {
		if (j == 0) {
			return i;
		}

		return getGcd(j, i % j);
	}
}