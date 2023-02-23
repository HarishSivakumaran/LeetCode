// 752. Open the Lock

class Solution {
    public int openLock(String[] deadends, String target) {
        int ans = 0;
        Queue<String> q = new LinkedList();
        HashSet<String> set = new HashSet();
        HashSet<String> visited = new HashSet();
        for (String d : deadends)
            set.add(d);
        q.add("0000");
        String curr = "";
        char[] arr = null;
        char temp;

        while (q.size() > 0) {
            int len = q.size();
            for (int j = 0; j < len; j++) {
                curr = q.poll();
                arr = curr.toCharArray();
                if (curr.equals(target))
                    return ans;
                if (visited.contains(curr) || set.contains(curr))
                    continue;
                visited.add(curr);

                for (int i = 0; i < 4; i++) {
                    temp = arr[i];
                    arr[i] = (char) ('0' + (((arr[i] - '0') + 9) % 10));
                    q.add(new String(arr));
                    arr[i] = (char) ('0' + (((arr[i] - '0') + 2) % 10));
                    q.add(new String(arr));
                    arr[i] = temp;
                }
            }
            ans++;
        }

        return -1;
    }
}