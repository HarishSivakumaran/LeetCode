// 1345. Jump Game IV
// // a

class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        HashSet<Integer> visited = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], v -> new ArrayList()).add(i);
        }

        Queue<Integer> q = new LinkedList();
        q.add(0);
        int curr = 0, len = 0, steps = 0;

        while (q.size() > 0) {
            len = q.size();
            for (int i = 0; i < len; i++) {
                curr = q.poll();
                if (visited.contains(curr))
                    continue;
                visited.add(curr);
                if (curr == arr.length - 1)
                    return steps;
                if (curr + 1 < arr.length)
                    q.add(curr + 1);
                if (curr - 1 >= 0)
                    q.add(curr - 1);
                if (map.containsKey(arr[curr])) {
                    for (int j : map.get(arr[curr])) {
                        if (!visited.contains(j))
                            q.add(j);
                    }
                    map.get(arr[curr]).clear();
                }
            }
            steps++;
        }

        return -1;

    }

    // public int minJumpsDP(int index, int[] arr, HashMap<Integer, List<Integer>>
    // map, HashMap<String, Integer> cache, HashSet<Integer> visited, int prev){
    // if(index < 0 || index >= arr.length || visited.contains(index)) return
    // Integer.MAX_VALUE;
    // if(index == arr.length-1) return 0;
    // String key = index +"-"+prev;
    // if(cache.containsKey(key)) return cache.get(key);

    // visited.add(index);

    // int count = Integer.MAX_VALUE;

    // count = Math.min(count, Math.min(minJumpsDP(index+1, arr, map, cache,
    // visited, index), minJumpsDP(index-1, arr, map, cache, visited, index)));

    // if(map.containsKey(arr[index]) && count > 0){
    // for(int i : map.get(arr[index])){
    // if(i != index)
    // count = Math.min(count, minJumpsDP(i, arr, map, cache, visited, index));
    // if(count == 0) break;
    // }
    // }

    // if(count != Integer.MAX_VALUE)count++;

    // visited.remove(index);

    // cache.put(key, count);

    // return count;

    // }
}