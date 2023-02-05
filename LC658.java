// 658. Find K Closest Elements

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> out = new ArrayList();
        Deque<Integer> finalIndices = new LinkedList();

        for (int i = 0; i < arr.length; i++) {
            int currDif = Math.abs(x - arr[i]);
            if (finalIndices.size() == k) {
                int firstIndex = finalIndices.getFirst();
                if (currDif < Math.abs(x - arr[firstIndex])) {
                    finalIndices.pollFirst();
                } else {
                    continue;
                }
            }
            finalIndices.addLast(i);

        }

        for (int i : finalIndices) {
            out.add(arr[i]);
        }
        return out;

    }
}